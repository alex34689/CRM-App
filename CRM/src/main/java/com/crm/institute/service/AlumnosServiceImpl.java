package com.crm.institute.service;

import java.util.Date;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.institute.Exception.UsernameOrIdNotFound;
import com.crm.institute.enttity.Alumnos;
import com.crm.institute.repository.AlumnoRepository;

@Service
public class AlumnosServiceImpl implements AlumnosService {

	@Autowired
	AlumnoRepository alumnoRepository;

	@Override
	public Iterable<Alumnos> getAllAlumnos() {
		return alumnoRepository.findAll();
	}

	private String createNoCuenta() {
		Iterable<Alumnos> alumnosNoCuenta = alumnoRepository.findAll();
		// obtenemos el ultimo noCuenta
		int maximo = 0;
		for (Alumnos alumnosI : alumnosNoCuenta) {
			if (Integer.parseInt(alumnosI.getNoCuenta()) > maximo)
				maximo = Integer.parseInt(alumnosI.getNoCuenta());
		}

		// validamos si el ultimo nocuenta corresponde a este año mes
		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);

		String cuentaMaximo = String.valueOf(maximo);
		int anioCuenta = Integer.parseInt(cuentaMaximo.substring(0, 4)); // 202108001
		int mesCuenta = Integer.parseInt(cuentaMaximo.substring(4, 6));
		int consecutivo = Integer.parseInt(cuentaMaximo.substring(6, 9));
		int anioActual = calendar.get(Calendar.YEAR);
		int mesActual = calendar.get(Calendar.MONTH) + 1;

		// si es verdadero colocamos un consecutivo al ultimo no cuenta
		// si es falso creamos nocuenta inicial del mes año
		if (anioCuenta == anioActual)
			if (mesCuenta == mesActual)
				consecutivo++;
			else {
				mesCuenta = mesActual;
				consecutivo = 1;
			}
		else {
			anioCuenta = anioActual;
			mesCuenta = mesActual;
			consecutivo = 1;
		}
		// regresamos el noCuenta
		@SuppressWarnings("resource")
		Formatter fmt = new Formatter();
		String mesFinal = String.valueOf(fmt.format("%02d", mesCuenta));
		fmt = new Formatter();
		String consecutivoFinal = String.valueOf(fmt.format("%03d", consecutivo));

		String noCuentaFinal = String.valueOf(anioCuenta) + mesFinal + consecutivoFinal;
		return noCuentaFinal;
	}

	@Override
	public Alumnos createAlumno(Alumnos alumnos) throws Exception {
		String noCuenta = createNoCuenta();
		alumnos.setNoCuenta(noCuenta);
		alumnos.setActivo(true);
		alumnos = alumnoRepository.save(alumnos);
		return alumnos;
	}

	@Override
	public Alumnos getAlumnosByIdAlumno(Long idAlumno) throws UsernameOrIdNotFound {
		return alumnoRepository.findById(idAlumno)
				.orElseThrow(() -> new UsernameOrIdNotFound("el Id del alumno no existe"));
	}

	@Override
	public Alumnos updateAlumnos(Alumnos fromAlumno) throws Exception {
		return alumnoRepository.save(fromAlumno);
	}
}
