package com.desafio.pessoaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.pessoaservice.dto.MensagemDTO;
import com.desafio.pessoaservice.dto.PessoaDTO;
import com.desafio.pessoaservice.persistence.model.Pessoa;
import com.desafio.pessoaservice.persistence.repository.PessoaRepository;
import com.desafio.pessoaservice.service.PessoaService;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

	@Autowired
	PessoaService pessoaService;
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@GetMapping
	public Iterable<Pessoa> all() {
		return pessoaRepository.findAll();
	}

	@GetMapping(path="{id}")
	public PessoaDTO recuperaPessoa(@PathVariable Long id) {
		return pessoaService.recuperaPessoa(id);
	}	
	
	@PostMapping
	public MensagemDTO salvaPessoa(@RequestBody PessoaDTO pessoa) {
		return pessoaService.criaPessoa(pessoa);
		
	}
	
	@PutMapping("{id}")
	public MensagemDTO alteraPessoa(@RequestBody PessoaDTO pessoa, @PathVariable long id) {
		return pessoaService.atualizaPessoa(id, pessoa);
	}
	
	@DeleteMapping("{id}")
	public MensagemDTO apagaPessoa(@PathVariable long id) {
		return pessoaService.removePessoa(id);
	}
	
	
}
