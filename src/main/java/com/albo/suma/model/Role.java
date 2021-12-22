package com.albo.suma.model;

public class Role {

	private String nombreRole;
	private boolean permitirCambiarPassword;
	private boolean roleOperador;

	public String getNombreRole() {
		return nombreRole;
	}

	public void setNombreRole(String nombreRole) {
		this.nombreRole = nombreRole;
	}

	public boolean isPermitirCambiarPassword() {
		return permitirCambiarPassword;
	}

	public void setPermitirCambiarPassword(boolean permitirCambiarPassword) {
		this.permitirCambiarPassword = permitirCambiarPassword;
	}

	public boolean isRoleOperador() {
		return roleOperador;
	}

	public void setRoleOperador(boolean roleOperador) {
		this.roleOperador = roleOperador;
	}

}
