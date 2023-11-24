package com.camadas.api.controllers;

import java.net.URI;
import java.util.List;

import com.camadas.api.dto.PessoaInsertDTO;
import com.camadas.api.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.camadas.api.dto.PessoaDTO;
import com.camadas.api.services.exceptions.ServiceException;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public ResponseEntity<List<PessoaDTO>> findAll() {
		List<PessoaDTO> list = pessoaService.findAll();
		return ResponseEntity.ok(list);
	}

	@PostMapping
	public ResponseEntity<PessoaDTO> insert(@RequestBody PessoaInsertDTO dto) {
		try {
			PessoaDTO obj = pessoaService.insert(dto);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).body(obj);	
		}
		catch (ServiceException e) {
			return ResponseEntity.unprocessableEntity().build();
		}
	}
}
