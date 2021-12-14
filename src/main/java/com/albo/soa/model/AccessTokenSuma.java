package com.albo.soa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ACCESS_TOKEN_SUMA", catalog = "", schema = "SOA")
public class AccessTokenSuma implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCESS_TOKEN_SUMA_SEQ")
	@SequenceGenerator(name = "ACCESS_TOKEN_SUMA_SEQ", sequenceName = "ACCESS_TOKEN_SUMA_SEQ", allocationSize = 1)
	@Column(name = "ID", nullable = false, unique = true)
	private Long id;

	@Column(name = "USUARIO", nullable = false, unique = true)
	private String usuario;

	@Column(name = "TOKEN", nullable = false)
	private String token;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

}
