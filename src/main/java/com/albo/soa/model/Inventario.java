package com.albo.soa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.albo.util.EnumUtil;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "INVENTARIO", catalog = "", schema = "SOA")
public class Inventario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "INV_PARTE")
	private String invParte;
	@Basic(optional = false)
	@Column(name = "INV_NRO")
	private String invNro;
	@Column(name = "INV_ADUANA")
	private String invAduana;
	@Column(name = "INV_GESTION")
	private String invGestion;
	@Column(name = "INV_NROREG")
	private String invNroreg;
	@Column(name = "INV_EMBARQUE")
	private String invEmbarque;
	@Column(name = "INV_PLACA")
	private String invPlaca;
	@Column(name = "INV_NITCONS")
	private String invNitcons;
	@Column(name = "INV_NOMCONS")
	private String invNomcons;

	@Column(name = "INV_FECHA")
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime invFecha;

	@Column(name = "INV_FECHA_ANPR")
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime invFechaAnpr;

	@Column(name = "INV_FECHAING")
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime invFechaing;

	@Column(name = "INV_FECHA_ANING")
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime invFechaAning;

	@Column(name = "INV_ESTADO")
	private String invEstado;
	@Column(name = "INV_OBS")
	private String invObs;
	@Column(name = "INV_BULTO_MNF")
	private Long invBultoMnf;
	@Column(name = "INV_PESO_MNF")
	private BigDecimal invPesoMnf;
	@Column(name = "TRD_COD", length = 15)
	private String trdCod;
	@Column(name = "INV_BULTO_REC")
	private Long invBultoRec;
	@Column(name = "INV_PESO_REC")
	private BigDecimal invPesoRec;
	@Column(name = "INV_BULTO_SALDO")
	private Long invBultoSaldo;
	@Column(name = "INV_PESO_SALDO")
	private BigDecimal invPesoSaldo;
	@Column(name = "LOCALIZACION")
	private String localizacion;
	@Column(name = "INV_OBT_INFO")
	private String invObtInfo;
	@Column(name = "INV_CONSOL")
	private String invConsol;
	@Column(name = "INV_NITTRANS", length = 50)
	private String invNittrans;
	@Column(name = "INV_NOMTRANS", length = 100)
	private String invNomtrans;
	@Column(name = "INV_NOMCONS_ANTERIOR", length = 100)
	private String invNomconsAnterior;
	@Column(name = "USR_COD", length = 30)
	private String usrCod;
	@Column(name = "INV_GESTION_REG", length = 5)
	private String invGestionReg;
	@Column(name = "NIT_CLIENTE", length = 20)
	private String nitCliente;
	@Column(name = "MARCANUMERO", length = 300)
	private String marcanumero;

	@ManyToOne
	@JoinColumn(name = "TRA_COD", referencedColumnName = "TRA_COD")
	private TratamientoDeposito traCod;

	@ManyToOne(optional = false)
	@JoinColumn(name = "INV_RECINTO", referencedColumnName = "REC_COD")
	private Recinto invRecinto;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "MNF_COD", referencedColumnName = "MNF_COD"),
			@JoinColumn(name = "DMN_COD", referencedColumnName = "DMN_COD") })
	private ManifiestoDet manifiestoDet;

	@JoinColumns({ @JoinColumn(name = "REC_COD", referencedColumnName = "REC_COD"),
			@JoinColumn(name = "ALM_COD", referencedColumnName = "ALM_COD") })
	@ManyToOne
	private Almacen almacen;

	public Inventario() {
	}

	public Inventario(String invParte) {
		this.invParte = invParte;
	}

	public Inventario(String invParte, String invNro) {
		this.invParte = invParte;
		this.invNro = invNro;
	}

	public String getInvParte() {
		return invParte;
	}

	public void setInvParte(String invParte) {
		this.invParte = invParte;
	}

	public String getInvNro() {
		return invNro;
	}

	public void setInvNro(String invNro) {
		this.invNro = invNro;
	}

	public String getInvAduana() {
		return invAduana;
	}

	public void setInvAduana(String invAduana) {
		this.invAduana = invAduana;
	}

	public String getInvGestion() {
		return invGestion;
	}

	public void setInvGestion(String invGestion) {
		this.invGestion = invGestion;
	}

	public String getInvNroreg() {
		return invNroreg;
	}

	public void setInvNroreg(String invNroreg) {
		this.invNroreg = invNroreg;
	}

	public String getInvEmbarque() {
		return invEmbarque;
	}

	public void setInvEmbarque(String invEmbarque) {
		this.invEmbarque = invEmbarque;
	}

	public String getInvPlaca() {
		return invPlaca;
	}

	public void setInvPlaca(String invPlaca) {
		this.invPlaca = invPlaca;
	}

	public String getInvNitcons() {
		return invNitcons;
	}

	public void setInvNitcons(String invNitcons) {
		this.invNitcons = invNitcons;
	}

	public String getInvNomcons() {
		return invNomcons;
	}

	public void setInvNomcons(String invNomcons) {
		this.invNomcons = invNomcons;
	}

	public String getInvEstado() {
		return invEstado;
	}

	public void setInvEstado(String invEstado) {
		this.invEstado = invEstado;
	}

	/**
	 * Obtiene la descripción de mnfEstado
	 *
	 * @return String
	 */
	public String getMnfEstadoDesc() {
		return EnumUtil.Estado.getValor(invEstado);
	}

	public String getInvObs() {
		return invObs;
	}

	public void setInvObs(String invObs) {
		this.invObs = invObs;
	}

	public Long getInvBultoMnf() {
		return invBultoMnf;
	}

	public void setInvBultoMnf(Long invBultoMnf) {
		this.invBultoMnf = invBultoMnf;
	}

	public BigDecimal getInvPesoMnf() {
		return invPesoMnf;
	}

	public void setInvPesoMnf(BigDecimal invPesoMnf) {
		this.invPesoMnf = invPesoMnf;
	}

	public String getTrdCod() {
		return trdCod;
	}

	public void setTrdCod(String trdCod) {
		this.trdCod = trdCod;
	}

	public Long getInvBultoRec() {
		return invBultoRec;
	}

	public void setInvBultoRec(Long invBultoRec) {
		this.invBultoRec = invBultoRec;
	}

	public BigDecimal getInvPesoRec() {
		return invPesoRec;
	}

	public void setInvPesoRec(BigDecimal invPesoRec) {
		this.invPesoRec = invPesoRec;
	}

	public Long getInvBultoSaldo() {
		return invBultoSaldo;
	}

	public void setInvBultoSaldo(Long invBultoSaldo) {
		this.invBultoSaldo = invBultoSaldo;
	}

	public BigDecimal getInvPesoSaldo() {
		return invPesoSaldo;
	}

	public void setInvPesoSaldo(BigDecimal invPesoSaldo) {
		this.invPesoSaldo = invPesoSaldo;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public String getInvObtInfo() {
		return invObtInfo;
	}

	public void setInvObtInfo(String invObtInfo) {
		this.invObtInfo = invObtInfo;
	}

	public String getInvConsol() {
		return invConsol;
	}

	public void setInvConsol(String invConsol) {
		this.invConsol = invConsol;
	}

	public String getInvNittrans() {
		return invNittrans = invNittrans == null ? "" : invNittrans;
	}

	public void setInvNittrans(String invNittrans) {
		this.invNittrans = invNittrans == null ? "" : invNittrans;
	}

	public String getInvNomtrans() {
		return invNomtrans = invNomtrans == null ? "" : invNomtrans;
	}

	public void setInvNomtrans(String invNomtrans) {
		this.invNomtrans = invNomtrans == null ? "" : invNomtrans;
	}

	public TratamientoDeposito getTraCod() {
		return traCod;
	}

	public void setTraCod(TratamientoDeposito traCod) {
		this.traCod = traCod;
	}

	public Recinto getInvRecinto() {
		return invRecinto;
	}

	public void setInvRecinto(Recinto invRecinto) {
		this.invRecinto = invRecinto;
	}

	public ManifiestoDet getManifiestoDet() {
		return manifiestoDet;
	}

	public void setManifiestoDet(ManifiestoDet manifiestoDet) {
		this.manifiestoDet = manifiestoDet;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	public String getAlmacenNombre() {
		return getAlmacen().getAlmNombre();
	}

	public String getInvNomconsAnterior() {
		return invNomconsAnterior;
	}

	public void setInvNomconsAnterior(String invNomconsAnterior) {
		this.invNomconsAnterior = invNomconsAnterior;
	}

	public String getUsrCod() {
		return usrCod;
	}

	public void setUsrCod(String usrCod) {
		this.usrCod = usrCod;
	}

	public String getInvGestionReg() {
		return invGestionReg;
	}

	public void setInvGestionReg(String invGestionReg) {
		this.invGestionReg = invGestionReg;
	}

	public String getNitCliente() {
		return nitCliente == null ? "" : nitCliente.trim();
	}

	public void setNitCliente(String nitCliente) {
		this.nitCliente = nitCliente;
	}

	public String getMarcanumero() {
		return marcanumero == null ? "" : marcanumero.trim();
	}

	public void setMarcanumero(String marcanumero) {
		this.marcanumero = marcanumero;
	}

	public LocalDateTime getInvFecha() {
		return invFecha;
	}

	public void setInvFecha(LocalDateTime invFecha) {
		this.invFecha = invFecha;
	}

	public LocalDateTime getInvFechaAnpr() {
		return invFechaAnpr;
	}

	public void setInvFechaAnpr(LocalDateTime invFechaAnpr) {
		this.invFechaAnpr = invFechaAnpr;
	}

	public LocalDateTime getInvFechaing() {
		return invFechaing;
	}

	public void setInvFechaing(LocalDateTime invFechaing) {
		this.invFechaing = invFechaing;
	}

	public LocalDateTime getInvFechaAning() {
		return invFechaAning;
	}

	public void setInvFechaAning(LocalDateTime invFechaAning) {
		this.invFechaAning = invFechaAning;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (invParte != null ? invParte.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Inventario)) {
			return false;
		}
		Inventario other = (Inventario) object;
		if ((this.invParte == null && other.invParte != null)
				|| (this.invParte != null && !this.invParte.equals(other.invParte))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.Inventario[ invParte=" + invParte + " ]";
	}
}
