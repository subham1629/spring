package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	 @Autowired
	 private UserService userservice;
	 
	 @GetMapping("user")
	 public Iterable<User> getAllUsers(){
		 return userservice.getAllusers();
	 }
	 
	 @GetMapping("user/{uid}")
	 public User getUser(@PathVariable("uid") int uid) {
		 return userservice.getuser(uid);
	 }
	 
	 @PostMapping("user")
	public void postUser(@RequestBody User user) {
		userservice.adduser(user);
	}
	
	 @GetMapping("user/{uid}/laptop")
		public Laptop getAllLaptopByUser(@PathVariable("uid") int uid){
			return userservice.getLaptopByUser(uid);
		}
	
	  @PostMapping("users") public void postUsers(@RequestBody List<User>user) {
	  userservice.addusers(user); }
	 
	
	@DeleteMapping("user/{uid}")
	public void deleteUser(@PathVariable int uid) {
		userservice.deleteuser(uid);
	}
	
	@DeleteMapping("user")
	public void deleteUsers() {
		userservice.deleteusers();
	}
	
	@PutMapping("user")
	public void updateLaptop(User user) {
		userservice.updateuser(user);
	}
}
