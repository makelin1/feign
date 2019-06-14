package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.feign.SchedualServiceHello;

@RestController
public class HelloController {
	
	@Autowired
	SchedualServiceHello schedualServiceHello;
	
	@RequestMapping(value="/he",method = RequestMethod.GET)
	public String hw(@RequestParam String name) {
		return schedualServiceHello.helloFromCilent(name);
	}
	
}
