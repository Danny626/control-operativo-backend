package com.albo.suma.model;

public class PerfilUsuario {

	private String nit;
	private String tipoDocumentoIdentificacion;
	private String nroDocumento;
	private String tipoDocumento;
	private String lugarEmision;
	private String telefono;
	private String telefonoCelular;
	private Object codigoGerencia;
	private Object codigoUnidad;

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getTipoDocumentoIdentificacion() {
		return tipoDocumentoIdentificacion;
	}

	public void setTipoDocumentoIdentificacion(String tipoDocumentoIdentificacion) {
		this.tipoDocumentoIdentificacion = tipoDocumentoIdentificacion;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getLugarEmision() {
		return lugarEmision;
	}

	public void setLugarEmision(String lugarEmision) {
		this.lugarEmision = lugarEmision;
	}

	public Object getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefonoCelular() {
		return telefonoCelular;
	}

	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	public Object getCodigoGerencia() {
		return codigoGerencia;
	}

	public void setCodigoGerencia(Object codigoGerencia) {
		this.codigoGerencia = codigoGerencia;
	}

	public Object getCodigoUnidad() {
		return codigoUnidad;
	}

	public void setCodigoUnidad(Object codigoUnidad) {
		this.codigoUnidad = codigoUnidad;
	}

}
