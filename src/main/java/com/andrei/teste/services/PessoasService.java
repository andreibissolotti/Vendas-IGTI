package com.andrei.teste.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

	public Pessoas savePessoas(Pessoas pessoa) {
		return pessoasrepository.save(pessoa);
	}
	
	public Pessoas updatePessoas(Integer id,Pessoas newPessoa) {
		return pessoasrepository.findById(id).map(p->{
			p.setNome(newPessoa.getNome());
			p.setDn(newPessoa.getDn());
			Pessoas atualizado=pessoasrepository.save(p);
			return atualizado;
		}).orElse(null);
	}
	
	public void deleteCliente (Integer id) {
		try {
			if(pessoasrepository.findById(id)!=null)
				pessoasrepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Você não pode deletar um cliente que fez compras");
		}
		
	}
	
	public Pessoas fromDTO(PessoasDTO pessoaDTO) {
		Pessoas entidade = new Pessoas(0, pessoaDTO.getNome(), pessoaDTO.getDn());
		return entidade;
	}
	
}
