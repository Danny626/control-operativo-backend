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
@Table(name = "TIPO_INGRESO_MNF", catalog = "", schema = "SOA")
public class TipoIngresoMnf implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	protected TipoIngresoMnfPK tipoIngresoMnfPK;
	@Column(name = "TIM_NOMBRE", length = 50)
	private String timNombre;
	@Column(name = "TIM_ESTADO", length = 3)
	private String timEstado;
	@Column(name = "TIM_HORAS")
	private Integer timHoras;
	@OneToMany(mappedBy = "tipoIngresoMnf")
	private Set<Manifiesto> manifiestoSet;
	@JoinColumn(name = "REC_COD", referencedColumnName = "REC_COD", nullable = false, insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Recinto recinto;

	public TipoIngresoMnf() {
	}

	public TipoIngresoMnf(TipoIngresoMnfPK tipoIngresoMnfPK) {
		this.tipoIngresoMnfPK = tipoIngresoMnfPK;
	}

	public TipoIngresoMnf(String recCod, String timCod) {
		this.tipoIngresoMnfPK = new TipoIngresoMnfPK(recCod, timCod);
	}

	public TipoIngresoMnfPK getTipoIngresoMnfPK() {
		return tipoIngresoMnfPK;
	}

	public void setTipoIngresoMnfPK(TipoIngresoMnfPK tipoIngresoMnfPK) {
		this.tipoIngresoMnfPK = tipoIngresoMnfPK;
	}

	public String getTimNombre() {
		return timNombre;
	}

	public void setTimNombre(String timNombre) {
		this.timNombre = timNombre;
	}

	public String getTimEstado() {
		return timEstado;
	}

	public void setTimEstado(String timEstado) {
		this.timEstado = timEstado;
	}

	public Integer getTimHoras() {
		return timHoras;
	}

	public void setTimHoras(Integer timHoras) {
		this.timHoras = timHoras;
	}

	public Set<Manifiesto> getManifiestoSet() {
		return manifiestoSet;
	}

	public void setManifiestoSet(Set<Manifiesto> manifiestoSet) {
		this.manifiestoSet = manifiestoSet;
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
		hash += (tipoIngresoMnfPK != null ? tipoIngresoMnfPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof TipoIngresoMnf)) {
			return false;
		}
		TipoIngresoMnf other = (TipoIngresoMnf) object;
		if ((this.tipoIngresoMnfPK == null && other.tipoIngresoMnfPK != null)
				|| (this.tipoIngresoMnfPK != null && !this.tipoIngresoMnfPK.equals(other.tipoIngresoMnfPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.TipoIngresoMnf[ tipoIngresoMnfPK=" + tipoIngresoMnfPK + " ]";
	}

}
