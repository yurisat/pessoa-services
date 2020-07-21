package com.desafio.pessoaservice.persistence.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.pessoaservice.persistence.PessoaDAO;
import com.desafio.pessoaservice.persistence.model.Pessoa;
import com.desafio.pessoaservice.persistence.repository.PessoaRepository;

@Service
public class PessoaDAOImpl implements PessoaDAO {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Override 
	public Iterable<Pessoa> consultarPessoas() {
		return pessoaRepository.findAll();
	}
	
	@Override
	public Optional<Pessoa> recuperaPessoa(Long id) {
		return pessoaRepository.recuperaPessoa(id);
	}

	@Override
	public Long criaPessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa).getId();
	}

	@Override
	public boolean removePessoa(Long id) {
		pessoaRepository.deleteById(id);
		return true;
	}

	@Override
	public Long atualizaPessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa).getId();
	}

}
