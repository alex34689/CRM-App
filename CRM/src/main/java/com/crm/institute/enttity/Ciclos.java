package com.crm.institute.enttity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Ciclos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCiclo;

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

	@Column
	@Min(10)
	private float importeVacacionesc;

	@Column
	@Min(10)
	private float importeVacacioness;

	@OneToMany(mappedBy = "ciclos")
	private List<Semanas> semanas;

	public long getIdCiclo() {
		return idCiclo;
	}

	public void setIdCiclo(long idCiclo) {
		this.idCiclo = idCiclo;
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

	public float getImporteVacacionesc() {
		return importeVacacionesc;
	}

	public void setImporteVacacionesc(float importeVacacionesc) {
		this.importeVacacionesc = importeVacacionesc;
	}

	public float getImporteVacacioness() {
		return importeVacacioness;
	}

	public void setImporteVacacioness(float importeVacacioness) {
		this.importeVacacioness = importeVacacioness;
	}

	public List<Semanas> getSemanas() {
		return semanas;
	}

	public void setSemanas(List<Semanas> semanas) {
		this.semanas = semanas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ciclo == null) ? 0 : ciclo.hashCode());
		result = prime * result + ((fechaFin == null) ? 0 : fechaFin.hashCode());
		result = prime * result + ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
		result = prime * result + (int) (idCiclo ^ (idCiclo >>> 32));
		result = prime * result + Float.floatToIntBits(importeVacacionesc);
		result = prime * result + Float.floatToIntBits(importeVacacioness);
		result = prime * result + noSemanas;
		result = prime * result + ((semanas == null) ? 0 : semanas.hashCode());
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
		Ciclos other = (Ciclos) obj;
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
		if (idCiclo != other.idCiclo)
			return false;
		if (Float.floatToIntBits(importeVacacionesc) != Float.floatToIntBits(other.importeVacacionesc))
			return false;
		if (Float.floatToIntBits(importeVacacioness) != Float.floatToIntBits(other.importeVacacioness))
			return false;
		if (noSemanas != other.noSemanas)
			return false;
		if (semanas == null) {
			if (other.semanas != null)
				return false;
		} else if (!semanas.equals(other.semanas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ciclos [idCiclo=" + idCiclo + ", ciclo=" + ciclo + ", fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + ", noSemanas=" + noSemanas + ", importeVacacionesc=" + importeVacacionesc
				+ ", importeVacacioness=" + importeVacacioness + ", semanas=" + semanas + "]";
	}

}
