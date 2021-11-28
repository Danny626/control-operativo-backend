package com.albo.soa.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TipoBajaMnfPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@Column(name = "REC_COD", nullable = false, length = 5)
	private String recCod;
	@Basic(optional = false)
	@Column(name = "TBM_COD", nullable = false, length = 5)
	private String tbmCod;

	public TipoBajaMnfPK() {
	}

	public TipoBajaMnfPK(String recCod, String tbmCod) {
		this.recCod = recCod;
		this.tbmCod = tbmCod;
	}

	public String getRecCod() {
		return recCod;
	}

	public void setRecCod(String recCod) {
		this.recCod = recCod;
	}

	public String getTbmCod() {
		return tbmCod;
	}

	public void setTbmCod(String tbmCod) {
		this.tbmCod = tbmCod;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (recCod != null ? recCod.hashCode() : 0);
		hash += (tbmCod != null ? tbmCod.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof TipoBajaMnfPK)) {
			return false;
		}
		TipoBajaMnfPK other = (TipoBajaMnfPK) object;
		if ((this.recCod == null && other.recCod != null)
				|| (this.recCod != null && !this.recCod.equals(other.recCod))) {
			return false;
		}
		if ((this.tbmCod == null && other.tbmCod != null)
				|| (this.tbmCod != null && !this.tbmCod.equals(other.tbmCod))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.TipoBajaMnfPK[ recCod=" + recCod + ", tbmCod=" + tbmCod + " ]";
	}

}
