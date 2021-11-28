package com.albo.soa.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_BAJA_MNF", catalog = "", schema = "SOA")
public class TipoBajaMnf implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	protected TipoBajaMnfPK tipoBajaMnfPK;
	@Column(name = "TBM_NOMBRE", length = 50)
	private String tbmNombre;
	@Column(name = "TBM_ESTADO", length = 3)
	private String tbmEstado;
	@Column(name = "DOC_PROCESO", length = 3)
	private String docProceso;
	@JoinColumn(name = "REC_COD", referencedColumnName = "REC_COD", nullable = false, insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Recinto recinto;
	@OneToMany(mappedBy = "tipoBajaMnf")
	private Set<Manifiesto> manifiestoSet;
	@OneToMany(mappedBy = "tipoBajaMnf1")
	private Set<Manifiesto> manifiestoSet1;

	public TipoBajaMnf() {
	}

	public TipoBajaMnf(TipoBajaMnfPK tipoBajaMnfPK) {
		this.tipoBajaMnfPK = tipoBajaMnfPK;
	}

	public TipoBajaMnf(String recCod, String tbmCod) {
		this.tipoBajaMnfPK = new TipoBajaMnfPK(recCod, tbmCod);
	}

	public TipoBajaMnfPK getTipoBajaMnfPK() {
		return tipoBajaMnfPK;
	}

	public void setTipoBajaMnfPK(TipoBajaMnfPK tipoBajaMnfPK) {
		this.tipoBajaMnfPK = tipoBajaMnfPK;
	}

	public String getTbmNombre() {
		return tbmNombre;
	}

	public void setTbmNombre(String tbmNombre) {
		this.tbmNombre = tbmNombre;
	}

	public String getTbmEstado() {
		return tbmEstado;
	}

	public void setTbmEstado(String tbmEstado) {
		this.tbmEstado = tbmEstado;
	}

	public String getDocProceso() {
		return docProceso;
	}

	public void setDocProceso(String docProceso) {
		this.docProceso = docProceso;
	}

	public Recinto getRecinto() {
		return recinto;
	}

	public void setRecinto(Recinto recinto) {
		this.recinto = recinto;
	}

	public Set<Manifiesto> getManifiestoSet() {
		return manifiestoSet;
	}

	public void setManifiestoSet(Set<Manifiesto> manifiestoSet) {
		this.manifiestoSet = manifiestoSet;
	}

	public Set<Manifiesto> getManifiestoSet1() {
		return manifiestoSet1;
	}

	public void setManifiestoSet1(Set<Manifiesto> manifiestoSet1) {
		this.manifiestoSet1 = manifiestoSet1;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (tipoBajaMnfPK != null ? tipoBajaMnfPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof TipoBajaMnf)) {
			return false;
		}
		TipoBajaMnf other = (TipoBajaMnf) object;
		if ((this.tipoBajaMnfPK == null && other.tipoBajaMnfPK != null)
				|| (this.tipoBajaMnfPK != null && !this.tipoBajaMnfPK.equals(other.tipoBajaMnfPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.TipoBajaMnf[ tipoBajaMnfPK=" + tipoBajaMnfPK + " ]";
	}
}
