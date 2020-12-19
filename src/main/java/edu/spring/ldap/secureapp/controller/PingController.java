package edu.spring.ldap.secureapp.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.spring.ldap.secureapp.model.People;
import edu.spring.ldap.secureapp.repository.PeopleRepository;

@Controller
@RequestMapping("/ping")
public class PingController {
	
	@Autowired
	private PeopleRepository peopleRepository;
	
	@RequestMapping(method=RequestMethod.GET,path = "/message/{value}")
	@ResponseBody
	public Map<String,String> getPing(@PathVariable String value)
	{
		Map<String,String> map = new HashMap<>();
		map.put("message", "Received message "+value+" at "+LocalDate.now().toString());
		
		 UserDetails user = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 System.out.println(user.getUsername());
		
		return map;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public Map<String,String> get()
	{
		Map<String,String> map = new HashMap<>();
		map.put("message", "Received ping at "+LocalDate.now().toString());
		/*
		 * Iterable<People> peoples = peopleRepository.findAll(); if(peoples!=null) {
		 * peoples.forEach(ppl -> { System.out.println(ppl.getUid()); }); }
		 */
		
		return map;
	}

}

