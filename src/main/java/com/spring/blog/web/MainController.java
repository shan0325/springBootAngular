package com.spring.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String getIndexView(Model model) {
		
		model.addAttribute("name", "홍길동");
		return "index";
	}
}
