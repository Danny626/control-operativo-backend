package com.albo.controlop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tarea", schema = "PUBLIC")
public class Tarea implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Long id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "tipo", nullable = false)
	private String tipo;

	@Column(name = "cron", nullable = false)
	private String cron;

	@Column(name = "body", nullable = false, length = 500)
	private String body;

	@ManyToOne
	@JoinColumn(name = "recinto", nullable = false, referencedColumnName = "rec_cod")
	private Recinto recinto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Recinto getRecinto() {
		return recinto;
	}

	public void setRecinto(Recinto recinto) {
		this.recinto = recinto;
	}

}
