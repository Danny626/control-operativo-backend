package com.albo.soa.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OperacionMnfPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@Column(name = "REC_COD", nullable = false, length = 5)
	private String recCod;
	@Basic(optional = false)
	@Column(name = "OPM_COD", nullable = false, length = 5)
	private String opmCod;

	public OperacionMnfPK() {
	}

	public OperacionMnfPK(String recCod, String opmCod) {
		this.recCod = recCod;
		this.opmCod = opmCod;
	}

	public String getRecCod() {
		return recCod;
	}

	public void setRecCod(String recCod) {
		this.recCod = recCod;
	}

	public String getOpmCod() {
		return opmCod;
	}

	public void setOpmCod(String opmCod) {
		this.opmCod = opmCod;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (recCod != null ? recCod.hashCode() : 0);
		hash += (opmCod != null ? opmCod.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof OperacionMnfPK)) {
			return false;
		}
		OperacionMnfPK other = (OperacionMnfPK) object;
		if ((this.recCod == null && other.recCod != null)
				|| (this.recCod != null && !this.recCod.equals(other.recCod))) {
			return false;
		}
		if ((this.opmCod == null && other.opmCod != null)
				|| (this.opmCod != null && !this.opmCod.equals(other.opmCod))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.OperacionMnfPK[ recCod=" + recCod + ", opmCod=" + opmCod + " ]";
	}

}
