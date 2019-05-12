/**
 * 
 */
package com.ljproject.controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ljproject.model.State;
import com.ljproject.model.Subscriber;
import com.ljproject.service.SubscriberService;
import com.ljproject.util.ErrorUtils;


/**
 * @author Nitesh
 *
 */
@Controller
public class SubscriberController {
	
	@Autowired
	SubscriberService subscriberService;
	
	@PostMapping(value = "/subscribe", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String addSubscriber(@Valid @RequestBody Subscriber subscriber, BindingResult result,Model model) {

		if (result.hasErrors()) {
			return ErrorUtils.customErrors(result.getAllErrors());
		} else {
			
			subscriberService.saveSubscriber(subscriber);
			model.addAttribute("message", "subscribe succsess fully");
		}
		return "home";

	}

}
