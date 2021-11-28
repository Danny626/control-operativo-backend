package com.albo.soa.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "BALANZA", catalog = "", schema = "SOA")
@NamedQueries({
    @NamedQuery(name = "Balanza.findAll", query = "SELECT b FROM Balanza b")})
public class Balanza implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "BLZ_COD", length = 20)
    private String blzCod;
    @Column(name = "BLZ_DESCRIPCION", length = 30)
    private String blzDescripcion;
    @Basic(optional = false)
    @Column(name = "BLZ_IP", nullable = false, length = 16)
    private String blzIp;
    @Basic(optional = false)
    @Column(name = "BLZ_ESTADO", nullable = false, length = 3)
    private String blzEstado;
    @Column(name = "BLZ_FILE", length = 100)
    private String blzFile;
    @Column(name = "BLZ_PUERTO", length = 5)
    private String blzPuerto;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "balanza")
    private Set<BalanzaUsuario> balanzaUsuarioSet;
    @Column(name = "BLZ_CODCONTROL", length = 2)
    private String blzCodcontrol;
    @Column(name = "BLZ_NUMERACION", length = 2)
    private String blzNumeracion;
    
    public Balanza() {
    }

    public Balanza(String blzCod) {
        this.blzCod = blzCod;
    }

    public Balanza(String blzCod, String blzIp, String blzEstado) {
        this.blzCod = blzCod;
        this.blzIp = blzIp;
        this.blzEstado = blzEstado;
    }

    public String getBlzCod() {
        return blzCod;
    }

    public void setBlzCod(String blzCod) {
        this.blzCod = blzCod;
    }

    public String getBlzDescripcion() {
        return blzDescripcion;
    }

    public void setBlzDescripcion(String blzDescripcion) {
        this.blzDescripcion = blzDescripcion;
    }

    public String getBlzIp() {
        return blzIp;
    }

    public void setBlzIp(String blzIp) {
        this.blzIp = blzIp;
    }

    public String getBlzEstado() {
        return blzEstado;
    }

    public void setBlzEstado(String blzEstado) {
        this.blzEstado = blzEstado;
    }

    public String getBlzFile() {
        return blzFile;
    }

    public void setBlzFile(String blzFile) {
        this.blzFile = blzFile;
    }

    public String getBlzPuerto() {
        return blzPuerto;
    }

    public void setBlzPuerto(String blzPuerto) {
        this.blzPuerto = blzPuerto;
    }

    public Set<BalanzaUsuario> getBalanzaUsuarioSet() {
        return balanzaUsuarioSet;
    }

    public void setBalanzaUsuarioSet(Set<BalanzaUsuario> balanzaUsuarioSet) {
        this.balanzaUsuarioSet = balanzaUsuarioSet;
    }

    public String getBlzCodcontrol() {
        return blzCodcontrol;
    }

    public void setBlzCodcontrol(String blzCodcontrol) {
        this.blzCodcontrol = blzCodcontrol;
    }

    public String getBlzNumeracion() {
        return blzNumeracion;
    }

    public void setBlzNumeracion(String blzNumeracion) {
        this.blzNumeracion = blzNumeracion;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (blzCod != null ? blzCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Balanza)) {
            return false;
        }
        Balanza other = (Balanza) object;
        if ((this.blzCod == null && other.blzCod != null) || (this.blzCod != null && !this.blzCod.equals(other.blzCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.albo.soa.Balanza[ blzCod=" + blzCod + " ]";
    }

    
    
}
