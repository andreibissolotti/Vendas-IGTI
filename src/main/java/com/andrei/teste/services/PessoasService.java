package com.andrei.teste.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrei.teste.DTO.PessoasDTO;
import com.andrei.teste.entities.Pessoas;
import com.andrei.teste.repositories.PessoasRepository;

@Service
public class PessoasService{

	@Autowired
	private PessoasRepository pessoasrepository;
	
	public List<PessoasDTO> findAll() {
		List<Pessoas>res=pessoasrepository.findAll();
		return res.stream().map(c->new PessoasDTO(c)).collect(Collectors.toList());
	}

	
}
