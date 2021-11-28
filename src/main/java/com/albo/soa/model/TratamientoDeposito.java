package com.albo.soa.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRATAMIENTO_DEPOSITO", catalog = "", schema = "SOA")

public class TratamientoDeposito implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "TRA_COD")
	private String traCod;
	@Column(name = "TRA_DESCRIPCION")
	private String traDescripcion;
	@Column(name = "TRA_DESCRIPCIONA")
	private String traDescripciona;
	@Column(name = "TRA_DESCRIPCIONEX")
	private String traDescripcionex;
	@Column(name = "TRA_ESTADO")
	private String traEstado;
	@Column(name = "TRA_TARIFARIO", length = 10)
	private String traTarifario;
	@Column(name = "TRA_DOCSALIDA", length = 3)
	private String traDocsalida;

	public TratamientoDeposito() {
	}

	public TratamientoDeposito(String traCod) {
		this.traCod = traCod;
	}

	public String getTraCod() {
		return traCod;
	}

	public void setTraCod(String traCod) {
		this.traCod = traCod;
	}

	public String getTraDescripcion() {
		return traDescripcion;
	}

	public void setTraDescripcion(String traDescripcion) {
		this.traDescripcion = traDescripcion;
	}

	public String getTraDescripciona() {
		return traDescripciona;
	}

	public void setTraDescripciona(String traDescripciona) {
		this.traDescripciona = traDescripciona;
	}

	public String getTraDescripcionex() {
		return traDescripcionex;
	}

	public void setTraDescripcionex(String traDescripcionex) {
		this.traDescripcionex = traDescripcionex;
	}

	public String getTraEstado() {
		return traEstado;
	}

	public void setTraEstado(String traEstado) {
		this.traEstado = traEstado;
	}

	public String getTraTarifario() {
		return traTarifario;
	}

	public void setTraTarifario(String traTarifario) {
		this.traTarifario = traTarifario;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (traCod != null ? traCod.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof TratamientoDeposito)) {
			return false;
		}
		TratamientoDeposito other = (TratamientoDeposito) object;
		if ((this.traCod == null && other.traCod != null)
				|| (this.traCod != null && !this.traCod.equals(other.traCod))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.TratamientoDeposito[ traCod=" + traCod + " ]";
	}

	public String getTraDocsalida() {
		return traDocsalida;
	}

	public void setTraDocsalida(String traDocsalida) {
		this.traDocsalida = traDocsalida;
	}

}
