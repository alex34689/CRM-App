package com.crm.institute.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crm.institute.enttity.Semanas;

@Repository
public interface SemanasRepository extends CrudRepository<Semanas, Long> {

	Iterable<Semanas> findByIdSemana(Long idSemana);

}
