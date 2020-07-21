package com.desafio.pessoaservice.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PessoaDTO implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dataNascimento;
	
	private String nome;
	
	private String cpf;

}
