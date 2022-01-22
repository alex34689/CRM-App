package com.crm.institute.enttity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class AlumnoCiclo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idAlumnoCiclo;

	@Column
	private String noCuenta;

	@Column
	@NotBlank
	private String ciclo;

	@Column
	private int grado;

	@Column
	private boolean pagaVacaciones;

	public long getIdAlumnoCiclo() {
		return idAlumnoCiclo;
	}

	public void setIdAlumnoCiclo(long idAlumnoCiclo) {
		this.idAlumnoCiclo = idAlumnoCiclo;
	}

	public String getNoCuenta() {
		return noCuenta;
	}

	public void setNoCuenta(String noCuenta) {
		this.noCuenta = noCuenta;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}

	public boolean isPagaVacaciones() {
		return pagaVacaciones;
	}

	public void setPagaVacaciones(boolean pagaVacaciones) {
		this.pagaVacaciones = pagaVacaciones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ciclo == null) ? 0 : ciclo.hashCode());
		result = prime * result + grado;
		result = prime * result + (int) (idAlumnoCiclo ^ (idAlumnoCiclo >>> 32));
		result = prime * result + ((noCuenta == null) ? 0 : noCuenta.hashCode());
		result = prime * result + (pagaVacaciones ? 1231 : 1237);
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
		AlumnoCiclo other = (AlumnoCiclo) obj;
		if (ciclo == null) {
			if (other.ciclo != null)
				return false;
		} else if (!ciclo.equals(other.ciclo))
			return false;
		if (grado != other.grado)
			return false;
		if (idAlumnoCiclo != other.idAlumnoCiclo)
			return false;
		if (noCuenta == null) {
			if (other.noCuenta != null)
				return false;
		} else if (!noCuenta.equals(other.noCuenta))
			return false;
		if (pagaVacaciones != other.pagaVacaciones)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AlumnoCiclo [idAlumnoCiclo=" + idAlumnoCiclo + ", noCuenta=" + noCuenta + ", ciclo=" + ciclo
				+ ", grado=" + grado + ", pagaVacaciones=" + pagaVacaciones + "]";
	}

}
