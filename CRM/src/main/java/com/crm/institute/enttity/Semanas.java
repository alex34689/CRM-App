package com.crm.institute.enttity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Semanas {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idSemana;

	@Column
	@NotBlank
	private String ciclo;

	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaInicio;

	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaFin;

	@Column
	private int noSemanas;

	@OneToMany(mappedBy = "semanas")
	private List<SemanasDetalle> semanasDetalle;

	public long getIdSemana() {
		return idSemana;
	}

	public void setIdSemana(long idSemana) {
		this.idSemana = idSemana;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getNoSemanas() {
		return noSemanas;
	}

	public void setNoSemanas(int noSemanas) {
		this.noSemanas = noSemanas;
	}

	public List<SemanasDetalle> getSemanasDetalle() {
		return semanasDetalle;
	}

	public void setSemanasDetalle(List<SemanasDetalle> semanasDetalle) {
		this.semanasDetalle = semanasDetalle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ciclo == null) ? 0 : ciclo.hashCode());
		result = prime * result + ((fechaFin == null) ? 0 : fechaFin.hashCode());
		result = prime * result + ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
		result = prime * result + (int) (idSemana ^ (idSemana >>> 32));
		result = prime * result + noSemanas;
		result = prime * result + ((semanasDetalle == null) ? 0 : semanasDetalle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Semanas other = (Semanas) obj;
		if (ciclo == null) {
			if (other.ciclo != null)
				return false;
		} else if (!ciclo.equals(other.ciclo))
			return false;
		if (fechaFin == null) {
			if (other.fechaFin != null)
				return false;
		} else if (!fechaFin.equals(other.fechaFin))
			return false;
		if (fechaInicio == null) {
			if (other.fechaInicio != null)
				return false;
		} else if (!fechaInicio.equals(other.fechaInicio))
			return false;
		if (idSemana != other.idSemana)
			return false;
		if (noSemanas != other.noSemanas)
			return false;
		if (semanasDetalle == null) {
			if (other.semanasDetalle != null)
				return false;
		} else if (!semanasDetalle.equals(other.semanasDetalle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Semanas [idSemana=" + idSemana + ", ciclo=" + ciclo + ", fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + ", noSemanas=" + noSemanas + ", semanasDetalle=" + semanasDetalle + "]";
	}

}
