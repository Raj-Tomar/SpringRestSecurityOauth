package com.raj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.raj.security.User;
import com.raj.service.DataService;


@Controller
@RequestMapping("/api")
public class RestController {

	@Autowired
	DataService dataService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login() {
		System.out.println("Controller");
		return "login";
	}
	

	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	@ResponseBody
	public List<User> list() {
		return dataService.getUserList();

	}
}
