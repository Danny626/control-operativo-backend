package com.albo.soa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "V_INVENTARIO_EGR", catalog = "", schema = "SOA")
@NamedQueries({
    @NamedQuery(name = "VInventarioEgr.findAll", query = "SELECT v FROM VInventarioEgr v")})
public class VInventarioEgr implements Serializable {
    
	private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID_COD")
    private BigInteger idCod;
    @Basic(optional = false)
    @Column(name = "INV_PARTE", nullable = false, length = 50)
    private String invParte;
    @Basic(optional = false)
    @Column(name = "INV_NRO", nullable = false, length = 15)
    private String invNro;
    @Basic(optional = false)
    @Column(name = "INV_RECINTO", nullable = false, length = 5)
    private String invRecinto;
    @Column(name = "INV_ADUANA", length = 5)
    private String invAduana;
    @Column(name = "INV_GESTION", length = 5)
    private String invGestion;
    @Column(name = "INV_NROREG", length = 20)
    private String invNroreg;
    @Basic(optional = false)
    @Column(name = "INV_FECHA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date invFecha;
    @Column(name = "INV_FECHA_ANPR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invFechaAnpr;
    @Basic(optional = false)
    @Column(name = "INV_FECHAING", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date invFechaing;
    @Basic(optional = false)
    @Column(name = "INV_ESTADO", nullable = false, length = 3)
    private String invEstado;
    @Column(name = "TRA_COD", length = 15)
    private String traCod;
    @Column(name = "TRA_DESCRIPCION", length = 50)
    private String traDescripcion;
    @Column(name = "TME_COD", length = 5)
    private String tmeCod;
    @Column(name = "TME_NOMBRE", length = 50)
    private String tmeNombre;
    @Column(name = "DTM_COD", length = 5)
    private String dtmCod;
    @Column(name = "DTM_NOMBRE", length = 50)
    private String dtmNombre;
    @Column(name = "DIN_COD")
    private Integer dinCod;
    @Column(name = "DIN_DESCRIPCION", length = 200)
    private String dinDescripcion;
    @Column(name = "INV_EMBARQUE", length = 20)
    private String invEmbarque;
    @Column(name = "INV_NITCONS", length = 20)
    private String invNitcons;
    @Column(name = "INV_NOMCONS", length = 100)
    private String invNomcons;
    @Column(name = "TBU_COD", length = 3)
    private String tbuCod;
    @Column(name = "TBU_NOMBRE", length = 50)
    private String tbuNombre;
    @Column(name = "DIN_BULTOS")
    private Long dinBultos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DIN_PESO", precision = 13, scale = 2)
    private BigDecimal dinPeso;
    @Column(name = "BULTO_S")
    private Long bultoS;
    @Column(name = "PESO_S")
    private BigDecimal pesoS;
    @Column(name = "LOCALIZACION", length = 50)
    private String localizacion;
    @Column(name = "ALM_COD", length = 15)
    private String almCod;
    @Column(name = "ALM_NOMBRE", length = 50)
    private String almNombre;
    @Column(name = "UBI_COD", length = 15)
    private String ubiCod;
    @Column(name = "UBI_NOMBRE", length = 50)
    private String ubiNombre;
    @Column(name = "INV_OBS", length = 300)
    private String invObs;
    @Column(name = "INV_PARTE_S", length = 50)
    private String invParteS;
    @Column(name = "DIN_COD_S")
    private Integer dinCodS;
    @Column(name = "SAL_COD", length = 15)
    private String salCod;
    @Column(name = "SAL_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date salFecha;
    @Column(name = "DOS_COD", length = 50)
    private String dosCod;
    @Column(name = "DSD_BULTO")
    private Long dsdBulto;
    @Column(name = "DSD_PESO", precision = 13, scale = 2)
    private BigDecimal dsdPeso;
    @Column(name = "PAT_COD", length = 10)
    private String patCod;
    @Column(name = "PK_ITEM_S")
    private Integer pkItemS;
    @Column(name = "BULTO_SALDO")
    private Long bultoSaldo;
    @Column(name = "PESO_SALDO", precision = 13, scale = 2)
    private BigDecimal pesoSaldo;
    @Basic(optional = false)
    @Column(name = "INV_BULTO_REC", nullable = false)
    private long invBultoRec;
    @Basic(optional = false)
    @Column(name = "INV_PESO_REC", nullable = false, precision = 13, scale = 2)
    private BigDecimal invPesoRec;
    @Basic(optional = false)
    @Column(name = "INV_BULTO_SALDO", nullable = false)
    private long invBultoSaldo;
    @Basic(optional = false)
    @Column(name = "INV_PESO_SALDO", nullable = false, precision = 13, scale = 2)
    private BigDecimal invPesoSaldo;
    @Column(name = "TIPO_SAL",columnDefinition= "char", length = 3)
    private String tipoSal;
    @Column(name = "TRD_COD", length = 15)
    private String trdCod;
    @Column(name = "USR_COD", length = 30)
    private String usrCod;
    @Column(name = "SAL_USR", length = 30)
    private String salUsr;    
    


    public VInventarioEgr() {
    }

    public BigInteger getIdCod() {
        return idCod;
    }

    public void setIdCod(BigInteger idCod) {
        this.idCod = idCod;
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

    public String getInvRecinto() {
        return invRecinto;
    }

    public void setInvRecinto(String invRecinto) {
        this.invRecinto = invRecinto;
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

    public Date getInvFecha() {
        return invFecha;
    }

    public void setInvFecha(Date invFecha) {
        this.invFecha = invFecha;
    }

    public Date getInvFechaAnpr() {
        return invFechaAnpr;
    }

    public void setInvFechaAnpr(Date invFechaAnpr) {
        this.invFechaAnpr = invFechaAnpr;
    }

    public Date getInvFechaing() {
        return invFechaing;
    }

    public void setInvFechaing(Date invFechaing) {
        this.invFechaing = invFechaing;
    }

    public String getInvEstado() {
        return invEstado;
    }

    public void setInvEstado(String invEstado) {
        this.invEstado = invEstado;
    }

    public String getTraCod() {
        return traCod;
    }

    public void setTraCod(String traCod) {
        this.traCod = traCod;
    }

    public String getTraDescripcion() {
        return traDescripcion;
    }

    public void setTraDescripcion(String traDescripcion) {
        this.traDescripcion = traDescripcion;
    }

    public String getTmeCod() {
        return tmeCod;
    }

    public void setTmeCod(String tmeCod) {
        this.tmeCod = tmeCod;
    }

    public String getTmeNombre() {
        return tmeNombre;
    }

    public void setTmeNombre(String tmeNombre) {
        this.tmeNombre = tmeNombre;
    }

    public String getDtmCod() {
        return dtmCod;
    }

    public void setDtmCod(String dtmCod) {
        this.dtmCod = dtmCod;
    }

    public String getDtmNombre() {
        return dtmNombre;
    }

    public void setDtmNombre(String dtmNombre) {
        this.dtmNombre = dtmNombre;
    }

    public Integer getDinCod() {
        return dinCod;
    }

    public void setDinCod(Integer dinCod) {
        this.dinCod = dinCod;
    }

    public String getDinDescripcion() {
        return dinDescripcion;
    }

    public void setDinDescripcion(String dinDescripcion) {
        this.dinDescripcion = dinDescripcion;
    }

    public String getInvEmbarque() {
        return invEmbarque;
    }

    public void setInvEmbarque(String invEmbarque) {
        this.invEmbarque = invEmbarque;
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

    public String getTbuCod() {
        return tbuCod;
    }

    public void setTbuCod(String tbuCod) {
        this.tbuCod = tbuCod;
    }

    public String getTbuNombre() {
        return tbuNombre;
    }

    public void setTbuNombre(String tbuNombre) {
        this.tbuNombre = tbuNombre;
    }

    public Long getDinBultos() {
        return dinBultos;
    }

    public void setDinBultos(Long dinBultos) {
        this.dinBultos = dinBultos;
    }

    public BigDecimal getDinPeso() {
        return dinPeso;
    }

    public void setDinPeso(BigDecimal dinPeso) {
        this.dinPeso = dinPeso;
    }

    public Long getBultoS() {
        return bultoS;
    }

    public void setBultoS(Long bultoS) {
        this.bultoS = bultoS;
    }

    public BigDecimal getPesoS() {
        return pesoS;
    }

    public void setPesoS(BigDecimal pesoS) {
        this.pesoS = pesoS;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getAlmCod() {
        return almCod;
    }

    public void setAlmCod(String almCod) {
        this.almCod = almCod;
    }

    public String getAlmNombre() {
        return almNombre==null?"":almNombre;
    }

    public void setAlmNombre(String almNombre) {
        this.almNombre = almNombre;
    }

    public String getUbiCod() {
        return ubiCod;
    }

    public void setUbiCod(String ubiCod) {
        this.ubiCod = ubiCod;
    }

    public String getUbiNombre() {
        return ubiNombre==null?"":ubiNombre;
    }

    public void setUbiNombre(String ubiNombre) {
        this.ubiNombre = ubiNombre;
    }

    public String getInvObs() {
        return invObs;
    }

    public void setInvObs(String invObs) {
        this.invObs = invObs;
    }

    public String getInvParteS() {
        return invParteS;
    }

    public void setInvParteS(String invParteS) {
        this.invParteS = invParteS;
    }

    public Integer getDinCodS() {
        return dinCodS==null?Integer.valueOf(0):dinCodS;
    }

    public void setDinCodS(Integer dinCodS) {
        this.dinCodS = dinCodS;
    }

    public String getSalCod() {
        return salCod==null?"":salCod;
    }

    public void setSalCod(String salCod) {
        this.salCod = salCod;
    }

    public Date getSalFecha() {
        return salFecha;
    }

    public void setSalFecha(Date salFecha) {
        this.salFecha = salFecha;
    }

    public String getDosCod() {
        return dosCod;
    }

    public void setDosCod(String dosCod) {
        this.dosCod = dosCod;
    }

    public Long getDsdBulto() {
        return dsdBulto==null?Long.valueOf(0):dsdBulto;
    }

    public void setDsdBulto(Long dsdBulto) {
        this.dsdBulto = dsdBulto;
    }

    public BigDecimal getDsdPeso() {
        return dsdPeso==null?BigDecimal.ZERO:dsdPeso;
    }

    public void setDsdPeso(BigDecimal dsdPeso) {
        this.dsdPeso = dsdPeso;
    }

    public String getPatCod() {
        return patCod;
    }

    public void setPatCod(String patCod) {
        this.patCod = patCod;
    }

    public Integer getPkItemS() {
        return pkItemS;
    }

    public void setPkItemS(Integer pkItemS) {
        this.pkItemS = pkItemS;
    }
    public Long getBultoSaldo() {
        return bultoSaldo;
    }

    public void setBultoSaldo(Long bultoSaldo) {
        this.bultoSaldo = bultoSaldo;
    }

    public BigDecimal getPesoSaldo() {
        return pesoSaldo;
    }

    public void setPesoSaldo(BigDecimal pesoSaldo) {
        this.pesoSaldo = pesoSaldo;
    }
    
     public long getInvBultoRec() {
        return invBultoRec;
    }

    public void setInvBultoRec(long invBultoRec) {
        this.invBultoRec = invBultoRec;
    }

    public BigDecimal getInvPesoRec() {
        return invPesoRec;
    }

    public void setInvPesoRec(BigDecimal invPesoRec) {
        this.invPesoRec = invPesoRec;
    }

    public long getInvBultoSaldo() {
        return invBultoSaldo;
    }

    public void setInvBultoSaldo(long invBultoSaldo) {
        this.invBultoSaldo = invBultoSaldo;
    }

    public BigDecimal getInvPesoSaldo() {
        return invPesoSaldo;
    }

    public void setInvPesoSaldo(BigDecimal invPesoSaldo) {
        this.invPesoSaldo = invPesoSaldo;
    }
    
    public String getTipoSal() {
        return tipoSal==null?"":tipoSal;
    }

    public void setTipoSal(String tipoSal) {
        this.tipoSal = tipoSal;
    }
    
      public String getTrdCod() {
        return trdCod;
    }

    public void setTrdCod(String trdCod) {
        this.trdCod = trdCod;
    }
    
    public String getSalUsr() {
        return salUsr;
    }

    public void setSalUsr(String salUsr) {
        this.salUsr = salUsr;
    }

    public String getUsrCod() {
        return usrCod;
    }

    public void setUsrCod(String usrCod) {
        this.usrCod = usrCod;
    }
}
