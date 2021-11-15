package com.albo.controlop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "oauth_access_token", schema = "PUBLIC")
public class OauthAccessToken implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "token_id", unique = true, nullable = false)
	private String token_id;

	@Column(name = "token", nullable = false)
	private byte[] token;

	@Column(name = "authentication_id", nullable = true)
	private String authentication_id;

	@Column(name = "user_name", nullable = true)
	private String user_name;

	@Column(name = "client_id", nullable = true)
	private String client_id;

	@Column(name = "authentication", nullable = true)
	private byte[] authentication;

	@Column(name = "refresh_token", nullable = true)
	private String refresh_token;

	public String getToken_id() {
		return token_id;
	}

	public void setToken_id(String token_id) {
		this.token_id = token_id;
	}

	public byte[] getToken() {
		return token;
	}

	public void setToken(byte[] token) {
		this.token = token;
	}

	public String getAuthentication_id() {
		return authentication_id;
	}

	public void setAuthentication_id(String authentication_id) {
		this.authentication_id = authentication_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public byte[] getAuthentication() {
		return authentication;
	}

	public void setAuthentication(byte[] authentication) {
		this.authentication = authentication;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
}
