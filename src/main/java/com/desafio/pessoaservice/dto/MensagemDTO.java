package com.desafio.pessoaservice.dto;

public class MensagemDTO {
	
	private String mensagem;
	
	public MensagemDTO(String mensagem) {
		super();
		this.mensagem = mensagem;
;	}

	/**
	 * @return the mensagem
	 */
	public String getMensagem() {
		return mensagem;
	}

	/**
	 * @param mensagem the mensagem to set
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
