package com.test.spring.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	private static Logger logger= LoggerFactory.getLogger(HelloController.class);
	//void
	@RequestMapping(method=RequestMethod.GET,value="/hello")
	public void sayHello() {
		logger.debug(">>>>>>>>>>>>>>>>>>>HERE WE ARE");// redirects to /WEB-INF/jsp/{hello}.jsp
		
	}
	
	//String
	@RequestMapping(method=RequestMethod.GET,value="/sayHello")
	public String sayHelloWithReturnType() {
		logger.debug(">>>>>>>>>>>>>>>>>>>HERE WE ARE");//view name: /WEB-INF/jsp/hello.jsp
		return "hello";
		
	}
	//M&V
	@RequestMapping(method=RequestMethod.GET,value="/showData")
	public ModelAndView showData() {
		logger.debug(">>>>>>>>>>>>>>>>>>>HERE WE ARE");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hello");
		modelAndView.addObject("username", "jhon");
		return modelAndView;
		
	}
	
	//reponse
	/*@RequestMapping(method=RequestMethod.GET,value="/sayHelloToUser")
	public ModelAndView readAndShowData(HttpServletRequest request) {
		logger.debug(">>>>>>>>>>>>>>>>>>>HERE WE ARE");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hello");
		modelAndView.addObject("username", request.getParameter("username"));
		return modelAndView;
		
	}*/ 
	//reading the data by path parameters and query parameters
	@RequestMapping(method=RequestMethod.GET,value="/sayHelloToUser")
	public ModelAndView readAndShowData(String username) {
		logger.debug(">>>>>>>>>>>>>>>>>>>HERE WE ARE");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hello");
		modelAndView.addObject("username", username);
		return modelAndView;
		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/sayHelloToUser/{sno}/")
	public ModelAndView readAndShowData(@PathVariable String sno,String username,String password) {
		logger.debug(">>>>>>>>>>>>>>>>>>>HERE WE ARE");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hello");
		modelAndView.addObject("username", username);
		modelAndView.addObject("sno", sno);
		modelAndView.addObject("password", password);
		return modelAndView;
		
	}


}
