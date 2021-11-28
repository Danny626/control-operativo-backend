package com.albo.soa.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_BULTO", catalog = "", schema = "SOA")
public class TipoBulto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "TBU_COD", nullable = false, length = 3)
	private String tbuCod;
	@Basic(optional = false)
	@Column(name = "TBU_NOMBRE", nullable = false, length = 50)
	private String tbuNombre;
	@Column(name = "TBU_GRAN", length = 2)
	private String tbuGran;
	@Basic(optional = false)
	@Column(name = "TBU_ESTADO", nullable = false, length = 5)
	private String tbuEstado;

	public TipoBulto() {
	}

	public TipoBulto(String tbuCod) {
		this.tbuCod = tbuCod;
	}

	public TipoBulto(String tbuCod, String tbuNombre, String tbuEstado) {
		this.tbuCod = tbuCod;
		this.tbuNombre = tbuNombre;
		this.tbuEstado = tbuEstado;
	}

	public String getTbuCod() {
		return tbuCod;
	}

	public void setTbuCod(String tbuCod) {
		this.tbuCod = tbuCod;
	}

	public String getTbuNombre() {
		return tbuNombre;
	}

	public void setTbuNombre(String tbuNombre) {
		this.tbuNombre = tbuNombre;
	}

	public String getTbuGran() {
		return tbuGran;
	}

	public void setTbuGran(String tbuGran) {
		this.tbuGran = tbuGran;
	}

	public String getTbuEstado() {
		return tbuEstado;
	}

	public void setTbuEstado(String tbuEstado) {
		this.tbuEstado = tbuEstado;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (tbuCod != null ? tbuCod.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof TipoBulto)) {
			return false;
		}
		TipoBulto other = (TipoBulto) object;
		if ((this.tbuCod == null && other.tbuCod != null)
				|| (this.tbuCod != null && !this.tbuCod.equals(other.tbuCod))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.TipoBulto[ tbuCod=" + tbuCod + " ]";
	}
}
