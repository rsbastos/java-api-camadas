package com.camadas.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.camadas.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	Pessoa findByEmail(String email);
}
