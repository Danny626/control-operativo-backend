package com.albo.controlop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "destinatario_parte", schema = "PUBLIC")
public class DestinatarioParte implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Long id;

	@Column(name = "nombre", nullable = false, unique = true)
	private String nombre;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "destinatarioParte")
	private List<ParteSumaExcel> partesSuma = new ArrayList<ParteSumaExcel>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ParteSumaExcel> getPartesSuma() {
		return partesSuma;
	}

	public void setPartesSuma(List<ParteSumaExcel> partesSuma) {
		this.partesSuma = partesSuma;
	}

}
