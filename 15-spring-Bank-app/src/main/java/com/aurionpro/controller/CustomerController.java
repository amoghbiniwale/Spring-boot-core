package com.aurionpro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.service.CoustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CoustomerService coustomerService;
}
