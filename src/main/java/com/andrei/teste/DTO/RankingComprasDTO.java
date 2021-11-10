package com.andrei.teste.DTO;

import com.andrei.teste.entities.Pessoas;

public class RankingComprasDTO {
	private String nomeCliente;
	private Double valorTotal;

	public RankingComprasDTO(Pessoas pessoas, Double valorTotal) {
		super();
		this.nomeCliente = pessoas.getNome();
		this.valorTotal = valorTotal;
	}

	public RankingComprasDTO() {
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

}
