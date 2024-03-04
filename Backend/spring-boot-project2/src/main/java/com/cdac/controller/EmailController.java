package com.cdac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.service.EmailService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class EmailController 
{

	@Autowired
    private EmailService emailService;

    
	@GetMapping("/send-email/{cusId}")
    public void sendThankYouEmail(@PathVariable int cusId) {
        emailService.sendThankYouEmail(cusId);
    }
    
   
}
