package com.albo.soa.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UbicacionPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@Column(name = "REC_COD", nullable = false, length = 5)
	private String recCod;
	@Basic(optional = false)
	@Column(name = "ALM_COD", nullable = false, length = 15)
	private String almCod;
	@Basic(optional = false)
	@Column(name = "UBI_COD", nullable = false, length = 15)
	private String ubiCod;

	public UbicacionPK() {
	}

	public UbicacionPK(String recCod, String almCod, String ubiCod) {
		this.recCod = recCod;
		this.almCod = almCod;
		this.ubiCod = ubiCod;
	}

	public String getRecCod() {
		return recCod;
	}

	public void setRecCod(String recCod) {
		this.recCod = recCod;
	}

	public String getAlmCod() {
		return almCod;
	}

	public void setAlmCod(String almCod) {
		this.almCod = almCod;
	}

	public String getUbiCod() {
		return ubiCod;
	}

	public void setUbiCod(String ubiCod) {
		this.ubiCod = ubiCod;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (recCod != null ? recCod.hashCode() : 0);
		hash += (almCod != null ? almCod.hashCode() : 0);
		hash += (ubiCod != null ? ubiCod.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof UbicacionPK)) {
			return false;
		}
		UbicacionPK other = (UbicacionPK) object;
		if ((this.recCod == null && other.recCod != null)
				|| (this.recCod != null && !this.recCod.equals(other.recCod))) {
			return false;
		}
		if ((this.almCod == null && other.almCod != null)
				|| (this.almCod != null && !this.almCod.equals(other.almCod))) {
			return false;
		}
		if ((this.ubiCod == null && other.ubiCod != null)
				|| (this.ubiCod != null && !this.ubiCod.equals(other.ubiCod))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.UbicacionPK[ recCod=" + recCod + ", almCod=" + almCod + ", ubiCod=" + ubiCod + " ]";
	}

}
