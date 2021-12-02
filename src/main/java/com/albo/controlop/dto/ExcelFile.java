package com.albo.controlop.dto;

import java.time.LocalDateTime;

public class ExcelFile {

	private Long indice;
	private String parteRecepcion;
	private LocalDateTime fechaRecepcion;
	private String estado;
	private String nroManifiesto;
	private String regManifiesto;
	private String docEmbarque;
	private String docRelacionado;
	private String placaPatente;
	private String destinatario;
	private String tipoCarga;
	private String usuario;

	public Long getIndice() {
		return indice;
	}

	public void setIndice(Long indice) {
		this.indice = indice;
	}

	public String getParteRecepcion() {
		return parteRecepcion;
	}

	public void setParteRecepcion(String parteRecepcion) {
		this.parteRecepcion = parteRecepcion;
	}

	public LocalDateTime getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(LocalDateTime fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNroManifiesto() {
		return nroManifiesto;
	}

	public void setNroManifiesto(String nroManifiesto) {
		this.nroManifiesto = nroManifiesto;
	}

	public String getRegManifiesto() {
		return regManifiesto;
	}

	public void setRegManifiesto(String regManifiesto) {
		this.regManifiesto = regManifiesto;
	}

	public String getDocEmbarque() {
		return docEmbarque;
	}

	public void setDocEmbarque(String docEmbarque) {
		this.docEmbarque = docEmbarque;
	}

	public String getDocRelacionado() {
		return docRelacionado;
	}

	public void setDocRelacionado(String docRelacionado) {
		this.docRelacionado = docRelacionado;
	}

	public String getPlacaPatente() {
		return placaPatente;
	}

	public void setPlacaPatente(String placaPatente) {
		this.placaPatente = placaPatente;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getTipoCarga() {
		return tipoCarga;
	}

	public void setTipoCarga(String tipoCarga) {
		this.tipoCarga = tipoCarga;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
