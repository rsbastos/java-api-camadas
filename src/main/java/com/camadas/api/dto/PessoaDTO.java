package com.camadas.api.dto;

import com.camadas.api.model.Pessoa;

public class PessoaDTO {

	private Long id;
	private String nome;
	private String email;
	
	public PessoaDTO() {
	}

	public PessoaDTO(Long id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
	
	public PessoaDTO(Pessoa entity) {
		super();
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
}
