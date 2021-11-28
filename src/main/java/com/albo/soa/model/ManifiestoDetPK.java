package com.albo.soa.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ManifiestoDetPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@Column(name = "MNF_COD", nullable = false, length = 30)
	private String mnfCod;
	@Basic(optional = false)
	@Column(name = "DMN_COD", nullable = false)
	private int dmnCodigo;

	public ManifiestoDetPK() {
	}

	public ManifiestoDetPK(String mnfCodigo, int dmnCodigo) {
		this.mnfCod = mnfCodigo;
		this.dmnCodigo = dmnCodigo;
	}

	public String getMnfCod() {
		return mnfCod;
	}

	public void setMnfCod(String mnfCodigo) {
		this.mnfCod = mnfCodigo;
	}

	public int getDmnCodigo() {
		return dmnCodigo;
	}

	public void setDmnCodigo(int dmnCodigo) {
		this.dmnCodigo = dmnCodigo;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (mnfCod != null ? mnfCod.hashCode() : 0);
		hash += (int) dmnCodigo;
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof ManifiestoDetPK)) {
			return false;
		}
		ManifiestoDetPK other = (ManifiestoDetPK) object;
		if ((this.mnfCod == null && other.mnfCod != null)
				|| (this.mnfCod != null && !this.mnfCod.equals(other.mnfCod))) {
			return false;
		}
		if (this.dmnCodigo != other.dmnCodigo) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.ManifiestoDetPK[ mnfCod=" + mnfCod + ", dmnCodigo=" + dmnCodigo + " ]";
	}

}
