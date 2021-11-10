package com.andrei.teste.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.andrei.teste.DTO.RankingComprasDTO;
import com.andrei.teste.entities.Compras;

public interface ComprasRepository extends JpaRepository<Compras, Integer>{
	
	@Query("SELECT new com.andrei.teste.DTO.RankingComprasDTO(compras.pessoas, SUM(compras.totalCompra)) "
			+ "FROM Compras AS compras GROUP BY compras.pessoas ORDER BY SUM(compras.totalCompra) DESC")
	List<RankingComprasDTO>findRanking();
}
