package com.br.api.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.api.swagger.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
	Aluno findById(long id);
}
