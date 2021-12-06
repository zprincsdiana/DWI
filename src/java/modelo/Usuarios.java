/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByNomusu", query = "SELECT u FROM Usuarios u WHERE u.nomusu = :nomusu")
    , @NamedQuery(name = "Usuarios.findByPasusu", query = "SELECT u FROM Usuarios u WHERE u.pasusu = :pasusu")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nomusu")
    private String nomusu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "pasusu")
    private String pasusu;

    public Usuarios() {
    }

    public Usuarios(String nomusu) {
        this.nomusu = nomusu;
    }

    public Usuarios(String nomusu, String pasusu) {
        this.nomusu = nomusu;
        this.pasusu = pasusu;
    }

    public String getNomusu() {
        return nomusu;
    }

    public void setNomusu(String nomusu) {
        this.nomusu = nomusu;
    }

    public String getPasusu() {
        return pasusu;
    }

    public void setPasusu(String pasusu) {
        this.pasusu = pasusu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomusu != null ? nomusu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.nomusu == null && other.nomusu != null) || (this.nomusu != null && !this.nomusu.equals(other.nomusu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Usuarios[ nomusu=" + nomusu + " ]";
    }
    
}
