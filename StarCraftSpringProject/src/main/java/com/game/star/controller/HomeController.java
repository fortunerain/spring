package com.game.star.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.game.star.model.User;

/**
 * @RestController 는 스프링 4 버전에 있다. 이전 버전에는 미존재함.
 * 기존에 @Controller + @ResponseBody 를 대신해준다. 
 */
@RestController
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home2", method = RequestMethod.GET)
	public Model home2(Model model) {
		return model;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/getData", method = RequestMethod.GET)
	public Map<String,String> getData() {
		
//		String uuid = UUID.randomUUID().toString();
		
//		User user = new User();
//		user.setId(uuid);
//		user.setContent("Hello World");
//		
//		model.addAttribute("id", user.getId());
//		model.addAttribute("content", user.getContent());	
//		
		
		Map<String,String> model = new HashMap<String, String>();
		String uuid = UUID.randomUUID().toString();
		
		
		User user = new User();
		user.setId(uuid);
		user.setContent("Hello World");
		
		
	    model.put("id", user.getId());
	    model.put("content", user.getContent());
		
		return model;
	}
	
}
