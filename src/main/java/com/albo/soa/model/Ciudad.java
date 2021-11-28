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
@Table(name = "CIUDAD", catalog = "", schema = "SOA")
public class Ciudad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "CIU_COD", nullable = false)
	private Integer ciuCod;
	@Column(name = "CIU_NOMBRE", length = 60)
	private String ciuNombre;
	@Column(name = "CIU_ESTADO", length = 3)
	private String ciuEstado;
	@OneToMany(mappedBy = "ciuCod")
	private Set<Cliente> clienteSet;

	public Ciudad() {
	}

	public Ciudad(Integer ciuCod) {
		this.ciuCod = ciuCod;
	}

	public Integer getCiuCod() {
		return ciuCod;
	}

	public void setCiuCod(Integer ciuCod) {
		this.ciuCod = ciuCod;
	}

	public String getCiuNombre() {
		return ciuNombre;
	}

	public void setCiuNombre(String ciuNombre) {
		this.ciuNombre = ciuNombre;
	}

	public String getCiuEstado() {
		return ciuEstado;
	}

	public void setCiuEstado(String ciuEstado) {
		this.ciuEstado = ciuEstado;
	}

	public Set<Cliente> getClienteSet() {
		return clienteSet;
	}

	public void setClienteSet(Set<Cliente> clienteSet) {
		this.clienteSet = clienteSet;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ciuCod != null ? ciuCod.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Ciudad)) {
			return false;
		}
		Ciudad other = (Ciudad) object;
		if ((this.ciuCod == null && other.ciuCod != null)
				|| (this.ciuCod != null && !this.ciuCod.equals(other.ciuCod))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.Ciudad[ ciuCod=" + ciuCod + " ]";
	}

}
