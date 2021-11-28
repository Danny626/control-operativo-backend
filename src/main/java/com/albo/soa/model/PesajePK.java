package com.albo.soa.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PesajePK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@Column(name = "PSJ_GESTION", nullable = false)
	private BigInteger psjGestion;
	@Column(name = "PSJ_COD")
	private BigInteger psjCod;

	public PesajePK() {
	}

	public PesajePK(BigInteger psjGestion, BigInteger psjCod) {
		this.psjGestion = psjGestion;
		this.psjCod = psjCod;
	}

	public BigInteger getPsjGestion() {
		return psjGestion;
	}

	public void setPsjGestion() {
		Calendar Calendario = Calendar.getInstance();
		this.psjGestion = BigInteger.valueOf(Calendario.get(Calendar.YEAR));
	}

	public BigInteger getPsjCod() {
		return psjCod;
	}

	public void setPsjCod(BigInteger psjCod) {
		this.psjCod = psjCod;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (psjGestion != null ? psjGestion.hashCode() : 0);
		hash += (psjCod != null ? psjCod.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PesajePK)) {
			return false;
		}
		PesajePK other = (PesajePK) object;
		if ((this.psjGestion == null && other.psjGestion != null)
				|| (this.psjGestion != null && !this.psjGestion.equals(other.psjGestion))) {
			return false;
		}
		if ((this.psjCod == null && other.psjCod != null)
				|| (this.psjCod != null && !this.psjCod.equals(other.psjCod))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.PesajePK[ psjGestion=" + psjGestion + ", psjCod=" + psjCod + " ]";
	}

}
