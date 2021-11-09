package com.andrei.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andrei.teste.entities.Pessoas;

@Repository
public interface PessoasRepository extends JpaRepository<Pessoas, Integer> {

}
