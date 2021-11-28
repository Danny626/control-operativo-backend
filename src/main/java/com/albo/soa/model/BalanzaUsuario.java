package com.albo.soa.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "BALANZA_USUARIO", catalog = "", schema = "SOA")
@NamedQueries({
    @NamedQuery(name = "BalanzaUsuario.findAll", query = "SELECT b FROM BalanzaUsuario b")})
public class BalanzaUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BalanzaUsuarioPK balanzaUsuarioPK;
    @Basic(optional = false)
    @Column(name = "BUS_ESTADO", nullable = false, length = 3)
    private String busEstado;
    @Basic(optional = false)
    @Column(name = "BUS_PASSWD", nullable = false, length = 8)
    private String busPasswd;
    @JsonIgnore
    @JoinColumn(name = "USR_COD", referencedColumnName = "USR_COD", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UsuarioSoa usuario;
    @JoinColumn(name = "BLZ_COD", referencedColumnName = "BLZ_COD", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Balanza balanza;

    public BalanzaUsuario() {
    }

    public BalanzaUsuario(BalanzaUsuarioPK balanzaUsuarioPK) {
        this.balanzaUsuarioPK = balanzaUsuarioPK;
    }

    public BalanzaUsuario(BalanzaUsuarioPK balanzaUsuarioPK, String busEstado, String busPasswd) {
        this.balanzaUsuarioPK = balanzaUsuarioPK;
        this.busEstado = busEstado;
        this.busPasswd = busPasswd;
    }

    public BalanzaUsuario(String usrCod, String blzCod) {
        this.balanzaUsuarioPK = new BalanzaUsuarioPK(usrCod, blzCod);
    }

    public BalanzaUsuarioPK getBalanzaUsuarioPK() {
        return balanzaUsuarioPK;
    }

    public void setBalanzaUsuarioPK(BalanzaUsuarioPK balanzaUsuarioPK) {
        this.balanzaUsuarioPK = balanzaUsuarioPK;
    }

    public String getBusEstado() {
        return busEstado;
    }

    public void setBusEstado(String busEstado) {
        this.busEstado = busEstado;
    }

    public String getBusPasswd() {
        return busPasswd;
    }

    public void setBusPasswd(String busPasswd) {
        this.busPasswd = busPasswd;
    }

    public UsuarioSoa getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioSoa usuario) {
        this.usuario = usuario;
    }

    public Balanza getBalanza() {
        return balanza;
    }

    public void setBalanza(Balanza balanza) {
        this.balanza = balanza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (balanzaUsuarioPK != null ? balanzaUsuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BalanzaUsuario)) {
            return false;
        }
        BalanzaUsuario other = (BalanzaUsuario) object;
        if ((this.balanzaUsuarioPK == null && other.balanzaUsuarioPK != null) || (this.balanzaUsuarioPK != null && !this.balanzaUsuarioPK.equals(other.balanzaUsuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.albo.soa.BalanzaUsuario[ balanzaUsuarioPK=" + balanzaUsuarioPK + " ]";
    }
    
}
