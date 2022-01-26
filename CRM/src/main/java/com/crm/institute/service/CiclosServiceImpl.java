package com.crm.institute.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.institute.Exception.CustomeFieldValidationException;
import com.crm.institute.Exception.UsernameOrIdNotFound;
import com.crm.institute.enttity.Ciclos;
import com.crm.institute.enttity.Semanas;
import com.crm.institute.repository.SemanasRepository;
import com.crm.institute.repository.CiclosRepository;

@Service
public class CiclosServiceImpl implements CiclosService {

	@Autowired
	CiclosRepository ciclosRepository;

	@Autowired
	SemanasRepository semanasRepository;

	@Override
	public Iterable<Ciclos> getAllCiclos() {
		return ciclosRepository.findAll();
	}

	private boolean checkCicloAvailable(Ciclos ciclos) throws Exception {
		Optional<Ciclos> cicloFound = ciclosRepository.findByCiclo(ciclos.getCiclo());
		if (cicloFound.isPresent()) {
			throw new CustomeFieldValidationException("Ciclo no disponible", "ciclo");
		}
		return true;
	}

	private Ciclos generaCiclo(Ciclos ciclos) throws Exception {
		long diff = ciclos.getFechaFin().getTime() - ciclos.getFechaInicio().getTime();
		TimeUnit time = TimeUnit.DAYS;
		long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
		long noSemanas = diffrence / 7 + 1;
		ciclos.setNoSemanas((int) noSemanas);

		Date inicio = ciclos.getFechaInicio();
		List<Semanas> semanasList = new ArrayList<Semanas>();

		for (int i = 0; i < (int) noSemanas; i++) {
			Semanas semanas = new Semanas();
			semanas.setSemanaInicio(inicio);

			Calendar c = Calendar.getInstance();
			c.setTime(inicio);
			c.add(Calendar.DATE, 6);
			inicio = c.getTime();

			semanas.setSemanaFin(inicio);
			semanas.setVacaciones(false);
			semanas.setSemana(i + 1);
			semanasList.add(semanas);

			c.setTime(inicio);
			c.add(Calendar.DATE, 1);
			inicio = c.getTime();
		}
		ciclos.setSemanas(semanasList);

		return ciclos;
	}

	@Override
	public Ciclos createCiclos(Ciclos ciclos) throws Exception {
		if (checkCicloAvailable(ciclos)) {
			ciclos = generaCiclo(ciclos);
			ciclos = ciclosRepository.save(ciclos);

			for (Semanas semDetalle : ciclos.getSemanas()) {
				semDetalle.setCiclos(ciclos);
				semanasRepository.save(semDetalle);
			}

		}
		return ciclos;
	}

	@Override
	public Ciclos getCiclosByIdCiclo(Long idCiclo) throws Exception {
		return ciclosRepository.findById(idCiclo)
				.orElseThrow(() -> new UsernameOrIdNotFound("El id del ciclo no existe"));
	}

	@Override
	public Ciclos updateCiclos(Ciclos ciclos) throws Exception {
		Iterable<Semanas> semanas = semanasRepository.findByIdSemana(ciclos.getIdCiclo());
		ciclos = generaCiclo(ciclos);
		for (Semanas semDetalle : semanas) {
			semanasRepository.delete(semDetalle);
		}
		for (Semanas semDetalle : ciclos.getSemanas()) {
			semDetalle.setCiclos(ciclos);
			semanasRepository.save(semDetalle);
		}
		ciclos = ciclosRepository.save(ciclos);

		return ciclos;
	}
}
