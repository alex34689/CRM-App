package com.crm.institute.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crm.institute.enttity.Alumnos;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumnos, Long> {
	
	public Optional<Alumnos> findByNoCuenta(String noCuenta);
}
