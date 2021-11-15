package com.albo.controlop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
@Table(name = "usuario", schema = "PUBLIC")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "usuario", nullable = false, unique = true)
	private String username;

	@Column(name = "clave", nullable = false)
	private String password;

	@Column(name = "correo", nullable = false, unique = true)
	private String email;

	@Column(name = "imagen", nullable = true)
	private String pic;

	@Column(name = "nombreCompleto", nullable = true)
	private String fullname;

	@Column(name = "ocupacion", nullable = true)
	private String occupation;

	@Column(name = "telefono", nullable = true)
	private String phone;

	@Column(name = "direccion", nullable = true)
	private String address;

	@Column(name = "estado", nullable = false)
	private String state;


	@ManyToOne
	@JoinColumn(name = "rol", nullable = false, referencedColumnName = "nombre")
	private Rol rol;

	/* recinto al que pertenece el Usuario */
	@ManyToOne
	@JoinColumn(name = "recinto", nullable = false, referencedColumnName = "rec_cod")
	private Recinto recinto;
	
//	@JsonBackReference(value = "rol_join")
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "usuario"), inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "nombre"))
//	private List<Rol> roles = new ArrayList<Rol>();

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario")
	private List<ResetToken> resetTokens = new ArrayList<ResetToken>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<ResetToken> getResetTokens() {
		return resetTokens;
	}

	public void setResetTokens(List<ResetToken> resetTokens) {
		this.resetTokens = resetTokens;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Recinto getRecinto() {
		return recinto;
	}

	public void setRecinto(Recinto recinto) {
		this.recinto = recinto;
	}

}
