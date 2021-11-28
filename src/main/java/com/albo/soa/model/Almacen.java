package com.albo.soa.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ALMACEN", catalog = "", schema = "SOA")
public class Almacen implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	protected AlmacenPK almacenPK;
	@Column(name = "ALM_CODA", length = 15)
	private String almCoda;
	@Basic(optional = false)
	@Column(name = "ALM_NOMBRE", nullable = false, length = 50)
	private String almNombre;
	@Basic(optional = false)
	@Column(name = "ALM_ESTADO", nullable = false, length = 3)
	private String almEstado;
	@Column(name = "ALM_SIGLA", length = 30)
	private String almSigla;
	@JoinColumn(name = "REC_COD", referencedColumnName = "REC_COD", nullable = false, insertable = false, updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Recinto recinto;

	public Almacen() {
	}

	public Almacen(AlmacenPK almacenPK) {
		this.almacenPK = almacenPK;
	}

	public Almacen(AlmacenPK almacenPK, String almNombre, String almEstado) {
		this.almacenPK = almacenPK;
		this.almNombre = almNombre;
		this.almEstado = almEstado;
	}

	public Almacen(String recCod, String almCod) {
		this.almacenPK = new AlmacenPK(recCod, almCod);
	}

	public AlmacenPK getAlmacenPK() {
		return almacenPK;
	}

	public void setAlmacenPK(AlmacenPK almacenPK) {
		this.almacenPK = almacenPK;
	}

	public String getAlmCoda() {
		return almCoda;
	}

	public void setAlmCoda(String almCoda) {
		this.almCoda = almCoda;
	}

	public String getAlmNombre() {
		return almNombre;
	}

	public void setAlmNombre(String almNombre) {
		this.almNombre = almNombre;
	}

	public String getAlmEstado() {
		return almEstado;
	}

	public void setAlmEstado(String almEstado) {
		this.almEstado = almEstado;
	}

	public String getAlmSigla() {
		return almSigla;
	}

	public void setAlmSigla(String almSigla) {
		this.almSigla = almSigla;
	}

	public Recinto getRecinto() {
		return recinto;
	}

	public void setRecinto(Recinto recinto) {
		this.recinto = recinto;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (almacenPK != null ? almacenPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Almacen)) {
			return false;
		}
		Almacen other = (Almacen) object;
		if ((this.almacenPK == null && other.almacenPK != null)
				|| (this.almacenPK != null && !this.almacenPK.equals(other.almacenPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.Almacen[ almacenPK=" + almacenPK + " ]";
	}
}
