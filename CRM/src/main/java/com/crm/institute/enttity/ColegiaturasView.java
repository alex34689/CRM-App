package com.crm.institute.enttity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
public class ColegiaturasView {
	@Id
	private Long id;
	private String noCuenta;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String ciclo;
	private Date semanaInicio;
	private Date semanaFin;
	private int semana;
	private String pagaVacaciones;
	private String tipoSemana;
	private float saldo;
	private float importePendiente;
	private String estado;
	private float colegiatura;
	private String estatusAlumno;

	public long getId() {
		return id;
	}

	public String getNoCuenta() {
		return noCuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public String getCiclo() {
		return ciclo;
	}

	public Date getSemanaInicio() {
		return semanaInicio;
	}

	public Date getSemanaFin() {
		return semanaFin;
	}

	public int getSemana() {
		return semana;
	}

	public String getPagaVacaciones() {
		return pagaVacaciones;
	}

	public String getTipoSemana() {
		return tipoSemana;
	}

	public float getSaldo() {
		return saldo;
	}

	public float getImportePendiente() {
		return importePendiente;
	}

	public String getEstado() {
		return estado;
	}

	public float getColegiatura() {
		return colegiatura;
	}

	public String getEstatusAlumno() {
		return estatusAlumno;
	}

	@Override
	public String toString() {
		return "ColegiaturasView [id=" + id + ", noCuenta=" + noCuenta + ", nombre=" + nombre + ", apellidoPaterno="
				+ apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", ciclo=" + ciclo + ", semanaInicio="
				+ semanaInicio + ", semanaFin=" + semanaFin + ", semana=" + semana + ", pagaVacaciones=" + pagaVacaciones
				+ ", tipoSemana=" + tipoSemana + ", saldo=" + saldo + ", importePendiente=" + importePendiente
				+ ", estado=" + estado + ", colegiatura=" + colegiatura + ", estatusAlumno=" + estatusAlumno + "]";
	}

}
