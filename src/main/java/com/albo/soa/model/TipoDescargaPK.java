package com.albo.soa.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TipoDescargaPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@Column(name = "REC_COD", nullable = false, length = 5)
	private String recCod;
	@Basic(optional = false)
	@Column(name = "TDE_COD", nullable = false, length = 5)
	private String tdeCod;

	public TipoDescargaPK() {
	}

	public TipoDescargaPK(String recCod, String tdeCod) {
		this.recCod = recCod;
		this.tdeCod = tdeCod;
	}

	public String getRecCod() {
		return recCod;
	}

	public void setRecCod(String recCod) {
		this.recCod = recCod;
	}

	public String getTdeCod() {
		return tdeCod;
	}

	public void setTdeCod(String tdeCod) {
		this.tdeCod = tdeCod;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (recCod != null ? recCod.hashCode() : 0);
		hash += (tdeCod != null ? tdeCod.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof TipoDescargaPK)) {
			return false;
		}
		TipoDescargaPK other = (TipoDescargaPK) object;
		if ((this.recCod == null && other.recCod != null)
				|| (this.recCod != null && !this.recCod.equals(other.recCod))) {
			return false;
		}
		if ((this.tdeCod == null && other.tdeCod != null)
				|| (this.tdeCod != null && !this.tdeCod.equals(other.tdeCod))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.TipoDescargaPK[ recCod=" + recCod + ", tdeCod=" + tdeCod + " ]";
	}

}
