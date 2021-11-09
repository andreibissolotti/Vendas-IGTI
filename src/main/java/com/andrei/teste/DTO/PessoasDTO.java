package com.andrei.teste.DTO;

import com.andrei.teste.entities.Pessoas;

public class PessoasDTO {
	private String nome;
	private int id;
	private String dn;
	
	public PessoasDTO(Pessoas entidade) {
		super();
		this.nome = entidade.getNome();
		this.id = entidade.getId();
		this.dn = entidade.getDn();
	}
	
	public PessoasDTO(int id, String nome, String dn) {
		super();
		this.nome = nome;
		this.id = id;
		this.dn = dn;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDn() {
		return dn;
	}
	public void setDn(String dn) {
		this.dn = dn;
	}
}
