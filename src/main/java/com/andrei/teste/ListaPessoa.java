package com.andrei.teste;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrei.teste.entities.Pessoas;

@RestController
@RequestMapping("/lista-pessoa")
public class ListaPessoa {

	
	@GetMapping("")
	public ResponseEntity<Pessoas> listaPessoa(){
		Pessoas p = new Pessoas(1, "Andrei", "26/07/1999");
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
}
