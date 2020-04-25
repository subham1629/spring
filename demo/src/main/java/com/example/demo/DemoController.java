package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DemoController {
	
	 @Autowired
	 private UserRepo repo;
	 
	 @GetMapping("user")
	 @ResponseBody
	 public List<User> getUser() {
		 List<User>u1=repo.findAll();
		 return u1;
	 }
	
	 @GetMapping("user/{aid}")
	 @ResponseBody
	 public User getUser(@PathVariable("aid") int id) {
		 User u1=repo.findById(id).orElse(null);
		 return u1;
	 }
	 
	 @PostMapping("user")
	 @ResponseBody
	 public User postUser(User u1) {
		 repo.save(u1);
		 return u1;
	 }
}
