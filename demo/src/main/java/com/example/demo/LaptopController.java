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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
public class LaptopController {

	@Autowired
	private LaptopRepo laptoprepo;
	
	@GetMapping("laptop")
	public Iterable<Laptop> getAllLaptops(){
		Iterable<Laptop>l1=new ArrayList<>();
		l1=laptoprepo.findAll();
		return l1;
	}
	
	@GetMapping("user/{uid}/laptops")
	public List<Laptop> getAllLaptopsByUser(@PathVariable int uid){
		List<Laptop>l1=new ArrayList<>();
		laptoprepo.findByUser(uid).forEach(l1::add);
		return l1;
	}
	
	@PostMapping("laptop")
	public Laptop postLaptop(@RequestBody Laptop l1) {
		laptoprepo.save(l1);
		return l1;
	}
	
	@DeleteMapping("laptop/{lid}")
	public void deleteLaptop(@PathVariable int lid) {
		laptoprepo.deleteById(lid);
	}
}
