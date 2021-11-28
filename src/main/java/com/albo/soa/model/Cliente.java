package com.albo.soa.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "CLIENTE", catalog = "", schema = "SOA")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "CLI_COD", nullable = false, length = 80)
	private String cliCod;
	@Column(name = "CLI_NOMBRE", length = 60)
	private String cliNombre;
	@Column(name = "CLI_DIRECCION", length = 150)
	private String cliDireccion;
	@Column(name = "CLI_TELEFONO", length = 80)
	private String cliTelefono;
	@Column(name = "CLI_ESTADO", length = 5)
	private String cliEstado;

	@Column(name = "CLI_FECHA")
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime cliFecha;

	@Column(name = "CLI_CELULAR", length = 80)
	private String cliCelular;

	@Column(name = "CLI_FECHA_EDIT")
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime cliFechaEdit;

	@JoinColumn(name = "USR_COD", referencedColumnName = "USR_COD")
	@ManyToOne
	private UsuarioSoa usrCod;
	@JoinColumn(name = "USR_COD_EDIT", referencedColumnName = "USR_COD")
	@ManyToOne
	private UsuarioSoa usrCodEdit;
	@JoinColumn(name = "TCL_COD", referencedColumnName = "TCL_COD")
	@ManyToOne
	private TipoCliente tclCod;
	@JoinColumn(name = "CIU_COD", referencedColumnName = "CIU_COD")
	@ManyToOne
	private Ciudad ciuCod;

	public Cliente() {
	}

	public Cliente(String cliCod) {
		this.cliCod = cliCod;
	}

	public String getCliCod() {
		return cliCod;
	}

	public void setCliCod(String cliCod) {
		this.cliCod = cliCod;
	}

	public String getCliNombre() {
		return cliNombre;
	}

	public void setCliNombre(String cliNombre) {
		this.cliNombre = cliNombre == null ? "" : cliNombre.toUpperCase();
	}

	public String getCliDireccion() {
		return cliDireccion;
	}

	public void setCliDireccion(String cliDireccion) {
		this.cliDireccion = cliDireccion == null ? "" : cliDireccion.toUpperCase();
	}

	public String getCliTelefono() {
		return cliTelefono;
	}

	public void setCliTelefono(String cliTelefono) {
		this.cliTelefono = cliTelefono;
	}

	public String getCliEstado() {
		return cliEstado;
	}

	public void setCliEstado(String cliEstado) {
		this.cliEstado = cliEstado;
	}

	public LocalDateTime getCliFecha() {
		return cliFecha;
	}

	public void setCliFecha(LocalDateTime cliFecha) {
		this.cliFecha = cliFecha;
	}

	public void setCliFechaEdit(LocalDateTime cliFechaEdit) {
		this.cliFechaEdit = cliFechaEdit;
	}

	public String getCliCelular() {
		return cliCelular;
	}

	public void setCliCelular(String cliCelular) {
		this.cliCelular = cliCelular;
	}

	public UsuarioSoa getUsrCod() {
		return usrCod;
	}

	public void setUsrCod(UsuarioSoa usrCod) {
		this.usrCod = usrCod;
	}

	public UsuarioSoa getUsrCodEdit() {
		return usrCodEdit;
	}

	public void setUsrCodEdit(UsuarioSoa usrCodEdit) {
		this.usrCodEdit = usrCodEdit;
	}

	public TipoCliente getTclCod() {
		return tclCod;
	}

	public void setTclCod(TipoCliente tclCod) {
		this.tclCod = tclCod;
	}

	public Ciudad getCiuCod() {
		return ciuCod;
	}

	public void setCiuCod(Ciudad ciuCod) {
		this.ciuCod = ciuCod;
	}

	public LocalDateTime getCliFechaEdit() {
		return cliFechaEdit;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (cliCod != null ? cliCod.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Cliente)) {
			return false;
		}
		Cliente other = (Cliente) object;
		if ((this.cliCod == null && other.cliCod != null)
				|| (this.cliCod != null && !this.cliCod.equals(other.cliCod))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.Cliente[ cliCod=" + cliCod + " ]";
	}

}
