package com.desafio.pessoaservice.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.desafio.pessoaservice.persistence.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

	@Query("SELECT p FROM Pessoa p WHERE p.id = :id")
	Optional<Pessoa> recuperaPessoa(Long id);

}
