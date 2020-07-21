package com.desafio.pessoaservice.persistence;

import java.util.Optional;

import com.desafio.pessoaservice.persistence.model.Pessoa;

public interface PessoaDAO {
	
	public Iterable<Pessoa> consultarPessoas();
	
	public Optional<Pessoa> recuperaPessoa(Long id);
	
	public Long criaPessoa(Pessoa pessoa);
	
	public boolean removePessoa(Long id);
	
	public Long atualizaPessoa(Pessoa pessoa);

}