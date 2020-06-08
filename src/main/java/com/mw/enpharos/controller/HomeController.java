package com.mw.enpharos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
	
	@RequestMapping({"/", "/home"})
    public String home(Model model) {
    	System.out.println("RestAPI - /home");
        // return "hello";
    	return "redirect:/get/swing/tps_res";
    }
    
	/*
    @RequestMapping("/story")
    public String story() {
        return "story";
    }
    */   
}

