package com.crm.institute.enttity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Pagos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idPago;

	@Column
	private Date fecha;

	@Column
	@NotBlank
	private String ciclo;

	@Column
	@NotNull
	private int semana;

	@Column
	@NotBlank
	private String noCuenta;

	@Column
	private float importe;

	public long getIdPago() {
		return idPago;
	}

	public void setIdPago(long idPago) {
		this.idPago = idPago;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public int getSemana() {
		return semana;
	}

	public void setSemana(int semana) {
		this.semana = semana;
	}

	public String getNoCuenta() {
		return noCuenta;
	}

	public void setNoCuenta(String noCuenta) {
		this.noCuenta = noCuenta;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ciclo == null) ? 0 : ciclo.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + (int) (idPago ^ (idPago >>> 32));
		result = prime * result + Float.floatToIntBits(importe);
		result = prime * result + ((noCuenta == null) ? 0 : noCuenta.hashCode());
		result = prime * result + semana;
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
		Pagos other = (Pagos) obj;
		if (ciclo == null) {
			if (other.ciclo != null)
				return false;
		} else if (!ciclo.equals(other.ciclo))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (idPago != other.idPago)
			return false;
		if (Float.floatToIntBits(importe) != Float.floatToIntBits(other.importe))
			return false;
		if (noCuenta == null) {
			if (other.noCuenta != null)
				return false;
		} else if (!noCuenta.equals(other.noCuenta))
			return false;
		if (semana != other.semana)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pagos [idPago=" + idPago + ", fecha=" + fecha + ", ciclo=" + ciclo + ", semana=" + semana
				+ ", noCuenta=" + noCuenta + ", importe=" + importe + "]";
	}

}
