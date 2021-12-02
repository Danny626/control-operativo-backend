package com.albo.controlop.dto;

public class ErrorExcel {

	private Integer fila;
	private String mensaje;

	public ErrorExcel(Integer fila, String mensaje) {
		super();
		this.fila = fila;
		this.mensaje = mensaje;
	}

	public Integer getFila() {
		return fila;
	}

	public void setFila(Integer fila) {
		this.fila = fila;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
