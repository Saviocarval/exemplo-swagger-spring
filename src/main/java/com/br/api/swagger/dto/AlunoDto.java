package com.br.api.swagger.dto;

import com.br.api.swagger.entity.Aluno;

public class AlunoDto {

	private String nome;
	private int matricula;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	} 
	
	public Aluno transformaAlunoDto() {
		return new Aluno(nome,matricula);
	}
	
	
}
