package com.albo.soa.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_CARGA", catalog = "", schema = "SOA")
public class TipoCarga implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "TIC_COD", nullable = false, length = 5)
	private String ticCod;
	@Basic(optional = false)
	@Column(name = "TIC_NOMBRE", nullable = false, length = 20)
	private String ticNombre;
	@Basic(optional = false)
	@Column(name = "TIC_ESTADO", nullable = false, length = 3)
	private String ticEstado;
	@Column(name = "TIC_TRANSPORTE", length = 20)
	private String ticTransporte;
	@OneToMany(mappedBy = "ticCod")
	private Set<Manifiesto> manifiestoSet;

	public TipoCarga() {
	}

	public TipoCarga(String ticCod) {
		this.ticCod = ticCod;
	}

	public TipoCarga(String ticCod, String ticNombre, String ticEstado) {
		this.ticCod = ticCod;
		this.ticNombre = ticNombre;
		this.ticEstado = ticEstado;
	}

	public String getTicCod() {
		return ticCod;
	}

	public void setTicCod(String ticCod) {
		this.ticCod = ticCod;
	}

	public String getTicNombre() {
		return ticNombre;
	}

	public void setTicNombre(String ticNombre) {
		this.ticNombre = ticNombre;
	}

	public String getTicEstado() {
		return ticEstado;
	}

	public void setTicEstado(String ticEstado) {
		this.ticEstado = ticEstado;
	}

	public String getTicTransporte() {
		return ticTransporte;
	}

	public void setTicTransporte(String ticTransporte) {
		this.ticTransporte = ticTransporte;
	}

	public Set<Manifiesto> getManifiestoSet() {
		return manifiestoSet;
	}

	public void setManifiestoSet(Set<Manifiesto> manifiestoSet) {
		this.manifiestoSet = manifiestoSet;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ticCod != null ? ticCod.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof TipoCarga)) {
			return false;
		}
		TipoCarga other = (TipoCarga) object;
		if ((this.ticCod == null && other.ticCod != null)
				|| (this.ticCod != null && !this.ticCod.equals(other.ticCod))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.TipoCarga[ ticCod=" + ticCod + " ]";
	}

}
