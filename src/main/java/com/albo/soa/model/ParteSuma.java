package com.albo.soa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "PARTE_SUMA", catalog = "", schema = "SOA")
public class ParteSuma implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PARTE_SUMA_SEQ")
    @SequenceGenerator(name = "PARTE_SUMA_SEQ", sequenceName = "PARTE_SUMA_SEQ", allocationSize = 1)
	@Column(name = "ID", nullable = false, unique = true)
	private Long id;

	@Column(name = "ID_SUMA", nullable = false)
	private String idSuma;

	@Column(name = "COR", nullable = false, unique = true)
	private String cor;

	@JsonSerialize(using = ToStringSerializer.class)
	@Column(name = "FEC_TRA")
	private LocalDateTime fecTra;

	@Column(name = "DST_OEA")
	private Boolean dstOea;

	@Column(name = "DST_COD_TIP_DOC")
	private String dstCodTipDoc;

	@Column(name = "DST_NUM_DOC")
	private String dstNumDoc;

	@Column(name = "DST_NOM_RAZ_SOC")
	private String dstNomRazSoc;

	@Column(name = "EST_ACT")
	private String estAct;

	@Column(name = "DATGEN_NUM_MAN")
	private String datgenNumMan;

	@Column(name = "DATGEN_NUM_DOC_EMB")
	private String datgenNumDocEmb;

	@JsonSerialize(using = ToStringSerializer.class)
	@Column(name = "DATGEN_FECING")
	private LocalDateTime datgenFecing;

	@Column(name = "DATGEN_ADUREC_COD")
	private String datgenAdurecCod;

	@Column(name = "INGUBIMER_MODREG_DES")
	private String ingubimerModregDes;

	@Column(name = "INGUBIMER_TIPCAR_DES")
	private String ingubimerTipcarDes;

	@Column(name = "INGUBIMER_ALM_COD")
	private String ingubimerAlmCod;

	@Column(name = "INGUBIMER_ALM_DES")
	private String ingubimerAlmDes;

	@Column(name = "INGUBIMER_SEC_COD")
	private String ingubimerSecCod;

	@Column(name = "INGUBIMER_SEC_DES")
	private String ingubimerSecDes;

	@Column(name = "INGUBIMER_EMIPRE_COD")
	private String ingubimerEmipreCod;

	@Column(name = "INGUBIMER_EMIPRE_DES")
	private String ingubimerEmipreDes;

	@Column(name = "INFTEC_DOCFIR_USRFIR")
	private String inftecDocfirUsrfir;

	@JsonSerialize(using = ToStringSerializer.class)
	@Column(name = "INFTEC_DOCFIR_FECFIR")
	private LocalDateTime inftecDocfirFecfir;

	@Column(name = "CONTOTSOBFAL_CANREC")
	private Integer contotsobfalCanrec;

	@Column(name = "CONTOTSOBFAL_PESREC")
	private BigDecimal contotsobfalPesrec;

	@JsonSerialize(using = ToStringSerializer.class)
	@Column(name = "FECHA_REGISTRO")
	private LocalDateTime fechaRegistro;

	@Column(name = "SYNC")
	private boolean sync;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdSuma() {
		return idSuma;
	}

	public void setIdSuma(String idSuma) {
		this.idSuma = idSuma;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public LocalDateTime getFecTra() {
		return fecTra;
	}

	public void setFecTra(LocalDateTime fecTra) {
		this.fecTra = fecTra;
	}

	public Boolean getDstOea() {
		return dstOea;
	}

	public void setDstOea(Boolean dstOea) {
		this.dstOea = dstOea;
	}

	public String getDstCodTipDoc() {
		return dstCodTipDoc;
	}

	public void setDstCodTipDoc(String dstCodTipDoc) {
		this.dstCodTipDoc = dstCodTipDoc;
	}

	public String getDstNumDoc() {
		return dstNumDoc;
	}

	public void setDstNumDoc(String dstNumDoc) {
		this.dstNumDoc = dstNumDoc;
	}

	public String getDstNomRazSoc() {
		return dstNomRazSoc;
	}

	public void setDstNomRazSoc(String dstNomRazSoc) {
		this.dstNomRazSoc = dstNomRazSoc;
	}

	public String getEstAct() {
		return estAct;
	}

	public void setEstAct(String estAct) {
		this.estAct = estAct;
	}

	public String getDatgenNumMan() {
		return datgenNumMan;
	}

	public void setDatgenNumMan(String datgenNumMan) {
		this.datgenNumMan = datgenNumMan;
	}

	public String getDatgenNumDocEmb() {
		return datgenNumDocEmb;
	}

	public void setDatgenNumDocEmb(String datgenNumDocEmb) {
		this.datgenNumDocEmb = datgenNumDocEmb;
	}

	public LocalDateTime getDatgenFecing() {
		return datgenFecing;
	}

	public void setDatgenFecing(LocalDateTime datgenFecing) {
		this.datgenFecing = datgenFecing;
	}

	public String getDatgenAdurecCod() {
		return datgenAdurecCod;
	}

	public void setDatgenAdurecCod(String datgenAdurecCod) {
		this.datgenAdurecCod = datgenAdurecCod;
	}

	public String getIngubimerModregDes() {
		return ingubimerModregDes;
	}

	public void setIngubimerModregDes(String ingubimerModregDes) {
		this.ingubimerModregDes = ingubimerModregDes;
	}

	public String getIngubimerTipcarDes() {
		return ingubimerTipcarDes;
	}

	public void setIngubimerTipcarDes(String ingubimerTipcarDes) {
		this.ingubimerTipcarDes = ingubimerTipcarDes;
	}

	public String getIngubimerAlmCod() {
		return ingubimerAlmCod;
	}

	public void setIngubimerAlmCod(String ingubimerAlmCod) {
		this.ingubimerAlmCod = ingubimerAlmCod;
	}

	public String getIngubimerAlmDes() {
		return ingubimerAlmDes;
	}

	public void setIngubimerAlmDes(String ingubimerAlmDes) {
		this.ingubimerAlmDes = ingubimerAlmDes;
	}

	public String getIngubimerSecCod() {
		return ingubimerSecCod;
	}

	public void setIngubimerSecCod(String ingubimerSecCod) {
		this.ingubimerSecCod = ingubimerSecCod;
	}

	public String getIngubimerSecDes() {
		return ingubimerSecDes;
	}

	public void setIngubimerSecDes(String ingubimerSecDes) {
		this.ingubimerSecDes = ingubimerSecDes;
	}

	public String getIngubimerEmipreCod() {
		return ingubimerEmipreCod;
	}

	public void setIngubimerEmipreCod(String ingubimerEmipreCod) {
		this.ingubimerEmipreCod = ingubimerEmipreCod;
	}

	public String getIngubimerEmipreDes() {
		return ingubimerEmipreDes;
	}

	public void setIngubimerEmipreDes(String ingubimerEmipreDes) {
		this.ingubimerEmipreDes = ingubimerEmipreDes;
	}

	public String getInftecDocfirUsrfir() {
		return inftecDocfirUsrfir;
	}

	public void setInftecDocfirUsrfir(String inftecDocfirUsrfir) {
		this.inftecDocfirUsrfir = inftecDocfirUsrfir;
	}

	public LocalDateTime getInftecDocfirFecfir() {
		return inftecDocfirFecfir;
	}

	public void setInftecDocfirFecfir(LocalDateTime inftecDocfirFecfir) {
		this.inftecDocfirFecfir = inftecDocfirFecfir;
	}

	public Integer getContotsobfalCanrec() {
		return contotsobfalCanrec;
	}

	public void setContotsobfalCanrec(Integer contotsobfalCanrec) {
		this.contotsobfalCanrec = contotsobfalCanrec;
	}

	public BigDecimal getContotsobfalPesrec() {
		return contotsobfalPesrec;
	}

	public void setContotsobfalPesrec(BigDecimal contotsobfalPesrec) {
		this.contotsobfalPesrec = contotsobfalPesrec;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public boolean isSync() {
		return sync;
	}

	public void setSync(boolean sync) {
		this.sync = sync;
	}

}
