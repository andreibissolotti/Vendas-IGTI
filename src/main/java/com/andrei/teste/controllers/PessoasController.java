package com.andrei.teste.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrei.teste.DTO.PessoasDTO;
import com.andrei.teste.services.PessoasService;

@RestController
@RequestMapping("/pessoas")
public class PessoasController {

	@Autowired
	private PessoasService pessoasservice;

	@GetMapping
	public ResponseEntity<List<PessoasDTO>> findAll() {
		List<PessoasDTO> lista = pessoasservice.findAll();
		return ResponseEntity.ok(lista);
	}
}
