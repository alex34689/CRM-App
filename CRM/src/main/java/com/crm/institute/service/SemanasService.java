package com.crm.institute.service;

import com.crm.institute.enttity.Semanas;

public interface SemanasService {

	public Iterable<Semanas> getAllSemanas();

	public Semanas createSemanas(Semanas semanas) throws Exception;

	public Semanas getSemanasByIdSemana(Long idSemana) throws Exception;

	public Semanas updateSemanas(Semanas semanas) throws Exception;
}
