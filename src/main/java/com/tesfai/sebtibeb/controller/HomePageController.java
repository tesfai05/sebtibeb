package com.tesfai.sebtibeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomePageController {
	@GetMapping("/")
	public String displayHomePage(Model model) {
		return "home/index";

	}
	
	@GetMapping("/under-construction")
	public String underConstruction(Model model, @RequestParam("txt") String txt) {
		return "home/underconstruction";

	}
	@GetMapping("/under-construction2")
	public String underConstruction2(Model model) {
		return "home/underconstruction";

	}
	@GetMapping("/information")
	public String informationDisplay(Model model) {
		return "home/info";

	}
	
	@GetMapping("/exception")
	public String errorDisplay(Model model) {
		return "home/error";

	}

}
