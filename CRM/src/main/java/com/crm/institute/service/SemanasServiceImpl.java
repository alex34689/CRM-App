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
import com.crm.institute.enttity.Semanas;
import com.crm.institute.enttity.SemanasDetalle;
import com.crm.institute.repository.SemanasDetalleRepository;
import com.crm.institute.repository.SemanasRepository;

@Service
public class SemanasServiceImpl implements SemanasService {

	@Autowired
	SemanasRepository semanasRepository;

	@Autowired
	SemanasDetalleRepository semanasDetalleRepository;

	@Override
	public Iterable<Semanas> getAllSemanas() {
		return semanasRepository.findAll();
	}

	private boolean checkCicloAvailable(Semanas semanas) throws Exception {
		Optional<Semanas> cicloFound = semanasRepository.findByCiclo(semanas.getCiclo());
		if (cicloFound.isPresent()) {
			throw new CustomeFieldValidationException("Ciclo no disponible", "ciclo");
		}
		return true;
	}
	
	private Semanas generaSemanas(Semanas semanas)throws Exception{
		long diff = semanas.getFechaFin().getTime() - semanas.getFechaInicio().getTime();
		TimeUnit time = TimeUnit.DAYS;
		long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
		long noSemanas = diffrence / 7 + 1;
		semanas.setNoSemanas((int) noSemanas);

		Date inicio = semanas.getFechaInicio();
		List<SemanasDetalle> semanasList = new ArrayList<SemanasDetalle>();

		for (int i = 0; i < (int) noSemanas; i++) {
			SemanasDetalle semanasDetalle = new SemanasDetalle();
			semanasDetalle.setSemanaInicio(inicio);

			Calendar c = Calendar.getInstance();
			c.setTime(inicio);
			c.add(Calendar.DATE, 6);
			inicio = c.getTime();

			semanasDetalle.setSemenaFin(inicio);
			semanasDetalle.setVacaciones(false);
			semanasDetalle.setSemana(i + 1);
			semanas.setSemanasDetalle(null);
			semanasList.add(semanasDetalle);

			c.setTime(inicio);
			c.add(Calendar.DATE, 1);
			inicio = c.getTime();
		}
		semanas.setSemanasDetalle(semanasList);

		return semanas;
	}

	@Override
	public Semanas createSemanas(Semanas semanas) throws Exception {
		if (checkCicloAvailable(semanas)) {
			semanas = generaSemanas(semanas);
			semanas = semanasRepository.save(semanas);

			for (SemanasDetalle semDetalle : semanas.getSemanasDetalle()) {
				semDetalle.setSemanas(semanas);
				semanasDetalleRepository.save(semDetalle);
			}

		}
		return semanas;
	}

	@Override
	public Semanas getSemanasByIdSemana(Long idSemana) throws Exception {
		return semanasRepository.findById(idSemana)
				.orElseThrow(() -> new UsernameOrIdNotFound("El id de la semana no existe"));
	}

	@Override
	public Semanas updateSemanas(Semanas semanas) throws Exception {
		Iterable<SemanasDetalle> semanasDetalles = semanasDetalleRepository.findByIdSemana(semanas.getIdSemana());
		semanas = generaSemanas(semanas);
		semanas = semanasRepository.save(semanas);
		
		return null;
	}

}
