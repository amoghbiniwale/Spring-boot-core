package com.aurionpro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.model.ICoach;

@RestController
@RequestMapping("/app") 
public class TestController {
	
	private ICoach coach;
	
	@Autowired
	public TestController(@Qualifier(value= "basketballCoach")ICoach coach) {
		super();
		this.coach = coach;
	}

	
	@GetMapping("/hello")
	public String greetMessage() {
		return coach.getTrainingDetails()+"<br>"+ coach.getDietPlan();
	}
	
	@GetMapping("/test")
	public String testMessage() {
		return "testing123";
	}
	
	
}
