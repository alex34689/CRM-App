package com.crm.institute.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crm.institute.enttity.SemanasDetalle;

@Repository
public interface SemanasDetalleRepository extends CrudRepository<SemanasDetalle, Long> {
	
	Iterable<SemanasDetalle> findByIdSemana(Long idSemana);

}
