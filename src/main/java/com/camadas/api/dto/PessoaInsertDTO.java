package com.camadas.api.dto;

import com.camadas.api.model.Pessoa;

public class PessoaInsertDTO {

	private String nome;
	private String email;
	private String senha;
	
	public PessoaInsertDTO() {
	}

	public PessoaInsertDTO(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	public PessoaInsertDTO(Pessoa entity) {
		super();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		this.senha = entity.getSenha();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
