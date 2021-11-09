package com.andrei.teste.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pessoas")
public class Pessoas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String dn;
	
	@OneToMany(mappedBy = "pessoas")
	private List<Compras>compras = new ArrayList<>();
	
	public Pessoas(int id, String nome, String dn) {
		super();
		this.nome = nome;
		this.id = id;
		this.dn = dn;
	}
	
	public Pessoas() {

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
