package com.crm.institute.enttity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SemanasDetalle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idSemanaDetalle;

	@Column
	private Date semanaInicio;

	@Column
	private Date semenaFin;

	@Column
	private int semana;

	@Column
	private boolean isVacaciones;

	@ManyToOne
	@JoinColumn(name = "idSemana")
	private Semanas semanas;

	public long getIdSemanaDetalle() {
		return idSemanaDetalle;
	}

	public void setIdSemanaDetalle(long idSemanaDetalle) {
		this.idSemanaDetalle = idSemanaDetalle;
	}

	public Date getSemanaInicio() {
		return semanaInicio;
	}

	public void setSemanaInicio(Date semanaInicio) {
		this.semanaInicio = semanaInicio;
	}

	public Date getSemenaFin() {
		return semenaFin;
	}

	public void setSemenaFin(Date semenaFin) {
		this.semenaFin = semenaFin;
	}

	public int getSemana() {
		return semana;
	}

	public void setSemana(int semana) {
		this.semana = semana;
	}

	public boolean isVacaciones() {
		return isVacaciones;
	}

	public void setVacaciones(boolean isVacaciones) {
		this.isVacaciones = isVacaciones;
	}

	public Semanas getSemanas() {
		return semanas;
	}

	public void setSemanas(Semanas semanas) {
		this.semanas = semanas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idSemanaDetalle ^ (idSemanaDetalle >>> 32));
		result = prime * result + (isVacaciones ? 1231 : 1237);
		result = prime * result + semana;
		result = prime * result + ((semanaInicio == null) ? 0 : semanaInicio.hashCode());
		result = prime * result + ((semanas == null) ? 0 : semanas.hashCode());
		result = prime * result + ((semenaFin == null) ? 0 : semenaFin.hashCode());
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
		SemanasDetalle other = (SemanasDetalle) obj;
		if (idSemanaDetalle != other.idSemanaDetalle)
			return false;
		if (isVacaciones != other.isVacaciones)
			return false;
		if (semana != other.semana)
			return false;
		if (semanaInicio == null) {
			if (other.semanaInicio != null)
				return false;
		} else if (!semanaInicio.equals(other.semanaInicio))
			return false;
		if (semanas == null) {
			if (other.semanas != null)
				return false;
		} else if (!semanas.equals(other.semanas))
			return false;
		if (semenaFin == null) {
			if (other.semenaFin != null)
				return false;
		} else if (!semenaFin.equals(other.semenaFin))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SemanasDetalle [idSemanaDetalle=" + idSemanaDetalle + ", semanaInicio=" + semanaInicio + ", semenaFin="
				+ semenaFin + ", semana=" + semana + ", isVacaciones=" + isVacaciones + ", semanas=" + semanas + "]";
	}

}
