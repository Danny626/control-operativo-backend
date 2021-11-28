/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.albo.soa.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Karla Milenka Sanjines Teran
 */
@Embeddable
public class AlmacenPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@Column(name = "REC_COD", nullable = false, length = 5)
	private String recCod;
	@Basic(optional = false)
	@Column(name = "ALM_COD", nullable = false, length = 15)
	private String almCod;

	public AlmacenPK() {
	}

	public AlmacenPK(String recCod, String almCod) {
		this.recCod = recCod;
		this.almCod = almCod;
	}

	public String getRecCod() {
		return recCod;
	}

	public void setRecCod(String recCod) {
		this.recCod = recCod;
	}

	public String getAlmCod() {
		return almCod;
	}

	public void setAlmCod(String almCod) {
		this.almCod = almCod;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (recCod != null ? recCod.hashCode() : 0);
		hash += (almCod != null ? almCod.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof AlmacenPK)) {
			return false;
		}
		AlmacenPK other = (AlmacenPK) object;
		if ((this.recCod == null && other.recCod != null)
				|| (this.recCod != null && !this.recCod.equals(other.recCod))) {
			return false;
		}
		if ((this.almCod == null && other.almCod != null)
				|| (this.almCod != null && !this.almCod.equals(other.almCod))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.albo.soa.model.AlmacenPK[ recCod=" + recCod + ", almCod=" + almCod + " ]";
	}

}
