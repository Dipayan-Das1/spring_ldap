package edu.spring.ldap.secureapp.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.spring.ldap.secureapp.model.People;
import edu.spring.ldap.secureapp.repository.PeopleRepository;

@Controller
@RequestMapping("/ldap")
public class LdapController {

	@Autowired
	private PeopleRepository peopleRepository;



	@RequestMapping(method = RequestMethod.GET, path = "/people/all")
	@ResponseBody
	public List<Map<String,String>> getAll() {
		List<Map<String,String>> result = new LinkedList<>();
		
		Iterable<People> peoples = peopleRepository.findAll();
		if (peoples != null) {
			peoples.forEach(ppl -> {
				Map<String,String> map = new HashMap<>();
				map.put("name", ppl.getName());
				map.put("uid", ppl.getUid());
				result.add(map);
			});
		}
		return result;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/people/{uid}")
	@ResponseBody
	public Map<String,String> getByUid(@PathVariable String uid) {
		
		Map<String,String> map = new HashMap<>();
		People people = peopleRepository.findByUid(uid);
		if(people!=null)
		{
			map.put("name", people.getName());
			map.put("uid", people.getUid());
		}
		return map;
	}

}
