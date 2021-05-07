package com.ljproject.controller;

import java.beans.PropertyEditorSupport;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ljproject.dto.ChangePasswordDto;
import com.ljproject.dto.PasswordForgotDto;
import com.ljproject.exception.UserNotFoundException;
import com.ljproject.model.PasswordResetToken;
import com.ljproject.model.Role;
import com.ljproject.model.User;
import com.ljproject.model.UserProfile;
import com.ljproject.repository.PasswordResetTokenRepository;
import com.ljproject.service.DemoUserService;
import com.ljproject.service.RoleService;
import com.ljproject.service.UserProfileService;
import com.ljproject.service.UserService;
import com.ljproject.util.MailService;
import com.ljproject.util.OtpService;
import com.ljproject.util.TokenService;





@Controller
public class LoginController {
	
	 public static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private DemoUserService demoUserService;

	@Autowired
	private MailService mailService;

	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private RoleService roleService;
	
	
	@Autowired
	private UserProfileService userProfileService;
	
	

	
	@Autowired
	OtpService otpService;

	@Autowired
	PasswordResetTokenRepository passwordResetTokenRepository;

	 @RequestMapping(value = { "/admin/delete/{id}" }, method = RequestMethod.GET)
	 @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	    public String deleteUser(@PathVariable long id) {
	        userService.deleteUserById(id);
	        return "redirect:/list";
	    }
	
	@RequestMapping(value = "/reset/changePassword", method = RequestMethod.GET)
	public String changePassword(@RequestParam(required = false) String token, @RequestParam("id") long id,
			Model model) {
		model.addAttribute("changePassword", new ChangePasswordDto());
		String reStringsult = tokenService.validatePasswordResetToken(id, token);
		model.addAttribute("token", token);
		model.addAttribute("userid", id);
		if (reStringsult == null) {

			return "resetPassword";
		}

		return reStringsult;
	}

	@RequestMapping(value = { "/admin/updatePassword", "/user/updatePassword" }, method = RequestMethod.GET)
	public String updatePassword(@RequestParam(required = false) String token, Model model) {
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		logger.info(loggedInUser.getName());
		model.addAttribute("updatePassword", new ChangePasswordDto());
		return "updatePassword";
	}

	@RequestMapping(value = { "/admin/updatePassword", "/user/updatePassword" }, method = RequestMethod.POST)
	public String updatePass(@RequestParam(required = false) String token, Model model,
			@ModelAttribute("updatePassword") ChangePasswordDto changePasswordDto) {
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		logger.info("Thsi is testing api ------------------------------------");
		logger.info(loggedInUser.getName());
		return "updatePassword";
	}

	@RequestMapping(value = "/reset/submit", method = RequestMethod.POST)
	public String changePassword(@ModelAttribute("changePassword") ChangePasswordDto changePasswordDto,
			@RequestParam("token") String token, @RequestParam("userId") long userId) {
		PasswordResetToken ps = passwordResetTokenRepository.findByToken(token);

		User user = ps.getUser();
		user.setPassword(changePasswordDto.getPassword());


		if (changePasswordDto.getPassword().equals(changePasswordDto.getConfirmpasword())) {
			userService.saveUser(user);
		}
		logger.info("save successfully ");
		return "resetPassword";
	}

	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public String reset(@ModelAttribute("PasswordForgotDto") PasswordForgotDto passwordForgotDto)
			throws UserNotFoundException {
		User user = userService.findUserByEmail(passwordForgotDto.getEmail());
		if (user == null) {
			throw new UserNotFoundException();
		}
		String token = UUID.randomUUID().toString();
		logger.info(passwordForgotDto.getEmail());
		PasswordResetToken ps = new PasswordResetToken();
		ps.setUser(user);
		ps.setExpiryDate(1);
		ps.setToken(token);

		tokenService.sendRestLink(user, token);

		passwordResetTokenRepository.save(ps);
		return "forgotPassword";
	}
	
	

	
	

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, Model model, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();

		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
					"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {

			char[] otp = otpService.genrateOtp();
			String convertedOtp = new String(otp);
			user.setOtp(convertedOtp);
			Set<Role> roles= new HashSet<Role>();
			Role role=new Role();
			role.setRole("ROLE_ADMIN");
			roles.add(role);
			user.setRoles(roles);
			
			
			
			userService.saveUser(user);
			
			userService.sendEmailforApprove(user);
			mailService.sendEmail(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			
			modelAndView.setViewName("registration");

		}
		return modelAndView;
	}

	@RequestMapping(value = { "/test" }, method = RequestMethod.GET)
	public ModelAndView test() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/WEB-INF/views/test");
		return modelAndView;
	}

	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
		
	@RequestMapping(value = { "/adduserprofile" }, method = RequestMethod.POST)
	public String addUserprofile(@ModelAttribute("userprofile") UserProfile userProfile,Model model) {
		model.addAttribute("userprofile", userProfile);
		userProfileService.saveUserProfile(userProfile);
		return "dashboard";
	}
	@InitBinder(value="newUser")
	private void InitBinder(WebDataBinder binder){
		binder.registerCustomEditor(Role.class, new RoleValueBinder());
	}
	
	private class RoleValueBinder extends PropertyEditorSupport {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			setValue(roleService.findById(Integer.parseInt(text)));
		}
	}
	

}
