package com.andrei.teste.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.andrei.teste.DTO.ComprasDTO;
import com.andrei.teste.DTO.RankingComprasDTO;
import com.andrei.teste.entities.Compras;
import com.andrei.teste.entities.Pessoas;
import com.andrei.teste.repositories.ComprasRepository;
import com.andrei.teste.repositories.PessoasRepository;

@Service
public class ComprasService {
	@Autowired
	private ComprasRepository comprasRepository;
	
	@Autowired
	private PessoasRepository pessoasRepositor;
	
	public List<ComprasDTO> findAll() {
		pessoasRepositor.findAll();
		List<Compras>res=comprasRepository.findAll();
		return res.stream().map(c->new ComprasDTO(c)).collect(Collectors.toList());
	}
	
	public List<RankingComprasDTO> findRanking() {
		List<RankingComprasDTO>res=comprasRepository.findRanking();
		return res;
	}
	
	public Compras savePessoas(Compras compra) {
		return comprasRepository.save(compra);
	}
	
	public Compras updateCompras(Integer id, Compras newCompra) {
		return comprasRepository.findById(id).map(c->{
			c.setTotalCompra(newCompra.getTotalCompra());
			c.setDataCompra(newCompra.getDataCompra());
			Compras atualizado=comprasRepository.save(c);
			return atualizado;
		}).orElse(null);
	}
	
	public void deleteCompras (Integer id) {
		try {
			if(comprasRepository.findById(id)!=null)
				comprasRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Você não pode deletar um cliente que fez compras");
		}
		
	}
	
	public Compras fromDTO(ComprasDTO compraDTO) {
		Compras entidade = new Compras(0, compraDTO.getTotalCompra(), compraDTO.getDataCompra(),
				new Pessoas(compraDTO.getPessoas().getId(),null,null));
		return entidade;
	}
	

}
