package com.desafio.pessoaservice.service;

import java.util.List;

import com.desafio.pessoaservice.dto.MensagemDTO;

public final class RetornoUtil {
	
	public static MensagemDTO montarMensagem(Long id, String mensagem) {
		return new MensagemDTO(mensagem);
	}
	public static MensagemDTO montarMensagem(List<Long> ids, String mensagem) {
		return new MensagemDTO(mensagem);
	}

}
