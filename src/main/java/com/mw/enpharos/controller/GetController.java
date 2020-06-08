package com.mw.enpharos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/get/*")
public class GetController {
	
	@RequestMapping("/swing/hour/tps_res")
    public String tps_rest(Model model) {
    	System.out.println("RestAPI - /swing/hour/tps_res");
    	return "redirect:/get/info";
    }
	
}

