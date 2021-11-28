package com.albo.soa.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class BalanzaUsuarioPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    @Basic(optional = false)
    @Column(name = "USR_COD", nullable = false, length = 30)
    private String usrCod;
    @Basic(optional = false)
    @Column(name = "BLZ_COD", nullable = false, length = 20)
    private String blzCod;

    public BalanzaUsuarioPK() {
    }

    public BalanzaUsuarioPK(String usrCod, String blzCod) {
        this.usrCod = usrCod;
        this.blzCod = blzCod;
    }

    public String getUsrCod() {
        return usrCod;
    }

    public void setUsrCod(String usrCod) {
        this.usrCod = usrCod;
    }

    public String getBlzCod() {
        return blzCod;
    }

    public void setBlzCod(String blzCod) {
        this.blzCod = blzCod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usrCod != null ? usrCod.hashCode() : 0);
        hash += (blzCod != null ? blzCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BalanzaUsuarioPK)) {
            return false;
        }
        BalanzaUsuarioPK other = (BalanzaUsuarioPK) object;
        if ((this.usrCod == null && other.usrCod != null) || (this.usrCod != null && !this.usrCod.equals(other.usrCod))) {
            return false;
        }
        if ((this.blzCod == null && other.blzCod != null) || (this.blzCod != null && !this.blzCod.equals(other.blzCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.albo.soa.BalanzaUsuarioPK[ usrCod=" + usrCod + ", blzCod=" + blzCod + " ]";
    }
    
}
