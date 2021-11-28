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
@Table(name = "TIPO_CLIENTE", catalog = "", schema = "SOA")
public class TipoCliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "TCL_COD", nullable = false, length = 3)
	private String tclCod;
	@Column(name = "TCL_NOMBRE", length = 50)
	private String tclNombre;
	@Column(name = "TCL_ESTADO", length = 3)
	private String tclEstado;
	@OneToMany(mappedBy = "tclCod")
	private Set<Cliente> clienteSet;

	public TipoCliente() {
	}

	public TipoCliente(String tclCod) {
		this.tclCod = tclCod;
	}

	public String getTclCod() {
		return tclCod;
	}

	public void setTclCod(String tclCod) {
		this.tclCod = tclCod;
	}

	public String getTclNombre() {
		return tclNombre;
	}

	public void setTclNombre(String tclNombre) {
		this.tclNombre = tclNombre;
	}

	public String getTclEstado() {
		return tclEstado;
	}

	public void setTclEstado(String tclEstado) {
		this.tclEstado = tclEstado;
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
		hash += (tclCod != null ? tclCod.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof TipoCliente)) {
			return false;
		}
		TipoCliente other = (TipoCliente) object;
		if ((this.tclCod == null && other.tclCod != null)
				|| (this.tclCod != null && !this.tclCod.equals(other.tclCod))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.TipoCliente[ tclCod=" + tclCod + " ]";
	}

}
