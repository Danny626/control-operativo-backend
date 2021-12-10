package com.albo.soa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "parte_suma", catalog = "", schema = "SOA")
public class ParteSuma implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Long id;

	@Column(name = "id_suma", nullable = false, unique = true)
	private String idSuma;

	@Column(name = "cor", nullable = false)
	private String cor;

	@JsonSerialize(using = ToStringSerializer.class)
	@Column(name = "fec_tra")
	private LocalDateTime fecTra;

	@Column(name = "dst_oea")
	private Boolean dstOea;

	@Column(name = "dst_cod_tip_doc")
	private String dstCodTipDoc;

	@Column(name = "dst_num_doc")
	private String dstNumDoc;

	@Column(name = "dst_nom_raz_soc")
	private String dstNomRazSoc;

	@Column(name = "est_act")
	private String estAct;

	@Column(name = "datgen_num_man")
	private String datgenNumMan;

	@Column(name = "datgen_num_doc_emb")
	private String datgenNumDocEmb;

	@JsonSerialize(using = ToStringSerializer.class)
	@Column(name = "datgen_fecing")
	private LocalDateTime datgenFecing;

	@Column(name = "datgen_adurec_cod")
	private Integer datgenAdurecCod;

	@Column(name = "ingubimer_modreg_des")
	private String ingubimerModregDes;

	@Column(name = "ingubimer_tipcar_des")
	private String ingubimerTipcarDes;

	@Column(name = "ingubimer_alm_cod")
	private String ingubimerAlmCod;

	@Column(name = "ingubimer_alm_des")
	private String ingubimerAlmDes;

	@Column(name = "ingubimer_sec_cod")
	private String ingubimerSecCod;

	@Column(name = "ingubimer_sec_des")
	private String ingubimerSecDes;

	@Column(name = "ingubimer_emipre_cod")
	private String ingubimerEmipreCod;

	@Column(name = "ingubimer_emipre_des")
	private String ingubimerEmipreDes;

	@Column(name = "inftec_docfir_usrfir")
	private String inftecDocfirUsrfir;

	@JsonSerialize(using = ToStringSerializer.class)
	@Column(name = "inftec_docfir_fecfir")
	private LocalDateTime inftecDocfirFecfir;

	@Column(name = "contotsobfal_canrec")
	private Integer contotsobfalCanrec;

	@Column(name = "contotsobfal_pesrec")
	private BigDecimal contotsobfalPesrec;

	@JsonSerialize(using = ToStringSerializer.class)
	@Column(name = "fecha_registro")
	private LocalDateTime fechaRegistro;

	@Column(name = "sync")
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

	public Integer getDatgenAdurecCod() {
		return datgenAdurecCod;
	}

	public void setDatgenAdurecCod(Integer datgenAdurecCod) {
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
