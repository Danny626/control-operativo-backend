package com.albo.soa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADUANA", catalog = "", schema = "SOA")
public class Aduana implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ADU_COD", length = 10)
	private String aduCod;
	@Column(name = "ADU_NOMBRE", length = 40)
	private String aduNombre;
	@Column(name = "ADU_PAIS", length = 20)
	private String aduPais;
	@Column(name = "ADU_ESTADO", length = 5)
	private String aduEstado;

	public Aduana() {
	}

	public Aduana(String aduCod) {
		this.aduCod = aduCod;
	}

	public String getAduCod() {
		return aduCod == null ? "" : aduCod;
	}

	public void setAduCod(String aduCod) {
		this.aduCod = aduCod;
	}

	public String getAduNombre() {
		return aduNombre;
	}

	public void setAduNombre(String aduNombre) {
		this.aduNombre = aduNombre;
	}

	public String getAduPais() {
		return aduPais;
	}

	public void setAduPais(String aduPais) {
		this.aduPais = aduPais;
	}

	public String getAduEstado() {
		return aduEstado;
	}

	public void setAduEstado(String aduEstado) {
		this.aduEstado = aduEstado;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (aduCod != null ? aduCod.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Aduana)) {
			return false;
		}
		Aduana other = (Aduana) object;
		if ((this.aduCod == null && other.aduCod != null)
				|| (this.aduCod != null && !this.aduCod.equals(other.aduCod))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.Aduana[ aduCod=" + aduCod + " ]";
	}

}