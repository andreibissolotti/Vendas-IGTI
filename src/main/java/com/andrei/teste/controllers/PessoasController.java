package com.andrei.teste.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.andrei.teste.DTO.PessoasDTO;
import com.andrei.teste.entities.Pessoas;
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
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<PessoasDTO>savePessoas(@RequestBody PessoasDTO pessoaDTO){
		Pessoas entidade = pessoasservice.fromDTO(pessoaDTO);
		pessoasservice.savePessoas(entidade);
		return new ResponseEntity<PessoasDTO>(pessoaDTO, HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{id}")
	@ResponseBody
	public ResponseEntity<PessoasDTO>updatePessoas(@PathVariable Integer id, @RequestBody PessoasDTO pessoaDTO){
		Pessoas entidade = pessoasservice.fromDTO(pessoaDTO);
		if(pessoasservice.updatePessoas(id, entidade) != null) {
			return new ResponseEntity<PessoasDTO>(pessoaDTO, HttpStatus.OK);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deletePessoas(@PathVariable Integer id){
		pessoasservice.deleteCliente(id);
		return ResponseEntity.noContent().build();
	}
}
