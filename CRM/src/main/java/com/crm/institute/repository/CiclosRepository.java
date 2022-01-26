package com.crm.institute.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crm.institute.enttity.Ciclos;

@Repository
public interface CiclosRepository extends CrudRepository<Ciclos, Long> {
	
	public Optional<Ciclos> findByCiclo(String ciclo);

}
