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
@Table(name = "tiposuceso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiposuceso.findAll", query = "SELECT t FROM Tiposuceso t"),
    @NamedQuery(name = "Tiposuceso.findByIdTipoSuceso", query = "SELECT t FROM Tiposuceso t WHERE t.idTipoSuceso = :idTipoSuceso"),
    @NamedQuery(name = "Tiposuceso.findByNombre", query = "SELECT t FROM Tiposuceso t WHERE t.nombre = :nombre")})
public class Tiposuceso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoSuceso")
    private Integer idTipoSuceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoSucesoidTipoSuceso")
    private Collection<Log> logCollection;

    public Tiposuceso() {
    }

    public Tiposuceso(Integer idTipoSuceso) {
        this.idTipoSuceso = idTipoSuceso;
    }

    public Tiposuceso(Integer idTipoSuceso, String nombre) {
        this.idTipoSuceso = idTipoSuceso;
        this.nombre = nombre;
    }

    public Integer getIdTipoSuceso() {
        return idTipoSuceso;
    }

    public void setIdTipoSuceso(Integer idTipoSuceso) {
        this.idTipoSuceso = idTipoSuceso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Log> getLogCollection() {
        return logCollection;
    }

    public void setLogCollection(Collection<Log> logCollection) {
        this.logCollection = logCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoSuceso != null ? idTipoSuceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiposuceso)) {
            return false;
        }
        Tiposuceso other = (Tiposuceso) object;
        if ((this.idTipoSuceso == null && other.idTipoSuceso != null) || (this.idTipoSuceso != null && !this.idTipoSuceso.equals(other.idTipoSuceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tiposuceso[ idTipoSuceso=" + idTipoSuceso + " ]";
    }
    
}
