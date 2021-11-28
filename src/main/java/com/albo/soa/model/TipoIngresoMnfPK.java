package com.albo.soa.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TipoIngresoMnfPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@Column(name = "REC_COD", nullable = false, length = 5)
	private String recCod;
	@Basic(optional = false)
	@Column(name = "TIM_COD", nullable = false, length = 5)
	private String timCod;

	public TipoIngresoMnfPK() {
	}

	public TipoIngresoMnfPK(String recCod, String timCod) {
		this.recCod = recCod;
		this.timCod = timCod;
	}

	public String getRecCod() {
		return recCod;
	}

	public void setRecCod(String recCod) {
		this.recCod = recCod;
	}

	public String getTimCod() {
		return timCod;
	}

	public void setTimCod(String timCod) {
		this.timCod = timCod;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (recCod != null ? recCod.hashCode() : 0);
		hash += (timCod != null ? timCod.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof TipoIngresoMnfPK)) {
			return false;
		}
		TipoIngresoMnfPK other = (TipoIngresoMnfPK) object;
		if ((this.recCod == null && other.recCod != null)
				|| (this.recCod != null && !this.recCod.equals(other.recCod))) {
			return false;
		}
		if ((this.timCod == null && other.timCod != null)
				|| (this.timCod != null && !this.timCod.equals(other.timCod))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.TipoIngresoMnfPK[ recCod=" + recCod + ", timCod=" + timCod + " ]";
	}

}
