package com.br.api.swagger.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.api.swagger.dto.AlunoDto;
import com.br.api.swagger.entity.Aluno;
import com.br.api.swagger.repository.AlunoRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoRepository repository;
	
	@GetMapping
	@ApiOperation(value = "Retorna uma coleção com todos os usuarios cadastrado")
	public ResponseEntity<List<Aluno>> listar() {
		List<Aluno > aluno = new ArrayList<>();
		aluno = repository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(aluno);
	}
	
	
	@PostMapping
	public ResponseEntity<Aluno> cadastro(@RequestBody AlunoDto dto){
		Aluno aluno = repository.save(dto.transformaAlunoDto());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Aluno> alterar(@PathVariable long id, @RequestBody AlunoDto dto){
		
		Aluno aluno = repository.findById(id);
		
		aluno.setNome(dto.getNome());
		aluno.setMatricula(dto.getMatricula());
		
		repository.save(aluno);
		
		return ResponseEntity.status(HttpStatus.OK).body(aluno);
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable long id){
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}
