package com.albo.suma.model;

public class Usuario {

	private String nombreUsuario;
	private String nombre;
	private String paterno;
	private String materno;
	private String email;
	private String estado;
	private PerfilUsuario perfilUsuario;
	private Role[] roles;
	private Aduana aduana;
	private Object menus;

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public PerfilUsuario getPerfilUsuario() {
		return perfilUsuario;
	}

	public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}

	public Role[] getRoles() {
		return roles;
	}

	public void setRoles(Role[] roles) {
		this.roles = roles;
	}

	public Aduana getAduana() {
		return aduana;
	}

	public void setAduana(Aduana aduana) {
		this.aduana = aduana;
	}

	public Object getMenus() {
		return menus;
	}

	public void setMenus(Object menus) {
		this.menus = menus;
	}

}
