package com.albo.soa.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "REGIMEN_ADUAN", catalog = "", schema = "SOA")
public class RegimenAduan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "REG_COD", nullable = false)
	private Integer regCod;
	@Column(name = "REG_DESCRIPCION", length = 30)
	private String regDescripcion;
	@Column(name = "REG_CODA", length = 5)
	private String regCoda;
	@OneToMany(mappedBy = "regCod", fetch = FetchType.LAZY)
	private Set<ManifiestoDet> manifiestoDetSet;

	public RegimenAduan() {
	}

	public RegimenAduan(Integer regCod) {
		this.regCod = regCod;
	}

	public Integer getRegCod() {
		return regCod == null ? 0 : regCod;
	}

	public void setRegCod(Integer regCod) {
		this.regCod = regCod;
	}

	public void setRegCod(String regCod) {
		this.regCod = regCod == null ? 0 : Integer.valueOf(regCod);
	}

	public String getRegDescripcion() {
		return regDescripcion;
	}

	public void setRegDescripcion(String regDescripcion) {
		this.regDescripcion = regDescripcion;
	}

	public String getRegCoda() {
		return regCoda;
	}

	public void setRegCoda(String regCoda) {
		this.regCoda = regCoda;
	}

	public Set<ManifiestoDet> getManifiestoDetSet() {
		return manifiestoDetSet;
	}

	public void setManifiestoDetSet(Set<ManifiestoDet> manifiestoDetSet) {
		this.manifiestoDetSet = manifiestoDetSet;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (regCod != null ? regCod.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof RegimenAduan)) {
			return false;
		}
		RegimenAduan other = (RegimenAduan) object;
		if ((this.regCod == null && other.regCod != null)
				|| (this.regCod != null && !this.regCod.equals(other.regCod))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.RegimenAduan[ regCod=" + regCod + " ]";
	}

}
