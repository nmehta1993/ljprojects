/**
 * 
 */
package com.ljproject.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ljproject.model.DemoUser;
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
public class DemoUserController {
	
	public static final Logger logger = LoggerFactory.getLogger(DemoUserController.class);

	@Autowired
	DemoUserService demoUserService;
	
	@Autowired
	UserService userService;
	
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
	
	
	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid DemoUser demoUser, BindingResult bindingResult,Model model) {
		ModelAndView modelAndView = new ModelAndView();
		DemoUser userExists = demoUserService.findUserByEmail(demoUser.getEmail());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
					"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			
			
			modelAndView.setViewName("demoregistration");
			
			} else {

			char[] otp = otpService.genrateOtp();
			String convertedOtp = new String(otp);
			demoUser.setOtp(convertedOtp);
			demoUserService.saveUser(demoUser);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new DemoUser());
			modelAndView.setViewName("demoregistration");
		
		}
		
		return modelAndView;
	}
	
	
		
	}
	
	
	

