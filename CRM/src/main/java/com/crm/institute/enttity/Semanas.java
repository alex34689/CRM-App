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
public class Semanas {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idSemana;

	@Column
	private Date semanaInicio;

	@Column
	private Date semanaFin;

	@Column
	private int semana;

	@Column
	private boolean isVacaciones;

	@ManyToOne
	@JoinColumn(name = "idCiclo")
	private Ciclos ciclos;

	public long getIdSemana() {
		return idSemana;
	}

	public void setIdSemana(long idSemana) {
		this.idSemana = idSemana;
	}

	public Date getSemanaInicio() {
		return semanaInicio;
	}

	public void setSemanaInicio(Date semanaInicio) {
		this.semanaInicio = semanaInicio;
	}

	public Date getSemanaFin() {
		return semanaFin;
	}

	public void setSemanaFin(Date semanaFin) {
		this.semanaFin = semanaFin;
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

	public Ciclos getCiclos() {
		return ciclos;
	}

	public void setCiclos(Ciclos ciclos) {
		this.ciclos = ciclos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ciclos == null) ? 0 : ciclos.hashCode());
		result = prime * result + (int) (idSemana ^ (idSemana >>> 32));
		result = prime * result + (isVacaciones ? 1231 : 1237);
		result = prime * result + semana;
		result = prime * result + ((semanaFin == null) ? 0 : semanaFin.hashCode());
		result = prime * result + ((semanaInicio == null) ? 0 : semanaInicio.hashCode());
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
		if (ciclos == null) {
			if (other.ciclos != null)
				return false;
		} else if (!ciclos.equals(other.ciclos))
			return false;
		if (idSemana != other.idSemana)
			return false;
		if (isVacaciones != other.isVacaciones)
			return false;
		if (semana != other.semana)
			return false;
		if (semanaFin == null) {
			if (other.semanaFin != null)
				return false;
		} else if (!semanaFin.equals(other.semanaFin))
			return false;
		if (semanaInicio == null) {
			if (other.semanaInicio != null)
				return false;
		} else if (!semanaInicio.equals(other.semanaInicio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Semanas [idSemana=" + idSemana + ", semanaInicio=" + semanaInicio + ", semanaFin=" + semanaFin
				+ ", semana=" + semana + ", isVacaciones=" + isVacaciones + ", ciclos=" + ciclos + "]";
	}

}
