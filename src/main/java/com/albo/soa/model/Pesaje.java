package com.albo.soa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.albo.util.EnumUtil;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "PESAJE", catalog = "", schema = "SOA")
public class Pesaje implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	protected PesajePK pesajePK;
	@Basic(optional = false)
	@Column(name = "PSJ_PLACA", nullable = false, length = 20)
	private String psjPlaca;
	@Basic(optional = false)
	@Column(name = "PSJ_PESO", nullable = false, precision = 30, scale = 2)
	private BigDecimal psjPeso;
	@Basic(optional = false)

	@Column(name = "PSJ_FECHA", nullable = false)
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime psjFecha;

	@Basic(optional = false)
	@Column(name = "PSJ_ESTADO", nullable = false, length = 5)
	private String psjEstado;
	@Basic(optional = false)
	@Column(name = "BLZ_COD", nullable = false, length = 20)
	private String blzCod;
	@Lob
	@Column(name = "PSJ_OBSERVACION")
	private String psjObservacion;
	@Column(name = "MNF_COD", length = 30)
	private String mnfCod;
	@Basic(optional = false)
	@Column(name = "USR_COD", nullable = false, length = 30)
	private String usrCod;
	@Basic(optional = false)
	@Column(name = "PSJ_OPERACION", nullable = false, length = 7)
	private String psjOperacion;
	@Column(name = "PSJ_TARA", precision = 30, scale = 2)
	private BigDecimal psjTara;
	@Column(name = "PSJ_NETO", precision = 30, scale = 2)
	private BigDecimal psjNeto;
	@JoinColumn(name = "TIC_COD", referencedColumnName = "TIC_COD")
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	private TipoCarga ticCod;
	@Basic(optional = false)

	@Column(name = "PSJ_FECHA_BLZ", nullable = false)
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime psjFechaBlz;

	@Basic(optional = false)
	@Column(name = "PSJ_FECHA_REGISTRO", nullable = false)
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime psjFechaRegistro;

	@Column(name = "PSJ_NUMERACION")
	private BigInteger psjNumeracion;
	@Column(name = "PSJ_CODCONTROL", length = 100)
	private String psjCodcontrol;

	public Pesaje() {
	}

	public Pesaje(PesajePK pesajePK) {
		this.pesajePK = pesajePK;
	}

	public Pesaje(PesajePK pesajePK, String psjPlaca, BigDecimal psjPeso, LocalDateTime psjFecha, String psjEstado,
			String blzCod) {
		this.pesajePK = pesajePK;
		this.psjPlaca = psjPlaca;
		this.psjPeso = psjPeso;
		this.psjFecha = psjFecha;
		this.psjEstado = psjEstado;
		this.blzCod = blzCod;
	}

	public Pesaje(BigInteger psjGestion, BigInteger psjCod) {
		this.pesajePK = new PesajePK(psjGestion, psjCod);
	}

	public Pesaje(String psjPlaca, LocalDateTime psjFecha) {
		this.psjPlaca = psjPlaca;
		this.psjFecha = psjFecha;
	}

	public PesajePK getPesajePK() {
		return pesajePK;
	}

	public String getPsjPK() {
		String pk = "";
		if (pesajePK != null) {
			pk = pesajePK.getPsjGestion().toString() + pesajePK.getPsjCod().toString();
		}
		return pk;
	}

	public void setPesajePK(PesajePK pesajePK) {
		this.pesajePK = pesajePK;
	}

	public String getPsjPlaca() {
		return psjPlaca == null ? "" : psjPlaca;
	}

	public void setPsjPlaca(String psjPlaca) {
		this.psjPlaca = psjPlaca;
	}

	public BigDecimal getPsjPeso() {
		return psjPeso;
	}

	public void setPsjPeso(BigDecimal psjPeso) {
		this.psjPeso = psjPeso;
	}

	public String getPsjEstado() {
		return psjEstado;
	}

	public void setPsjEstado(String psjEstado) {
		this.psjEstado = psjEstado;
	}

	public String getBlzCod() {
		return blzCod == null ? "" : blzCod;
	}

	public void setBlzCod(String blzCod) {
		this.blzCod = blzCod;
	}

	public String getPsjObservacion() {
		return psjObservacion == null ? "" : psjObservacion;
	}

	public void setPsjObservacion(String psjObservacion) {
		this.psjObservacion = psjObservacion == null ? "" : psjObservacion.toUpperCase();
	}

	public String getMnfCod() {
		return mnfCod == null ? "" : mnfCod;
	}

	public void setMnfCod(String mnfCod) {
		this.mnfCod = mnfCod;
	}

	public String getUsrCod() {
		return usrCod;
	}

	public void setUsrCod(String usrCod) {
		this.usrCod = usrCod;
	}

	public String getPsjOperacion() {
		return psjOperacion;
	}

	public void setPsjOperacion(String psjOperacion) {
		this.psjOperacion = psjOperacion;
	}

	public TipoCarga getTicCod() {
		return ticCod;
	}

	public void setTicCod(TipoCarga ticCod) {
		this.ticCod = ticCod;
	}

	public BigDecimal getPsjTara() {
		return psjTara == null ? BigDecimal.ZERO : psjTara;
	}

	public void setPsjTara(BigDecimal psjTara) {
		this.psjTara = psjTara;
	}

	public BigDecimal getPsjNeto() {
		return psjNeto == null ? BigDecimal.ZERO : psjNeto;
	}

	public void setPsjNeto(BigDecimal psjNeto) {
		this.psjNeto = psjNeto;
	}

	public String getPsjDescOperacion() {
		String operacion;
		if (psjOperacion == null) {
			operacion = "-";
		} else {
			operacion = EnumUtil.Proceso.getValor(psjOperacion);
		}
		return operacion;
	}

	public BigInteger getPsjNumeracion() {
		return psjNumeracion;
	}

	public void setPsjNumeracion(BigInteger psjNumeracion) {
		psjNumeracion = psjNumeracion == null ? BigInteger.ZERO : psjNumeracion;
		if (this.psjNumeracion == null && psjNumeracion != BigInteger.ZERO) {
			this.psjNumeracion = psjNumeracion;
		}
	}

	public String getPsjCodcontrol() {
		return psjCodcontrol;
	}

	public void setPsjCodcontrol(String psjCodcontrol) {
		psjCodcontrol = psjCodcontrol == null ? "" : psjCodcontrol;
		if (!psjCodcontrol.isEmpty()) {
			if (this.psjCodcontrol == null || this.psjCodcontrol.isEmpty()) {
				this.psjCodcontrol = psjCodcontrol;
			}
		}
	}

	public LocalDateTime getPsjFecha() {
		return psjFecha;
	}

	public void setPsjFecha(LocalDateTime psjFecha) {
		this.psjFecha = psjFecha;
	}

	public LocalDateTime getPsjFechaBlz() {
		return psjFechaBlz;
	}

	public void setPsjFechaBlz(LocalDateTime psjFechaBlz) {
		this.psjFechaBlz = psjFechaBlz;
	}

	public LocalDateTime getPsjFechaRegistro() {
		return psjFechaRegistro;
	}

	public void setPsjFechaRegistro(LocalDateTime psjFechaRegistro) {
		this.psjFechaRegistro = psjFechaRegistro;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (pesajePK != null ? pesajePK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Pesaje)) {
			return false;
		}
		Pesaje other = (Pesaje) object;
		if ((this.pesajePK == null && other.pesajePK != null)
				|| (this.pesajePK != null && !this.pesajePK.equals(other.pesajePK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.Pesaje[ pesajePK=" + pesajePK + " ]";
	}

}
