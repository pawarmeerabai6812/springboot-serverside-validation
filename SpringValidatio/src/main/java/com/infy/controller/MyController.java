package com.infy.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.entity.LoginData;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/form")
public class MyController {
	
	
	@GetMapping("/form")
	public String openForm(Model model)
	{
		System.out.println("openning form");
		model.addAttribute("loginData" ,new LoginData());
		return "form";
	}
	//handler for process form
	@PostMapping("/process")
	public String processForm( @Valid @ModelAttribute("loginData") LoginData loginData,BindingResult result) {
		if(result.hasErrors()) {
			
			System.out.println(result);
			
			return"form";
		}
		
		System.out.println(loginData);
		
		return"sucess";
		
	}
	
	@GetMapping("/admin")
	public ResponseEntity<String> adminUser() {
		return ResponseEntity.ok("Yes I am Admin User");
		
		
	}

	@GetMapping("/normalUser")
	public ResponseEntity<String> normalUser() {
		return ResponseEntity.ok("Yes I am Normal User");
		
		
	}
	@GetMapping("/public")
	public ResponseEntity<String> publicUser() {
		return ResponseEntity.ok("Yes I am public User");
		
		
	}
	

}
