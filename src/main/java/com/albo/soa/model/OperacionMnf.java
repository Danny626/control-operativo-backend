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
@Table(name = "OPERACION_MNF", catalog = "", schema = "SOA")
public class OperacionMnf implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	protected OperacionMnfPK operacionMnfPK;
	@Column(name = "OPM_NOMBRE", length = 50)
	private String opmNombre;
	@Column(name = "OPM_ESTADO", length = 3)
	private String opmEstado;
	@JoinColumn(name = "REC_COD", referencedColumnName = "REC_COD", nullable = false, insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Recinto recinto;
	@OneToMany(mappedBy = "operacionMnf")
	private Set<Manifiesto> manifiestoSet;

	public OperacionMnf() {
	}

	public OperacionMnf(OperacionMnfPK operacionMnfPK) {
		this.operacionMnfPK = operacionMnfPK;
	}

	public OperacionMnf(String recCod, String opmCod) {
		this.operacionMnfPK = new OperacionMnfPK(recCod, opmCod);
	}

	public OperacionMnfPK getOperacionMnfPK() {
		return operacionMnfPK;
	}

	public void setOperacionMnfPK(OperacionMnfPK operacionMnfPK) {
		this.operacionMnfPK = operacionMnfPK;
	}

	public String getOpmNombre() {
		return opmNombre;
	}

	public void setOpmNombre(String opmNombre) {
		this.opmNombre = opmNombre;
	}

	public String getOpmEstado() {
		return opmEstado;
	}

	public void setOpmEstado(String opmEstado) {
		this.opmEstado = opmEstado;
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

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (operacionMnfPK != null ? operacionMnfPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof OperacionMnf)) {
			return false;
		}
		OperacionMnf other = (OperacionMnf) object;
		if ((this.operacionMnfPK == null && other.operacionMnfPK != null)
				|| (this.operacionMnfPK != null && !this.operacionMnfPK.equals(other.operacionMnfPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.OperacionMnf[ operacionMnfPK=" + operacionMnfPK + " ]";
	}

}
