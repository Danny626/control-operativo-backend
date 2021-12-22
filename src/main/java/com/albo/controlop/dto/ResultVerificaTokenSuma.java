package com.albo.controlop.dto;

import com.albo.suma.model.Usuario;

public class ResultVerificaTokenSuma {

	private String token;
	private String estado;
	private Usuario usuario;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
