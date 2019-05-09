/**
 * 
 */
package com.ljproject.controller;

import java.beans.PropertyEditorSupport;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.ljproject.dto.PasswordForgotDto;
import com.ljproject.model.DemoUser;
import com.ljproject.model.Role;
import com.ljproject.model.Subscriber;
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

/**
 * @author Nitesh
 *
 */
@Controller
public class FrontController {
	
	 public static final Logger logger = LoggerFactory.getLogger(FrontController.class);

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
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "registration";
	}
	
	@RequestMapping(value = "/reg", method = RequestMethod.GET)
	public String demoregistration(ModelMap model) {
		DemoUser user= new DemoUser();
		model.addAttribute("demouser", user);
		model.addAttribute("roles", userService.roleList());
		return "demoregistration";
	}
	
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
	public String forgotPassword(ModelMap model) {
		model.addAttribute("PasswordForgotDto", new PasswordForgotDto());
		return "forgotPassword";
	}
	
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login() {
		logger.info("validation errors");
		
		return "/login";
	}

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String homePage() {
		logger.info("validation errors");
		return "home";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model,@ModelAttribute("subscribeModel") Subscriber subscriber) {
		model.addAttribute("user", getPrincipal());
		model.addAttribute("subscribeModel", subscriber);
			return "dashboard";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_USER')")
	public String userPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "welcome";
	}
	

	@RequestMapping(value = "/db", method = RequestMethod.GET)
	public String dbaPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "dba";
	}

	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}
	
	


	@RequestMapping(value = "/table", method = RequestMethod.GET)
	public String tablePage(Model model) {
		List<User> listuser = userService.listUser();
		model.addAttribute("listuser", listuser);
		return "table";
	}
	


	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboardPage(Model model) {

		return "dashboard";
	}

	@RequestMapping(value = "/typography", method = RequestMethod.GET)
	public String typographyPage(Model model) {

		model.addAttribute("user", getPrincipal());
		return "typography";
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

	@RequestMapping(value = "/icons", method = RequestMethod.GET)
	public String iconPage(Model model) {
		model.addAttribute("user", getPrincipal());
		return "icon";
	}

	@RequestMapping(value = "/maps", method = RequestMethod.GET)
	public String mapsPage(Model model) {
		model.addAttribute("user", getPrincipal());
		return "maps";
	}

	@RequestMapping(value = "/notifications", method = RequestMethod.GET)
	public String notificationPage(Model model) {
		model.addAttribute("user", getPrincipal());
		return "notifications";
	}
	
	@RequestMapping(value = "/userprofile", method = RequestMethod.GET)
	public String userProfile(@ModelAttribute("userprofile") UserProfile userProfile,Model model) {
		model.addAttribute("userprofile",userProfile);
		return "userprofile";
	}
	
	@GetMapping("/list")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public String userList(Model model) {
		model.addAttribute("users", userService.listUser());
		return "/user/list";
	}
	
	@GetMapping("address/list")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public String addressList(Model model) {
		
		return "/address/list";
	}
	
	
	@GetMapping("address/form")
	public String addressForm(Model model) {
		
		
	return "/address/form";
	}


	
	@GetMapping("/form")
	public String userForm(Model model) {
		model.addAttribute("isNew", true);
		model.addAttribute("userForm", new User());
		model.addAttribute("roles", userService.roleList());
	return "/user/form";
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
