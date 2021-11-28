package com.albo.soa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.albo.util.EnumUtil;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "MANIFIESTO", catalog = "", schema = "SOA")
public class Manifiesto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "MNF_COD", nullable = false, length = 30)
	private String mnfCod;
	/**
	 * Codigo de aduana.
	 */
	@Column(name = "MNF_ADUANA", length = 5)
	private String mnfAduana;
	@Column(name = "MNF_GESTION")
	private Integer mnfGestion;
	/**
	 * Numero de registro completo: aduana, gestion y nro de registro.
	 */
	@Column(name = "MNF_NROREG", length = 20)
	private String mnfNroreg;
	@Column(name = "MNF_PLACA", length = 15)
	private String mnfPlaca;
	@Column(name = "MNF_TRANS_NIT", length = 20)
	private String mnfTransNit;
	@Column(name = "MNF_TRANS_NOM", length = 50)
	private String mnfTransNom;

	@Column(name = "MNF_FECHAREG")
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime mnfFechareg;

	@Column(name = "MNF_FECHA")
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime mnfFecha;

	@Basic(optional = false)
	@Column(name = "MNF_ESTADO", nullable = false, length = 3)
	private String mnfEstado;
	@Basic(optional = false)
	@Column(name = "MNF_ESTADO_IMP", nullable = false, length = 3)
	private String mnfEstadoImp;
	@Column(name = "MNF_PESO", precision = 13, scale = 2)
	private BigDecimal mnfPeso;
	@Column(name = "MNF_PESO_DOC", precision = 13, scale = 2)
	private BigDecimal mnfPesoDoc;
	@Basic(optional = false)
	@Column(name = "MNF_OBT_INFO", nullable = false, length = 3)
	private String mnfObtInfo;
	@Basic(optional = false)
	@Column(name = "DOC_PROCESO", nullable = false, length = 3)
	private String docProceso;
	@Column(name = "MNF_ANTERIOR", length = 30)
	private String mnfAnterior;
	@Column(name = "MNF_PLACA_SUST", length = 15)
	private String mnfPlacaSust;

	@Column(name = "MNF_FECHA_INI_TRANS")
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime mnfFechaIniTrans;

	@Column(name = "WSM_COD", length = 50)
	private String wsmCod;
	@JoinColumns({ @JoinColumn(name = "REC_COD_TIM", referencedColumnName = "REC_COD"),
			@JoinColumn(name = "TIM_COD", referencedColumnName = "TIM_COD") })
	@ManyToOne
	private TipoIngresoMnf tipoIngresoMnf;
	/**
	 * Es el recinto.
	 */
	@JoinColumn(name = "MNF_RECINTO", referencedColumnName = "REC_COD", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Recinto mnfRecinto;
	@JoinColumns({ @JoinColumn(name = "REC_COD_OPM", referencedColumnName = "REC_COD"),
			@JoinColumn(name = "MNF_OPERACION", referencedColumnName = "OPM_COD") })
	@ManyToOne
	private OperacionMnf operacionMnf;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "manifiesto", fetch = FetchType.LAZY)
	private Set<ManifiestoDet> manifiestoDetSet;
	@JoinColumn(name = "TIC_COD", referencedColumnName = "TIC_COD")
	@ManyToOne
	private TipoCarga ticCod;
	@JoinColumns({ @JoinColumn(name = "REC_COD_TBM", referencedColumnName = "REC_COD"),
			@JoinColumn(name = "TBM_COD", referencedColumnName = "TBM_COD") })
	@ManyToOne
	private TipoBajaMnf tipoBajaMnf;
	@JoinColumns({ @JoinColumn(name = "REC_COD_TBM_IMP", referencedColumnName = "REC_COD"),
			@JoinColumn(name = "TBM_COD_IMP", referencedColumnName = "TBM_COD") })
	@ManyToOne
	private TipoBajaMnf tipoBajaMnf1;
	@JoinColumns({ @JoinColumn(name = "MNF_COD_MST", referencedColumnName = "MNF_COD"),
			@JoinColumn(name = "DMN_COD_MST", referencedColumnName = "DMN_COD") })
	@ManyToOne
	private ManifiestoDet manifiestoDet;
	@JoinColumn(name = "CLI_COD", referencedColumnName = "CLI_COD")
	@ManyToOne
	private Cliente cliCod;

	public Manifiesto() {
	}

	public Manifiesto(String mnfCodigo) {
		this.mnfCod = mnfCodigo;
	}

	public Manifiesto(String mnfCodigo, LocalDateTime mnfFechareg) {
		this.mnfCod = mnfCodigo;
		this.mnfFechareg = mnfFechareg;
	}

	public Manifiesto(String mnfCod, String mnfEstado, String docProceso, String mnfEstadoImp) {
		this.mnfCod = mnfCod;
		this.mnfEstado = mnfEstado;
		this.docProceso = docProceso;
		this.mnfEstadoImp = mnfEstadoImp;
	}

	public String getMnfCod() {
		return mnfCod;
	}

	public void setMnfCod(String mnfCod) {
		this.mnfCod = mnfCod;
	}

	public String getMnfAduana() {
		return mnfAduana == null ? "" : mnfAduana;
	}

	public void setMnfAduana(String mnfAduana) {
		this.mnfAduana = mnfAduana;
	}

	public Integer getMnfGestion() {
		return mnfGestion == null ? 0 : mnfGestion;
	}

	public void setMnfGestion(Integer mnfGestion) {
		this.mnfGestion = mnfGestion;
	}

	public String getMnfNroreg() {
		return mnfNroreg == null ? "" : mnfNroreg;
	}

	public void setMnfNroreg(String mnfNroreg) {
		this.mnfNroreg = mnfNroreg;
	}

	public String getMnfPlaca() {
		return mnfPlaca == null ? "" : mnfPlaca;
	}

	public void setMnfPlaca(String mnfPlaca) {
		this.mnfPlaca = mnfPlaca;
	}

	public String getMnfTransNit() {
		return mnfTransNit == null ? "" : mnfTransNit;
	}

	public void setMnfTransNit(String mnfTransNit) {
		this.mnfTransNit = mnfTransNit;
	}

	public String getMnfTransNom() {
		return mnfTransNom == null ? "" : mnfTransNom;
	}

	public void setMnfTransNom(String mnfTransNom) {
		this.mnfTransNom = mnfTransNom;
	}

	public String getMnfEstado() {
		return mnfEstado;
	}

	public void setMnfEstado(String mnfEstado) {
		this.mnfEstado = mnfEstado;
	}

	public String getMnfEstadoImp() {
		return mnfEstadoImp;
	}

	public void setMnfEstadoImp(String mnfEstadoImp) {
		this.mnfEstadoImp = mnfEstadoImp;
	}

	public BigDecimal getMnfPeso() {
		return mnfPeso == null ? BigDecimal.ZERO : mnfPeso;
	}

	public void setMnfPeso(BigDecimal mnfPeso) {
		this.mnfPeso = mnfPeso;
	}

	public BigDecimal getMnfPesoDoc() {
		return mnfPesoDoc == null ? BigDecimal.ZERO : mnfPesoDoc;
	}

	public void setMnfPesoDoc(BigDecimal mnfPesoDoc) {
		this.mnfPesoDoc = mnfPesoDoc;
	}

	public String getMnfObtInfo() {
		return mnfObtInfo;
	}

	public void setMnfObtInfo(String mnfObtInfo) {
		this.mnfObtInfo = mnfObtInfo;
	}

	public TipoCarga getTicCod() {
		return ticCod;
	}

	public void setTicCod(TipoCarga ticCod) {
		this.ticCod = ticCod;
	}

	public String getDocProceso() {
		return docProceso;
	}

	public void setDocProceso(String docProceso) {
		this.docProceso = docProceso;
	}

	public String getMnfAnterior() {
		return mnfAnterior;
	}

	public void setMnfAnterior(String mnfAnterior) {
		this.mnfAnterior = mnfAnterior;
	}

	public TipoBajaMnf getTipoBajaMnf() {
		return tipoBajaMnf;
	}

	public void setTipoBajaMnf(TipoBajaMnf tipoBajaMnf) {
		this.tipoBajaMnf = tipoBajaMnf;
	}

	public TipoBajaMnf getTipoBajaMnf1() {
		return tipoBajaMnf1;
	}

	public void setTipoBajaMnf1(TipoBajaMnf tipoBajaMnf1) {
		this.tipoBajaMnf1 = tipoBajaMnf1;
	}

	public Recinto getMnfRecinto() {
		return mnfRecinto;
	}

	public void setMnfRecinto(Recinto mnfRecinto) {
		this.mnfRecinto = mnfRecinto;
	}

	public String getMnfPlacaSust() {
		return mnfPlacaSust == null ? "" : mnfPlacaSust;
	}

	public void setMnfPlacaSust(String mnfPlacaSust) {
		this.mnfPlacaSust = mnfPlacaSust;
	}

	public String getWsmCod() {
		return wsmCod;
	}

	public void setWsmCod(String wsmCod) {
		this.wsmCod = wsmCod;
	}

	public Set<ManifiestoDet> getManifiestoDetSet() {
		return manifiestoDetSet;
	}

	public void setManifiestoDetSet(Set<ManifiestoDet> manifiestoDetSet) {
		this.manifiestoDetSet = manifiestoDetSet;
	}

	public ManifiestoDet getManifiestoDet() {
		return manifiestoDet;
	}

	public void setManifiestoDet(ManifiestoDet manifiestoDet) {
		this.manifiestoDet = manifiestoDet;
	}

	public OperacionMnf getOperacionMnf() {
		return operacionMnf;
	}

	public void setOperacionMnf(OperacionMnf operacionMnf) {
		this.operacionMnf = operacionMnf;
	}

	public String getMnfObtInfoDesc() {
		return EnumUtil.ObtencionInfo.getValor(mnfObtInfo);
	}

	public String getMnfEstadoDesc() {
		return EnumUtil.Estado.getValor(mnfEstado);
	}

	public String getMnfEstadoImpDesc() {
		return EnumUtil.Estado.getValor(mnfEstadoImp);
	}

	public TipoIngresoMnf getTipoIngresoMnf() {
		return tipoIngresoMnf;
	}

	public void setTipoIngresoMnf(TipoIngresoMnf tipoIngresoMnf) {
		this.tipoIngresoMnf = tipoIngresoMnf;
	}

	public Cliente getCliCod() {
		return cliCod;
	}

	public void setCliCod(Cliente cliCod) {
		this.cliCod = cliCod;
	}

	public LocalDateTime getMnfFechareg() {
		return mnfFechareg;
	}

	public void setMnfFechareg(LocalDateTime mnfFechareg) {
		this.mnfFechareg = mnfFechareg;
	}

	public LocalDateTime getMnfFecha() {
		return mnfFecha;
	}

	public void setMnfFecha(LocalDateTime mnfFecha) {
		this.mnfFecha = mnfFecha;
	}

	public LocalDateTime getMnfFechaIniTrans() {
		return mnfFechaIniTrans;
	}

	public void setMnfFechaIniTrans(LocalDateTime mnfFechaIniTrans) {
		this.mnfFechaIniTrans = mnfFechaIniTrans;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (mnfCod != null ? mnfCod.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Manifiesto)) {
			return false;
		}
		Manifiesto other = (Manifiesto) object;
		if ((this.mnfCod == null && other.mnfCod != null)
				|| (this.mnfCod != null && !this.mnfCod.equals(other.mnfCod))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.Manifiesto[ mnfCodigo=" + mnfCod + " ]";
	}
}