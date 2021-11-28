package com.albo.soa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UBICACION", catalog = "", schema = "SOA")
public class Ubicacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	protected UbicacionPK ubicacionPK;
	@Column(name = "UBI_NOMBRE", length = 50)
	private String ubiNombre;
	@Column(name = "UBI_ESTADO", length = 3)
	private String ubiEstado;
	@JoinColumns({
			@JoinColumn(name = "REC_COD", referencedColumnName = "REC_COD", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "ALM_COD", referencedColumnName = "ALM_COD", nullable = false, insertable = false, updatable = false) })
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Almacen almacen;

	public Ubicacion() {
	}

	public Ubicacion(UbicacionPK ubicacionPK) {
		this.ubicacionPK = ubicacionPK;
	}

	public Ubicacion(String recCod, String almCod, String ubiCod) {
		this.ubicacionPK = new UbicacionPK(recCod, almCod, ubiCod);
	}

	public UbicacionPK getUbicacionPK() {
		return ubicacionPK;
	}

	public void setUbicacionPK(UbicacionPK ubicacionPK) {
		this.ubicacionPK = ubicacionPK;
	}

	public String getUbiNombre() {
		return ubiNombre;
	}

	public void setUbiNombre(String ubiNombre) {
		this.ubiNombre = ubiNombre;
	}

	public String getUbiEstado() {
		return ubiEstado;
	}

	public void setUbiEstado(String ubiEstado) {
		this.ubiEstado = ubiEstado;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ubicacionPK != null ? ubicacionPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Ubicacion)) {
			return false;
		}
		Ubicacion other = (Ubicacion) object;
		if ((this.ubicacionPK == null && other.ubicacionPK != null)
				|| (this.ubicacionPK != null && !this.ubicacionPK.equals(other.ubicacionPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.Ubicacion[ ubicacionPK=" + ubicacionPK + " ]";
	}

}
