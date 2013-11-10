/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author IsmiKin
 */
@Entity
@Table(name = "busquedatesoros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Busquedatesoros.findAll", query = "SELECT b FROM Busquedatesoros b"),
    @NamedQuery(name = "Busquedatesoros.findByUsuarioidUsuario", query = "SELECT b FROM Busquedatesoros b WHERE b.busquedatesorosPK.usuarioidUsuario = :usuarioidUsuario"),
    @NamedQuery(name = "Busquedatesoros.findByTesoroidTesoro", query = "SELECT b FROM Busquedatesoros b WHERE b.busquedatesorosPK.tesoroidTesoro = :tesoroidTesoro"),
    @NamedQuery(name = "Busquedatesoros.findByBorradoLogico", query = "SELECT b FROM Busquedatesoros b WHERE b.borradoLogico = :borradoLogico")})
public class Busquedatesoros implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BusquedatesorosPK busquedatesorosPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BorradoLogico")
    private boolean borradoLogico;
    @JoinColumn(name = "Usuario_idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "Tesoro_idTesoro", referencedColumnName = "idTesoro", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tesoro tesoro;

    public Busquedatesoros() {
    }

    public Busquedatesoros(BusquedatesorosPK busquedatesorosPK) {
        this.busquedatesorosPK = busquedatesorosPK;
    }

    public Busquedatesoros(BusquedatesorosPK busquedatesorosPK, boolean borradoLogico) {
        this.busquedatesorosPK = busquedatesorosPK;
        this.borradoLogico = borradoLogico;
    }

    public Busquedatesoros(int usuarioidUsuario, int tesoroidTesoro) {
        this.busquedatesorosPK = new BusquedatesorosPK(usuarioidUsuario, tesoroidTesoro);
    }

    public BusquedatesorosPK getBusquedatesorosPK() {
        return busquedatesorosPK;
    }

    public void setBusquedatesorosPK(BusquedatesorosPK busquedatesorosPK) {
        this.busquedatesorosPK = busquedatesorosPK;
    }

    public boolean getBorradoLogico() {
        return borradoLogico;
    }

    public void setBorradoLogico(boolean borradoLogico) {
        this.borradoLogico = borradoLogico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tesoro getTesoro() {
        return tesoro;
    }

    public void setTesoro(Tesoro tesoro) {
        this.tesoro = tesoro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (busquedatesorosPK != null ? busquedatesorosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Busquedatesoros)) {
            return false;
        }
        Busquedatesoros other = (Busquedatesoros) object;
        if ((this.busquedatesorosPK == null && other.busquedatesorosPK != null) || (this.busquedatesorosPK != null && !this.busquedatesorosPK.equals(other.busquedatesorosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Busquedatesoros[ busquedatesorosPK=" + busquedatesorosPK + " ]";
    }
    
}
