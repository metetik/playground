package com.udemy.springmvc1;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("processFormV2")
	public String letsShoutDude(HttpServletRequest request,Model model) {
		String theName = request.getParameter("studentName");
		
		theName = theName.toUpperCase();
		
		String result = "Yo !" + theName;
		
		model.addAttribute("message",result);
		
		return "helloworld";
	}
	
	@RequestMapping("processFormV3")
	public String processFormV3(@RequestParam("studentName") String theName,Model model) {
		
		theName = theName.toUpperCase();
		
		String result = "Hey my friend " + theName;
		
		model.addAttribute("message",result);
		
		return "helloworld";
	}
}
