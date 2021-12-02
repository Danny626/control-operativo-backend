package com.albo.controlop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tipo_carga_parte", schema = "PUBLIC")
public class TipoCargaParte implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "nombre", nullable = false, unique = true)
	private String nombre;

	@Column(name = "descripcion", nullable = false)
	private String descripcion;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tipoCargaParte")
	private List<ParteSuma> partesSuma = new ArrayList<ParteSuma>();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<ParteSuma> getPartesSuma() {
		return partesSuma;
	}

	public void setPartesSuma(List<ParteSuma> partesSuma) {
		this.partesSuma = partesSuma;
	}

}
