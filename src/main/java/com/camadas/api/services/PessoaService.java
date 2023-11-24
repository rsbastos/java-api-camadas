package com.camadas.api.services;

import java.util.List;
import java.util.stream.Collectors;

import com.camadas.api.model.Pessoa;
import com.camadas.api.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.camadas.api.dto.PessoaDTO;
import com.camadas.api.dto.PessoaInsertDTO;
import com.camadas.api.services.exceptions.ServiceException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public List<PessoaDTO> findAll() {
		List<Pessoa> list = pessoaRepository.findAll();
		return list.stream().map(x -> new PessoaDTO(x)).collect(Collectors.toList());
	} 
	
	public PessoaDTO insert(PessoaInsertDTO dto) {
		Pessoa pessoa = pessoaRepository.findByEmail(dto.getEmail());
		if (pessoa != null) {
			throw new ServiceException("O email digitado já está cadastrado");
		}
		
		Pessoa obj = new Pessoa();
		obj.setNome(dto.getNome());
		obj.setEmail(dto.getEmail());
		obj.setSenha(passwordEncoder.encode(dto.getSenha()));
		
		obj = pessoaRepository.save(obj);
		
		return new PessoaDTO(obj);
	}
}
