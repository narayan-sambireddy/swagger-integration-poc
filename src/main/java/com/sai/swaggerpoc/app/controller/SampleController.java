package com.sai.swaggerpoc.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sai.swaggerpoc.app.domain.Student;

@RestController
@RequestMapping("/sample")
public class SampleController {
	
	@GetMapping("/greet")
	public String greetStudent(@RequestParam String name) {
		return "Hello " + name;
	}
	
	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		System.out.println(student);
		return student;
	}
	
	

}
