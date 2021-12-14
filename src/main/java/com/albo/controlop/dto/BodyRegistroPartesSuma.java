package com.albo.controlop.dto;

public class BodyRegistroPartesSuma {

	private String usuario;
	private String token;
	private BodyMisPartesSuma bodyMisPartesSuma;
	private ParamsMisPartesSuma paramsMisPartesSuma;
	private BodyLoginSuma bodyLoginSuma;
	private String codRecinto;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public BodyMisPartesSuma getBodyMisPartesSuma() {
		return bodyMisPartesSuma;
	}

	public void setBodyMisPartesSuma(BodyMisPartesSuma bodyMisPartesSuma) {
		this.bodyMisPartesSuma = bodyMisPartesSuma;
	}

	public ParamsMisPartesSuma getParamsMisPartesSuma() {
		return paramsMisPartesSuma;
	}

	public void setParamsMisPartesSuma(ParamsMisPartesSuma paramsMisPartesSuma) {
		this.paramsMisPartesSuma = paramsMisPartesSuma;
	}

	public BodyLoginSuma getBodyLoginSuma() {
		return bodyLoginSuma;
	}

	public void setBodyLoginSuma(BodyLoginSuma bodyLoginSuma) {
		this.bodyLoginSuma = bodyLoginSuma;
	}

	public String getCodRecinto() {
		return codRecinto;
	}

	public void setCodRecinto(String codRecinto) {
		this.codRecinto = codRecinto;
	}

}
