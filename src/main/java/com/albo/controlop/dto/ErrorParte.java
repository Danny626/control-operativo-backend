package com.albo.controlop.dto;

public class ErrorParte {

	private String parte;
	private String mensaje;

	public ErrorParte(String parte, String mensaje) {
		super();
		this.parte = parte;
		this.mensaje = mensaje;
	}

	public String getParte() {
		return parte;
	}

	public void setParte(String parte) {
		this.parte = parte;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
