package com.crm.institute.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crm.institute.enttity.Semanas;

@Repository
public interface SemanasRepository extends CrudRepository<Semanas, Long> {
	
	public Optional<Semanas> findByCiclo(String ciclo);

}
