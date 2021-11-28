package com.albo.soa.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "DOC_ARCHIVO", catalog = "", schema = "SOA")
public class DocArchivo implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	protected DocArchivoPK docArchivoPK;
	@Basic(optional = false)

	@Column(name = "DAR_FECHA", nullable = false)
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime darFecha;

	@Basic(optional = false)
	@Column(name = "DAR_ESTADO", nullable = false, length = 3)
	private String darEstado;
	@JoinColumn(name = "USR_COD", referencedColumnName = "USR_COD", nullable = false)
	@ManyToOne(optional = false)
	private UsuarioSoa usrCod;
	@JoinColumn(name = "REC_COD", referencedColumnName = "REC_COD", nullable = false, insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Recinto recinto;

	public DocArchivo() {
	}

	public DocArchivo(DocArchivoPK docArchivoPK) {
		this.docArchivoPK = docArchivoPK;
	}

	public DocArchivo(String recCod, Integer gestion, String darTipo, String darCod, String darNro) {
		this.docArchivoPK = new DocArchivoPK(recCod, gestion, darTipo, darCod, darNro);
	}

	public DocArchivoPK getDocArchivoPK() {
		return docArchivoPK;
	}

	public void setDocArchivoPK(DocArchivoPK docArchivoPK) {
		this.docArchivoPK = docArchivoPK;
	}

	public LocalDateTime getDarFecha() {
		return darFecha;
	}

	public void setDarFecha(LocalDateTime darFecha) {
		this.darFecha = darFecha;
	}

	public String getDarEstado() {
		return darEstado;
	}

	public void setDarEstado(String darEstado) {
		this.darEstado = darEstado;
	}

	public UsuarioSoa getUsrCod() {
		return usrCod;
	}

	public void setUsrCod(UsuarioSoa usrCod) {
		this.usrCod = usrCod;
	}

	public Recinto getRecinto() {
		return recinto;
	}

	public void setRecinto(Recinto recinto) {
		this.recinto = recinto;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (docArchivoPK != null ? docArchivoPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof DocArchivo)) {
			return false;
		}
		DocArchivo other = (DocArchivo) object;
		if ((this.docArchivoPK == null && other.docArchivoPK != null)
				|| (this.docArchivoPK != null && !this.docArchivoPK.equals(other.docArchivoPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.DocArchivo[ docArchivoPK=" + docArchivoPK + " ]";
	}

}
