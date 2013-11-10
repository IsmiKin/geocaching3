/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author IsmiKin
 */
@Entity
@Table(name = "solicitudtesoro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitudtesoro.findAll", query = "SELECT s FROM Solicitudtesoro s"),
    @NamedQuery(name = "Solicitudtesoro.findByIdSolicitudTesoro", query = "SELECT s FROM Solicitudtesoro s WHERE s.idSolicitudTesoro = :idSolicitudTesoro"),
    @NamedQuery(name = "Solicitudtesoro.findByAprobado", query = "SELECT s FROM Solicitudtesoro s WHERE s.aprobado = :aprobado"),
    @NamedQuery(name = "Solicitudtesoro.findByComentario", query = "SELECT s FROM Solicitudtesoro s WHERE s.comentario = :comentario")})
public class Solicitudtesoro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSolicitudTesoro")
    private Integer idSolicitudTesoro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Aprobado")
    private String aprobado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "Comentario")
    private String comentario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudTesoroidSolicitudTesoro")
    private Collection<Tesoro> tesoroCollection;

    public Solicitudtesoro() {
    }

    public Solicitudtesoro(Integer idSolicitudTesoro) {
        this.idSolicitudTesoro = idSolicitudTesoro;
    }

    public Solicitudtesoro(Integer idSolicitudTesoro, String aprobado, String comentario) {
        this.idSolicitudTesoro = idSolicitudTesoro;
        this.aprobado = aprobado;
        this.comentario = comentario;
    }

    public Integer getIdSolicitudTesoro() {
        return idSolicitudTesoro;
    }

    public void setIdSolicitudTesoro(Integer idSolicitudTesoro) {
        this.idSolicitudTesoro = idSolicitudTesoro;
    }

    public String getAprobado() {
        return aprobado;
    }

    public void setAprobado(String aprobado) {
        this.aprobado = aprobado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @XmlTransient
    public Collection<Tesoro> getTesoroCollection() {
        return tesoroCollection;
    }

    public void setTesoroCollection(Collection<Tesoro> tesoroCollection) {
        this.tesoroCollection = tesoroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitudTesoro != null ? idSolicitudTesoro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitudtesoro)) {
            return false;
        }
        Solicitudtesoro other = (Solicitudtesoro) object;
        if ((this.idSolicitudTesoro == null && other.idSolicitudTesoro != null) || (this.idSolicitudTesoro != null && !this.idSolicitudTesoro.equals(other.idSolicitudTesoro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Solicitudtesoro[ idSolicitudTesoro=" + idSolicitudTesoro + " ]";
    }
    
}
