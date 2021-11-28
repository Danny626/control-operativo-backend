package com.albo.soa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "MANIFIESTO_DET", catalog = "", schema = "SOA")
public class ManifiestoDet implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	protected ManifiestoDetPK manifiestoDetPK;
	@Basic(optional = false)
	@Column(name = "DMN_EMBARQUE", nullable = false, length = 20)
	private String dmnEmbarque;
	@Column(name = "DMN_BULTOS", nullable = false)
	private Long dmnBultos;
	@Column(name = "DMN_PESO", nullable = false, precision = 13, scale = 2)
	private BigDecimal dmnPeso;
	@Column(name = "DMN_NITCONS", length = 20)
	private String dmnNitcons;
	@Column(name = "DMN_NOMCONS", length = 100)
	private String dmnNomcons;
	@Column(name = "DMN_DESCRIPCION", length = 200)
	private String dmnDescripcion;
	/**
	 * Campo que indica si la mercancia es manifiestada SI/NO.
	 */
	@Basic(optional = false)
	@Column(name = "DMN_MNF", nullable = false, length = 2)
	private String dmnMnf;
	@Basic(optional = false)
	@Column(name = "DMN_SINC", nullable = false, length = 2)
	private String dmnSinc;
	@Column(name = "DMN_CONTENEDOR", length = 200)
	private String dmnContenedor;
	@Column(name = "DMN_PESO_ASG", precision = 13, scale = 2)
	private BigDecimal dmnPesoAsg;
	@Column(name = "DMN_DOC_CANCEL", length = 3)
	private String dmnDocCancel;
	@Column(name = "DMN_DOC_ESTADO", nullable = false, length = 2)
	private String dmnDocEstado;
	@JoinColumns({ @JoinColumn(name = "REC_COD", referencedColumnName = "REC_COD"),
			@JoinColumn(name = "ALM_COD", referencedColumnName = "ALM_COD"),
			@JoinColumn(name = "UBI_COD", referencedColumnName = "UBI_COD") })
	@ManyToOne(fetch = FetchType.EAGER)
	private Ubicacion ubicacion;
	@JoinColumns({ @JoinColumn(name = "REC_COD_TDE", referencedColumnName = "REC_COD"),
			@JoinColumn(name = "TDE_COD", referencedColumnName = "TDE_COD") })
	@ManyToOne
	private TipoDescarga tipoDescarga;
	@JoinColumn(name = "TBU_COD", referencedColumnName = "TBU_COD")
	@ManyToOne
	private TipoBulto tbuCod;
	@JoinColumn(name = "REG_COD", referencedColumnName = "REG_COD")
	@ManyToOne(fetch = FetchType.EAGER)
	private RegimenAduan regCod;
	@JoinColumn(name = "MNF_COD", referencedColumnName = "MNF_COD", nullable = false, insertable = false, updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Manifiesto manifiesto;
	@JoinColumns({ @JoinColumn(name = "REC_COD_DESCARGA", referencedColumnName = "REC_COD"),
			@JoinColumn(name = "ALM_DESCARGA", referencedColumnName = "ALM_COD") })
	@ManyToOne
	private Almacen almacen;
	@JoinColumn(name = "ADU_COD", referencedColumnName = "ADU_COD")
	@ManyToOne(fetch = FetchType.EAGER)
	private Aduana aduCod;
	@Column(name = "DMN_CONCB", length = 2)
	private String dmnConcb;
	@Basic(optional = false)
	@Column(name = "DMN_BULTOS_ASG", nullable = false)
	private long dmnBultosAsg;

	@Column(name = "DMN_FECHA_DESCARGA")
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime dmnFechaDescarga;

	@Column(name = "DMN_ESTIBA")
	private BigDecimal dmnEstiba;
	@Column(name = "USR_COD", length = 30)
	private String usrCod;
	@Column(name = "DMN_OBT_INFO", length = 3)
	private String dmnObtInfo;
	@Column(name = "DMN_OBS", length = 255)
	private String dmnObs;
	@Column(name = "DMN_CONSOL", length = 5)
	private String dmnConsol;
	@Column(name = "DMN_NRO_ITEM")
	private Integer dmnNroItem;
	@Column(name = "DMN_MARCA_BULTO", length = 50)
	private String dmnMarcaBulto;

	@Column(name = "DMN_FECHA")
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime dmnFecha;

	@Column(name = "DMN_FECHA_ACT")
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime dmnFechaAct;

	@Column(name = "DMN_DOC_ANEXOS", length = 255)
	private String dmnDocAnexos;
	@Column(name = "DMN_NUMPRECINTOS", nullable = false)
	private Long dmnNumprecintos;

	public ManifiestoDet() {
	}

	public ManifiestoDet(ManifiestoDetPK manifiestoDetPK) {
		this.manifiestoDetPK = manifiestoDetPK;
	}

	public ManifiestoDet(ManifiestoDetPK manifiestoDetPK, String dmnEmbarque, long dmnBultos, BigDecimal dmnPeso,
			String dmnMnf, String dmnSinc, String dmnDocEstado) {
		this.manifiestoDetPK = manifiestoDetPK;
		this.dmnEmbarque = dmnEmbarque;
		this.dmnBultos = dmnBultos;
		this.dmnPeso = dmnPeso;
		this.dmnMnf = dmnMnf;
		this.dmnSinc = dmnSinc;
		this.dmnDocEstado = dmnDocEstado;
	}

	public ManifiestoDet(String mnfCod, int dmnCod) {
		this.manifiestoDetPK = new ManifiestoDetPK(mnfCod, dmnCod);
	}

	public ManifiestoDetPK getManifiestoDetPK() {
		return manifiestoDetPK;
	}

	public void setManifiestoDetPK(ManifiestoDetPK manifiestoDetPK) {
		this.manifiestoDetPK = manifiestoDetPK;
	}

	public String getDmnEmbarque() {
		return dmnEmbarque;
	}

	public void setDmnEmbarque(String dmnEmbarque) {
		this.dmnEmbarque = dmnEmbarque;
	}

	public Long getDmnBultos() {
		if (dmnBultos == null) {
			dmnBultos = (0L);
		}
		return dmnBultos;
	}

	public void setDmnBultos(Long dmnBultos) {
		this.dmnBultos = dmnBultos;
	}

	public BigDecimal getDmnPeso() {
		if (dmnPeso == null) {
			dmnPeso = BigDecimal.ZERO;
		}

		return dmnPeso;
	}

	public void setDmnPeso(BigDecimal dmnPeso) {
		this.dmnPeso = dmnPeso;
	}

	public String getDmnNitcons() {
		return dmnNitcons;
	}

	public void setDmnNitcons(String dmnNitcons) {
		this.dmnNitcons = dmnNitcons;
	}

	public String getDmnNomcons() {
		return dmnNomcons;
	}

	public void setDmnNomcons(String dmnNomcons) {
		this.dmnNomcons = dmnNomcons;
	}

	public String getDmnDescripcion() {
		return dmnDescripcion;
	}

	public void setDmnDescripcion(String dmnDescripcion) {
		this.dmnDescripcion = dmnDescripcion;
	}

	public String getDmnMnf() {
		return dmnMnf;
	}

	public void setDmnMnf(String dmnMnf) {
		this.dmnMnf = dmnMnf;
	}

	public String getDmnSinc() {
		return dmnSinc;
	}

	public void setDmnSinc(String dmnSinc) {
		this.dmnSinc = dmnSinc;
	}

	public String getDmnContenedor() {
		return dmnContenedor;
	}

	public void setDmnContenedor(String dmnContenedor) {
		this.dmnContenedor = dmnContenedor;
	}

	public BigDecimal getDmnPesoAsg() {
		if (dmnPesoAsg == null) {
			dmnPesoAsg = BigDecimal.ZERO;
		}
		return dmnPesoAsg;
	}

	public void setDmnPesoAsg(BigDecimal dmnPesoAsg) {
		this.dmnPesoAsg = dmnPesoAsg;
	}

	public String getDmnDocCancel() {
		return dmnDocCancel;
	}

	public void setDmnDocCancel(String dmnDocCancel) {
		this.dmnDocCancel = dmnDocCancel;
	}

	public String getDmnDocEstado() {
		return dmnDocEstado;
	}

	public void setDmnDocEstado(String dmnDocEstado) {
		this.dmnDocEstado = dmnDocEstado;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public TipoDescarga getTipoDescarga() {
		return tipoDescarga;
	}

	public void setTipoDescarga(TipoDescarga tipoDescarga) {
		this.tipoDescarga = tipoDescarga;
	}

	public TipoBulto getTbuCod() {
		return tbuCod;
	}

	public void setTbuCod(TipoBulto tbuCod) {
		this.tbuCod = tbuCod;
	}

	public RegimenAduan getRegCod() {
		return regCod;
	}

	public void setRegCod(RegimenAduan regCod) {
		this.regCod = regCod;
	}

	public Manifiesto getManifiesto() {
		return manifiesto;
	}

	public void setManifiesto(Manifiesto manifiesto) {
		this.manifiesto = manifiesto;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	public Aduana getAduCod() {
		return aduCod;
	}

	public void setAduCod(Aduana aduCod) {
		this.aduCod = aduCod;
	}

	public String getDmnConcb() {
		return dmnConcb;
	}

	public void setDmnConcb(String dmnConcb) {
		this.dmnConcb = dmnConcb;
	}

	public long getDmnBultosAsg() {
		return dmnBultosAsg;
	}

	public void setDmnBultosAsg(long dmnBultosAsg) {
		this.dmnBultosAsg = dmnBultosAsg;
	}

	public boolean puedeEditarConteo() {
		return (dmnDocEstado.equals("SI")) ? false : true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (manifiestoDetPK != null ? manifiestoDetPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof ManifiestoDet)) {
			return false;
		}
		ManifiestoDet other = (ManifiestoDet) object;
		if ((this.manifiestoDetPK == null && other.manifiestoDetPK != null)
				|| (this.manifiestoDetPK != null && !this.manifiestoDetPK.equals(other.manifiestoDetPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.ManifiestoDet[ manifiestoDetPK=" + manifiestoDetPK + " ]";
	}

	public BigDecimal getDmnEstiba() {
		return dmnEstiba;
	}

	public void setDmnEstiba(BigDecimal dmnEstiba) {
		this.dmnEstiba = dmnEstiba;
	}

	public String getUsrCod() {
		return usrCod;
	}

	public void setUsrCod(String usrCod) {
		this.usrCod = usrCod;
	}

	public String getDmnObtInfo() {
		return dmnObtInfo;
	}

	public void setDmnObtInfo(String dmnObtInfo) {
		this.dmnObtInfo = dmnObtInfo;
	}

	public String getDmnObs() {
		return dmnObs == null ? "" : dmnObs.trim();

	}

	public void setDmnObs(String dmnObs) {
		this.dmnObs = dmnObs;
	}

	public String getDmnConsol() {
		return dmnConsol;
	}

	public void setDmnConsol(String dmnConsol) {
		this.dmnConsol = dmnConsol;
	}

	public Integer getDmnNroItem() {
		return dmnNroItem;
	}

	public void setDmnNroItem(Integer dmnNroItem) {
		this.dmnNroItem = dmnNroItem;
	}

	public String getDmnMarcaBulto() {
		return dmnMarcaBulto;
	}

	public void setDmnMarcaBulto(String dmnMarcaBulto) {
		this.dmnMarcaBulto = dmnMarcaBulto;
	}

	public String getDmnDocAnexos() {
		return dmnDocAnexos;
	}

	public void setDmnDocAnexos(String dmnDocAnexos) {
		this.dmnDocAnexos = dmnDocAnexos;
	}

	public Long getDmnNumprecintos() {
		return dmnNumprecintos;
	}

	public void setDmnNumprecintos(Long dmnNumprecintos) {
		this.dmnNumprecintos = dmnNumprecintos;
	}

	public LocalDateTime getDmnFechaDescarga() {
		return dmnFechaDescarga;
	}

	public void setDmnFechaDescarga(LocalDateTime dmnFechaDescarga) {
		this.dmnFechaDescarga = dmnFechaDescarga;
	}

	public LocalDateTime getDmnFecha() {
		return dmnFecha;
	}

	public void setDmnFecha(LocalDateTime dmnFecha) {
		this.dmnFecha = dmnFecha;
	}

	public LocalDateTime getDmnFechaAct() {
		return dmnFechaAct;
	}

	public void setDmnFechaAct(LocalDateTime dmnFechaAct) {
		this.dmnFechaAct = dmnFechaAct;
	}
}
