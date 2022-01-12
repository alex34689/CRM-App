package com.crm.institute.service;

import com.crm.institute.enttity.AlumnoCiclo;
import com.crm.institute.enttity.Alumnos;

public interface AlumnosService {

	public Iterable<Alumnos> getAllAlumnos();

	public Alumnos createAlumno(Alumnos alumnos, AlumnoCiclo alumnoCiclo) throws Exception;

	public Alumnos getAlumnosByIdAlumno(Long idAlumno) throws Exception;

	public Alumnos updateAlumnos(Alumnos alumnos, AlumnoCiclo alumnoCiclo) throws Exception;
	
	public AlumnoCiclo getAlumnoCicloByNoCuentaAndGrado(String noCuenta, int grado) throws Exception;

}
