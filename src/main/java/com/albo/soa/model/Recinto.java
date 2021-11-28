package com.albo.soa.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "RECINTO", catalog = "", schema = "SOA")
public class Recinto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "REC_COD", nullable = false, length = 5)
	private String recCod;
	@Column(name = "REC_CODA")
	private BigInteger recCoda;
	@Column(name = "REC_NOMBRE", length = 50)
	private String recNombre;
	@Column(name = "REC_NOMBREA", length = 50)
	private String recNombrea;
	@Column(name = "REC_ESTADO", length = 5)
	private String recEstado;
	@Column(name = "REC_TIPO", length = 10)
	private String recTipo;
	@OneToMany(mappedBy = "invRecinto")
	private Set<Inventario> inventarioSet;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recinto")
	private Set<DocArchivo> docArchivoSet;

	public Recinto() {
	}

	public Recinto(String recCod) {
		this.recCod = recCod;
	}

	public String getRecCod() {
		return recCod;
	}

	public void setRecCod(String recCod) {
		this.recCod = recCod;
	}

	public BigInteger getRecCoda() {
		return recCoda;
	}

	public void setRecCoda(BigInteger recCoda) {
		this.recCoda = recCoda;
	}

	public String getRecNombre() {
		return recNombre;
	}

	public void setRecNombre(String recNombre) {
		this.recNombre = recNombre;
	}

	public String getRecNombrea() {
		return recNombrea;
	}

	public void setRecNombrea(String recNombrea) {
		this.recNombrea = recNombrea;
	}

	public String getRecEstado() {
		return recEstado;
	}

	public void setRecEstado(String recEstado) {
		this.recEstado = recEstado;
	}

	public String getRecTipo() {
		return recTipo;
	}

	public void setRecTipo(String recTipo) {
		this.recTipo = recTipo;
	}

	public Set<Inventario> getInventarioSet() {
		return inventarioSet;
	}

	public void setInventarioSet(Set<Inventario> inventarioSet) {
		this.inventarioSet = inventarioSet;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (recCod != null ? recCod.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Recinto)) {
			return false;
		}
		Recinto other = (Recinto) object;
		if ((this.recCod == null && other.recCod != null)
				|| (this.recCod != null && !this.recCod.equals(other.recCod))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.Recinto[ recCod=" + recCod + " ]";
	}

	public Set<DocArchivo> getDocArchivoSet() {
		return docArchivoSet;
	}

	public void setDocArchivoSet(Set<DocArchivo> docArchivoSet) {
		this.docArchivoSet = docArchivoSet;
	}
}
