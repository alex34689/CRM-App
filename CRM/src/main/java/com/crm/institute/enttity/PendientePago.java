package com.crm.institute.enttity;

import java.util.Date;

public class PendientePago {

	private String noCuenta;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String ciclo;
	private Date semanaInicio;
	private Date semanaFin;
	private int semana;
	private float saldo;
	private float importePendiente;
	private String estado;

	public String getNoCuenta() {
		return noCuenta;
	}

	public void setNoCuenta(String noCuenta) {
		this.noCuenta = noCuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
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

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public float getImportePendiente() {
		return importePendiente;
	}

	public void setImportePendiente(float importePendiente) {
		this.importePendiente = importePendiente;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidoMaterno == null) ? 0 : apellidoMaterno.hashCode());
		result = prime * result + ((apellidoPaterno == null) ? 0 : apellidoPaterno.hashCode());
		result = prime * result + ((ciclo == null) ? 0 : ciclo.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + Float.floatToIntBits(importePendiente);
		result = prime * result + ((noCuenta == null) ? 0 : noCuenta.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + Float.floatToIntBits(saldo);
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
		PendientePago other = (PendientePago) obj;
		if (apellidoMaterno == null) {
			if (other.apellidoMaterno != null)
				return false;
		} else if (!apellidoMaterno.equals(other.apellidoMaterno))
			return false;
		if (apellidoPaterno == null) {
			if (other.apellidoPaterno != null)
				return false;
		} else if (!apellidoPaterno.equals(other.apellidoPaterno))
			return false;
		if (ciclo == null) {
			if (other.ciclo != null)
				return false;
		} else if (!ciclo.equals(other.ciclo))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (Float.floatToIntBits(importePendiente) != Float.floatToIntBits(other.importePendiente))
			return false;
		if (noCuenta == null) {
			if (other.noCuenta != null)
				return false;
		} else if (!noCuenta.equals(other.noCuenta))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Float.floatToIntBits(saldo) != Float.floatToIntBits(other.saldo))
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
		return "PendientePago [noCuenta=" + noCuenta + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno
				+ ", apellidoMaterno=" + apellidoMaterno + ", ciclo=" + ciclo + ", semanaInicio=" + semanaInicio
				+ ", semanaFin=" + semanaFin + ", semana=" + semana + ", saldo=" + saldo + ", importePendiente="
				+ importePendiente + ", estado=" + estado + "]";
	}

}
