package com.spring.heroes.web;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.heroes.domain.Hero;

@RestController
public class MainController {

	@CrossOrigin
	@GetMapping("/app/heroes")
	public Map<String, Object> getHeroes() {
		
		Map<String, Object> heroMap = new HashMap<String, Object>();
		heroMap.put("data", Arrays.asList(
								new Hero(11, "Mr. Nice"),
								new Hero(12, "Narco"),
								new Hero(13, "Bombasto"),
								new Hero(14, "Celeritas"),
								new Hero(15, "Magneta"),
								new Hero(16, "RubberMan"),
								new Hero(17, "Dynama"),
								new Hero(18, "Dr IQ"),
								new Hero(19, "Magma"),
								new Hero(20, "Tornado")			
							)
		);
	
		return heroMap;
	}
}
