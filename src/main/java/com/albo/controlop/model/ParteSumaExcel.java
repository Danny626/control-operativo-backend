package com.albo.controlop.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "parte_suma", schema = "PUBLIC")
public class ParteSumaExcel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Long id;

	@Column(name = "parte_recepcion", length = 30)
	private String parteRecepcion;

	@Column(name = "gestion")
	private Integer gestion;

	@ManyToOne
	@JoinColumn(name = "adu_cod", referencedColumnName = "adu_cod")
	private Aduana aduana;

	@Column(name = "nro_registro_parte", length = 20)
	private String nroRegistroParte;

	@JsonSerialize(using = ToStringSerializer.class)
	@Column(name = "fecha_recepcion")
	private LocalDateTime fechaRecepcion;

	@ManyToOne
	@JoinColumn(name = "estado_parte", referencedColumnName = "nombre")
	private EstadoParte estadoParte;

	@Column(name = "nro_manifiesto", length = 30)
	private String nroManifiesto;

	@Column(name = "registro_manifiesto", length = 30)
	private String registroManifiesto;

	@Column(name = "documento_embarque", length = 30)
	private String documentoEmbarque;

	@Column(name = "documento_relacionado", length = 30)
	private String documentoRelacionado;

	@Column(name = "placa_patente", length = 30)
	private String placaPatente;

	@ManyToOne
	@JoinColumn(name = "destinatario_parte", nullable = false, referencedColumnName = "id")
	private DestinatarioParte destinatarioParte;

	@ManyToOne
	@JoinColumn(name = "tipo_carga_parte", nullable = false, referencedColumnName = "nombre")
	private TipoCargaParte tipoCargaParte;

	@ManyToOne
	@JoinColumn(name = "usuario_parte", nullable = false, referencedColumnName = "nombre")
	private UsuarioParte usuarioParte;

	@ManyToOne
	@JoinColumn(name = "recinto", nullable = false, referencedColumnName = "rec_cod")
	private Recinto recinto;

	@Column(name = "estado", length = 15)
	private String estado;

	@JsonSerialize(using = ToStringSerializer.class)
	@Column(name = "fecha_registro")
	private LocalDateTime fechaRegistro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getParteRecepcion() {
		return parteRecepcion;
	}

	public void setParteRecepcion(String parteRecepcion) {
		this.parteRecepcion = parteRecepcion;
	}

	public Integer getGestion() {
		return gestion;
	}

	public void setGestion(Integer gestion) {
		this.gestion = gestion;
	}

	public Aduana getAduana() {
		return aduana;
	}

	public void setAduana(Aduana aduana) {
		this.aduana = aduana;
	}

	public String getNroRegistroParte() {
		return nroRegistroParte;
	}

	public void setNroRegistroParte(String nroRegistroParte) {
		this.nroRegistroParte = nroRegistroParte;
	}

	public LocalDateTime getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(LocalDateTime fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public EstadoParte getEstadoParte() {
		return estadoParte;
	}

	public void setEstadoParte(EstadoParte estadoParte) {
		this.estadoParte = estadoParte;
	}

	public String getNroManifiesto() {
		return nroManifiesto;
	}

	public void setNroManifiesto(String nroManifiesto) {
		this.nroManifiesto = nroManifiesto;
	}

	public String getRegistroManifiesto() {
		return registroManifiesto;
	}

	public void setRegistroManifiesto(String registroManifiesto) {
		this.registroManifiesto = registroManifiesto;
	}

	public String getDocumentoEmbarque() {
		return documentoEmbarque;
	}

	public void setDocumentoEmbarque(String documentoEmbarque) {
		this.documentoEmbarque = documentoEmbarque;
	}

	public String getDocumentoRelacionado() {
		return documentoRelacionado;
	}

	public void setDocumentoRelacionado(String documentoRelacionado) {
		this.documentoRelacionado = documentoRelacionado;
	}

	public String getPlacaPatente() {
		return placaPatente;
	}

	public void setPlacaPatente(String placaPatente) {
		this.placaPatente = placaPatente;
	}

	public TipoCargaParte getTipoCargaParte() {
		return tipoCargaParte;
	}

	public void setTipoCargaParte(TipoCargaParte tipoCargaParte) {
		this.tipoCargaParte = tipoCargaParte;
	}

	public Recinto getRecinto() {
		return recinto;
	}

	public void setRecinto(Recinto recinto) {
		this.recinto = recinto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public DestinatarioParte getDestinatarioParte() {
		return destinatarioParte;
	}

	public void setDestinatarioParte(DestinatarioParte destinatarioParte) {
		this.destinatarioParte = destinatarioParte;
	}

	public UsuarioParte getUsuarioParte() {
		return usuarioParte;
	}

	public void setUsuarioParte(UsuarioParte usuarioParte) {
		this.usuarioParte = usuarioParte;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
