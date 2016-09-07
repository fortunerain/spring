package com.kdc.bootcamp.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kdc.bootcamp.spring.service.AuthPermissionService;
import com.kdc.bootcamp.spring.service.UserVO;

/*
 * 1. @Component <== error, @Controller
 * 2. @Resouce(name=""), @Autowired
 * 3. declare controller with @Controller annotation, extends AbrtactController ==> implements method.
 * 4. controller can have a business logic, validation
 * 5. <annotation-driven />
 * 6. <context:component-scan>
 */

//@Component ==> error occured!
@Controller
//@Component
public class HelloController {
//public class HelloController extends AbstractController{

	//@Resource(name="authPermissionService")
	@Autowired
	private AuthPermissionService authPermissionService;
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	protected ModelAndView handleRequestInternalGet(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelandview = new ModelAndView("HelloPage");
		modelandview.addObject("welcomeMessage", "Hi User, welcome to the first Spring MVC Application");
		return modelandview;
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.POST)
	protected ModelAndView handleRequestInternalPost(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelandview = new ModelAndView("HelloPage");
		String name = request.getParameter("name");		
		modelandview.addObject("welcomeMessage", "Hi User, welcome to the first Spring MVC Application");
		List<UserVO> list = this.authPermissionService.selectAuthPermissionList(name);
		System.out.println("list.size() : ===> " + list.size());
		modelandview.addObject("authUsers", list);
		return modelandview;
	}
}
