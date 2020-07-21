package com.desafio.pessoaservice.service;

import java.util.List;

import com.desafio.pessoaservice.dto.MensagemDTO;
import com.desafio.pessoaservice.dto.PessoaDTO;

public interface PessoaService {
	
	public List<PessoaDTO> consultarPessoas();
		
	public PessoaDTO recuperaPessoa(Long id);	
	
	public MensagemDTO removePessoa(Long id);	

	public MensagemDTO criaPessoa(PessoaDTO pessoa);

	public MensagemDTO atualizaPessoa(Long id, PessoaDTO pessoaDTO);
	
}
