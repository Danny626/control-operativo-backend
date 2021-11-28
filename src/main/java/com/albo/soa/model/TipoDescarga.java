package com.albo.soa.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_DESCARGA", catalog = "", schema = "SOA")
public class TipoDescarga implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	protected TipoDescargaPK tipoDescargaPK;
	@Basic(optional = false)
	@Column(name = "TDE_NOMBRE", nullable = false, length = 50)
	private String tdeNombre;
	@Column(name = "TDE_ESTADO", length = 3)
	private String tdeEstado;
	@JoinColumn(name = "REC_COD", referencedColumnName = "REC_COD", nullable = false, insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Recinto recinto;

	public TipoDescarga() {
	}

	public TipoDescarga(TipoDescargaPK tipoDescargaPK) {
		this.tipoDescargaPK = tipoDescargaPK;
	}

	public TipoDescarga(TipoDescargaPK tipoDescargaPK, String tdeNombre) {
		this.tipoDescargaPK = tipoDescargaPK;
		this.tdeNombre = tdeNombre;
	}

	public TipoDescarga(String recCod, String tdeCod) {
		this.tipoDescargaPK = new TipoDescargaPK(recCod, tdeCod);
	}

	public TipoDescargaPK getTipoDescargaPK() {
		return tipoDescargaPK;
	}

	public void setTipoDescargaPK(TipoDescargaPK tipoDescargaPK) {
		this.tipoDescargaPK = tipoDescargaPK;
	}

	public String getTdeNombre() {
		return tdeNombre;
	}

	public void setTdeNombre(String tdeNombre) {
		this.tdeNombre = tdeNombre;
	}

	public String getTdeEstado() {
		return tdeEstado;
	}

	public void setTdeEstado(String tdeEstado) {
		this.tdeEstado = tdeEstado;
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
		hash += (tipoDescargaPK != null ? tipoDescargaPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof TipoDescarga)) {
			return false;
		}
		TipoDescarga other = (TipoDescarga) object;
		if ((this.tipoDescargaPK == null && other.tipoDescargaPK != null)
				|| (this.tipoDescargaPK != null && !this.tipoDescargaPK.equals(other.tipoDescargaPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.TipoDescarga[ tipoDescargaPK=" + tipoDescargaPK + " ]";
	}

}
