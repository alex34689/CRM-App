package com.crm.institute.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crm.institute.enttity.AlumnoCiclo;

@Repository
public interface AlumnoCicloRepository extends CrudRepository<AlumnoCiclo, Long> {

	public Optional<AlumnoCiclo> findByNoCuentaAndGrado(String noCuenta, int grado);
}
