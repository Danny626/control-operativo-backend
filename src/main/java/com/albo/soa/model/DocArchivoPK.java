package com.albo.soa.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DocArchivoPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@Column(name = "REC_COD", nullable = false, length = 5)
	private String recCod;
	@Basic(optional = false)
	@Column(name = "DAR_GESTION", nullable = false)
	private int darGestion;
	@Basic(optional = false)
	@Column(name = "DAR_TIPO", nullable = false, length = 5)
	private String darTipo;
	@Basic(optional = false)
	@Column(name = "DAR_COD", nullable = false, length = 80)
	private String darCod;
	@Basic(optional = false)
	@Column(name = "DAR_NRO", nullable = false, length = 15)
	private String darNro;

	public DocArchivoPK() {
	}

	public DocArchivoPK(String recCod, int darGestion, String darTipo, String darCod, String darNro) {
		this.recCod = recCod;
		this.darGestion = darGestion;
		this.darTipo = darTipo;
		this.darCod = darCod;
		this.darNro = darNro;
	}

	public String getRecCod() {
		return recCod;
	}

	public void setRecCod(String recCod) {
		this.recCod = recCod;
	}

	public int getDarGestion() {
		return darGestion;
	}

	public void setDarGestion(int darGestion) {
		this.darGestion = darGestion;
	}

	public void setDarGestion() {
		Calendar Calend = Calendar.getInstance();
		this.darGestion = (int) Calend.get(Calendar.YEAR);
	}

	public String getDarTipo() {
		return darTipo;
	}

	public void setDarTipo(String darTipo) {
		this.darTipo = darTipo;
	}

	public String getDarCod() {
		return darCod;
	}

	public void setDarCod(String darCod) {
		this.darCod = darCod;
	}

	public String getDarNro() {
		return darNro;
	}

	public void setDarNro(String darNro) {
		this.darNro = darNro;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (recCod != null ? recCod.hashCode() : 0);
		hash += (int) darGestion;
		hash += (darTipo != null ? darTipo.hashCode() : 0);
		hash += (darCod != null ? darCod.hashCode() : 0);
		hash += (darNro != null ? darNro.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof DocArchivoPK)) {
			return false;
		}
		DocArchivoPK other = (DocArchivoPK) object;
		if ((this.recCod == null && other.recCod != null)
				|| (this.recCod != null && !this.recCod.equals(other.recCod))) {
			return false;
		}
		if (this.darGestion != other.darGestion) {
			return false;
		}
		if ((this.darTipo == null && other.darTipo != null)
				|| (this.darTipo != null && !this.darTipo.equals(other.darTipo))) {
			return false;
		}
		if ((this.darCod == null && other.darCod != null)
				|| (this.darCod != null && !this.darCod.equals(other.darCod))) {
			return false;
		}
		if ((this.darNro == null && other.darNro != null)
				|| (this.darNro != null && !this.darNro.equals(other.darNro))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.DocArchivoPK[ recCod=" + recCod + ", darGestion=" + darGestion + ", darTipo="
				+ darTipo + ", darCod=" + darCod + ", darNro=" + darNro + " ]";
	}

}
