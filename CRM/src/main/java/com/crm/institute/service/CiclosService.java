package com.crm.institute.service;

import com.crm.institute.enttity.Ciclos;

public interface CiclosService {

	public Iterable<Ciclos> getAllCiclos();

	public Ciclos createCiclos(Ciclos ciclos) throws Exception;

	public Ciclos getCiclosByIdCiclo(Long idCiclo) throws Exception;

	public Ciclos updateCiclos(Ciclos ciclo) throws Exception;
}
