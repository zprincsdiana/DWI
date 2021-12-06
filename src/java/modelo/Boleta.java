/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "boleta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boleta.findAll", query = "SELECT b FROM Boleta b")
    , @NamedQuery(name = "Boleta.findByIdboleta", query = "SELECT b FROM Boleta b WHERE b.idboleta = :idboleta")
    , @NamedQuery(name = "Boleta.findByFechaCompra", query = "SELECT b FROM Boleta b WHERE b.fechaCompra = :fechaCompra")
    , @NamedQuery(name = "Boleta.findByPagoTotal", query = "SELECT b FROM Boleta b WHERE b.pagoTotal = :pagoTotal")
    , @NamedQuery(name = "Boleta.findByEstado", query = "SELECT b FROM Boleta b WHERE b.estado = :estado")})
public class Boleta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idboleta")
    private Integer idboleta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_compra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pago_total")
    private float pagoTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @JoinColumn(name = "idcompra", referencedColumnName = "idcompra")
    @ManyToOne(optional = false)
    private Compra idcompra;
    @JoinColumn(name = "idtarjeta", referencedColumnName = "idtarjeta")
    @ManyToOne(optional = false)
    private Tarjeta idtarjeta;

    public Boleta() {
    }

    public Boleta(Integer idboleta) {
        this.idboleta = idboleta;
    }

    public Boleta(Integer idboleta, Date fechaCompra, float pagoTotal, int estado) {
        this.idboleta = idboleta;
        this.fechaCompra = fechaCompra;
        this.pagoTotal = pagoTotal;
        this.estado = estado;
    }

    public Integer getIdboleta() {
        return idboleta;
    }

    public void setIdboleta(Integer idboleta) {
        this.idboleta = idboleta;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public float getPagoTotal() {
        return pagoTotal;
    }

    public void setPagoTotal(float pagoTotal) {
        this.pagoTotal = pagoTotal;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Compra getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(Compra idcompra) {
        this.idcompra = idcompra;
    }

    public Tarjeta getIdtarjeta() {
        return idtarjeta;
    }

    public void setIdtarjeta(Tarjeta idtarjeta) {
        this.idtarjeta = idtarjeta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idboleta != null ? idboleta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boleta)) {
            return false;
        }
        Boleta other = (Boleta) object;
        if ((this.idboleta == null && other.idboleta != null) || (this.idboleta != null && !this.idboleta.equals(other.idboleta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Boleta[ idboleta=" + idboleta + " ]";
    }
    
}
