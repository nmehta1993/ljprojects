/**
 * 
 */
package com.ljproject.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ljproject.model.User;
import com.ljproject.model.UserProfile;
import com.ljproject.service.UserService;

/**
 * @author Nitesh
 *
 */
@Controller
public class FrontController {

	@Autowired
	private UserService userService;
	
	

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
		System.out.println("test");
		model.addAttribute("userprofile",userProfile);
	
		return "userprofile";
	}
	
	@GetMapping("/list")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public String userList(Model model) {
		model.addAttribute("users", userService.listUser());
		return "/user/list";
	}
	
	@GetMapping("/form")
	public String userForm(Model model) {
		model.addAttribute("isNew", true);
		model.addAttribute("userForm", new User());
		model.addAttribute("roles", userService.roleList());
	return "/user/form";
	}

	
}
