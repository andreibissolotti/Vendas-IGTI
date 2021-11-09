package com.andrei.teste.DTO;

import java.time.LocalDate;

import com.andrei.teste.entities.Compras;


public class ComprasDTO {

	private int id;
	private Double totalCompra;
	private LocalDate dataCompra;
	
	public ComprasDTO(Compras entidade) {
		super();
		this.id = entidade.getId();
		this.totalCompra = entidade.getTotalCompra();
		this.dataCompra = entidade.getDataCompra();
	}
	
	public ComprasDTO(int id, Double totalCompra, LocalDate dataCompra) {
		super();
		this.id = id;
		this.totalCompra = totalCompra;
		this.dataCompra = dataCompra;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getTotalCompra() {
		return totalCompra;
	}
	public void setTotalCompra(Double totalCompra) {
		this.totalCompra = totalCompra;
	}
	public LocalDate getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}
}
