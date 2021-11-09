package com.andrei.teste;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloworld") // path da requisição
public class HelloWorld {
	//get

	@GetMapping("/soma")
	public int soma(@RequestParam int n1, @RequestParam int n2) {
		return n1+n2;
	}
	
	@GetMapping("/msg/{msg}")
	public String msg(@PathVariable String msg) {
		return msg.toUpperCase();
	}
	
	@GetMapping("")
	ResponseEntity<String> hello(){
		return new ResponseEntity<>("Hello World", HttpStatus.OK);
	}
}
