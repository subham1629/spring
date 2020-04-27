package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DemoController {
	
	 @Autowired
	 private UserRepo repo;
	 
	 @Autowired
	 private LaptopRepo laprepo;
	 
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
	 public User postUser(@RequestBody User u1) {
		 repo.save(u1);
		 return u1;
	 }
	 
	 @DeleteMapping("user/{id}")
	 public User deleteUser(@PathVariable int id) {
		 User u1=repo.getOne(id);
		 
		 repo.delete(u1);
		 
		 return u1;
	 }
	 
	 @PutMapping("user")
	 @ResponseBody
	 public User putUser(@RequestBody User u1) {
		 repo.save(u1);
		 return u1;
	 }
	 
	 @PostMapping("/laptop")
	 @ResponseBody
	 public Laptop postLaptop(Laptop l1) {
		 laprepo.save(l1);
		 return l1;
	 }
}
