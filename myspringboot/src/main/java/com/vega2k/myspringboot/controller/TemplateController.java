package com.vega2k.myspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {
	@GetMapping("/thymeleaf")
	public String leaf(Model model) {
		model.addAttribute("name", "hamletshu");
		return "leaf";
	}
	
}
