/**
 * 
 */
package com.ljproject.controller;

import java.beans.PropertyEditorSupport;



import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ljproject.model.Role;
import com.ljproject.model.User;
import com.ljproject.service.RoleService;
import com.ljproject.service.UserService;





/**
 * @author Nitesh
 *
 */
@Controller
public class UserController {
	
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;
	
	
	@RequestMapping(value="admin/addUser", method=RequestMethod.POST)
	public ResponseEntity<HttpStatus> addUser(HttpSession session, @Valid @ModelAttribute("newUser") User user, BindingResult result) {
		if(result.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			result.getFieldErrors().forEach(error -> {
				sb.append("* ");
				sb.append(error.getDefaultMessage());
				sb.append("</br>");
			});
			session.setAttribute("errorMsg", sb.toString());
		} else session.setAttribute("status",userService.saveUser(user));
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
	
	
	/*@RequestMapping(value="admin/addUser", method = RequestMethod.POST)
	public  String addUser(HttpSession session, @Valid @ModelAttribute("newUser") User user, BindingResult result){
		
		userService.addUser(user);
				
		return "/dashboard";
	}*/
	
	@GetMapping("/edituser/{id}")
	public String userOne(@PathVariable Long id, Model model) {
		model.addAttribute("isNew", false);
		model.addAttribute("userForm", userService.findById(id));
		model.addAttribute("roles", userService.roleList());
		return "user/form";
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
