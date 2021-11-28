package com.albo.soa.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "USUARIO", catalog = "", schema = "SOA")
public class UsuarioSoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "USR_COD", nullable = false, length = 30)
	private String usrCod;
	@Basic(optional = false)
	@Column(name = "USR_NOMBRES", nullable = false, length = 50)
	private String usrNombres;
	@Basic(optional = false)
	@Column(name = "USR_APELLIDOS", nullable = false, length = 50)
	private String usrApellidos;
	@Basic(optional = false)
	@Column(name = "USR_PASSWD", nullable = false, length = 8)
	private String usrPasswd;
	@Basic(optional = false)
	@Column(name = "USR_ESTADO", nullable = false, length = 3)
	private String usrEstado;
	@JoinColumn(name = "ROL_COD", referencedColumnName = "ROL_COD", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private RolSoa rolCod;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usrCod")
	private Set<DocArchivo> docArchivoSet;

	public UsuarioSoa() {
	}

	public UsuarioSoa(String usrCod) {
		this.usrCod = usrCod;
	}

	public UsuarioSoa(String usrCod, String usrNombres, String usrApellidos, String usrPasswd, String usrEstado) {
		this.usrCod = usrCod;
		this.usrNombres = usrNombres;
		this.usrApellidos = usrApellidos;
		this.usrPasswd = usrPasswd;
		this.usrEstado = usrEstado;
	}

	public String getUsrCod() {
		return usrCod;
	}

	public void setUsrCod(String usrCod) {
		this.usrCod = usrCod;
	}

	public String getUsrNombres() {
		return usrNombres;
	}

	public void setUsrNombres(String usrNombres) {
		this.usrNombres = usrNombres;
	}

	public String getUsrApellidos() {
		return usrApellidos;
	}

	public void setUsrApellidos(String usrApellidos) {
		this.usrApellidos = usrApellidos;
	}

	public String getUsrPasswd() {
		return usrPasswd;
	}

	public void setUsrPasswd(String usrPasswd) {
		this.usrPasswd = usrPasswd;
	}

	public String getUsrEstado() {
		return usrEstado;
	}

	public void setUsrEstado(String usrEstado) {
		this.usrEstado = usrEstado;
	}

	public RolSoa getRolCod() {
		return rolCod;
	}

	public void setRolCod(RolSoa rolCod) {
		this.rolCod = rolCod;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (usrCod != null ? usrCod.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof UsuarioSoa)) {
			return false;
		}
		UsuarioSoa other = (UsuarioSoa) object;
		if ((this.usrCod == null && other.usrCod != null)
				|| (this.usrCod != null && !this.usrCod.equals(other.usrCod))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.Usuario[ usrCod=" + usrCod + " ]";
	}

	public Set<DocArchivo> getDocArchivoSet() {
		return docArchivoSet;
	}

	public void setDocArchivoSet(Set<DocArchivo> docArchivoSet) {
		this.docArchivoSet = docArchivoSet;
	}

}
