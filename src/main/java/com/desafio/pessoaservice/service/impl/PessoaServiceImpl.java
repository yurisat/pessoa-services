package com.desafio.pessoaservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.pessoaservice.dto.MensagemDTO;
import com.desafio.pessoaservice.dto.PessoaDTO;
import com.desafio.pessoaservice.exception.NotFoundException;
import com.desafio.pessoaservice.persistence.PessoaDAO;
import com.desafio.pessoaservice.persistence.model.Pessoa;
import com.desafio.pessoaservice.service.PessoaService;
import com.desafio.pessoaservice.service.RetornoUtil;
import com.desafio.pessoaservice.service.constants.ServicesConstants;

@Service
public class PessoaServiceImpl implements PessoaService {
	
	@Autowired
	private PessoaDAO pessoaDAO;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public List<PessoaDTO> consultarPessoas() {
		
		List<PessoaDTO> pessoasDTO = new ArrayList<>();
		Iterable<Pessoa> pessoas = pessoaDAO.consultarPessoas();
		
		pessoas.forEach(item -> pessoasDTO.add(convertToDTOView(item)));
				
		return pessoasDTO;
	}

	@Override
	public PessoaDTO recuperaPessoa(Long id) {
		return pessoaDAO.recuperaPessoa(id)
				.map(pessoa -> convertToDTOView(pessoa))
				.orElseThrow(() -> new NotFoundException("Pessoa com ID " + id + " não foi encontrado."));
	}

	@Override
	public MensagemDTO removePessoa(Long id) {
		pessoaDAO.removePessoa(id);
		return RetornoUtil.montarMensagem(id, ServicesConstants.ENTIDADE_DELETE);
	}

	@Override
	public MensagemDTO criaPessoa(PessoaDTO pessoa) {
		return RetornoUtil.montarMensagem(pessoaDAO.criaPessoa(convertToEntity(pessoa, false, null)), ServicesConstants.ENTIDADE_POST);
	}

	@Override
	public MensagemDTO atualizaPessoa(Long id, PessoaDTO pessoa) {
		return RetornoUtil.montarMensagem(pessoaDAO.atualizaPessoa(convertToEntity(pessoa, true, id)), ServicesConstants.ENTIDADE_PUT);
	}
	
	private PessoaDTO convertToDTOView(Pessoa pessoa) {
		return modelMapper.map(pessoa, PessoaDTO.class);
	}
	
	private Pessoa convertToEntity(PessoaDTO pessoa, boolean isEdit, Long id) {
		
		Pessoa pessoaEntity = modelMapper.map(pessoa, Pessoa.class);
		
		if (isEdit) {
			pessoaEntity.setId(id);
		}
		
		return pessoaEntity;
	}

}
