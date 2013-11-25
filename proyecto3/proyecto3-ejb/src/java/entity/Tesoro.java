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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tesoro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tesoro.findAll", query = "SELECT t FROM Tesoro t"),
    @NamedQuery(name = "Tesoro.findByIdTesoro", query = "SELECT t FROM Tesoro t WHERE t.idTesoro = :idTesoro"),
    @NamedQuery(name = "Tesoro.findByCodigoTesoro", query = "SELECT t FROM Tesoro t WHERE t.codigoTesoro = :codigoTesoro"),
    @NamedQuery(name = "Tesoro.findByCodigoValidacion", query = "SELECT t FROM Tesoro t WHERE t.codigoValidacion = :codigoValidacion"),
    @NamedQuery(name = "Tesoro.findByCoordenadas", query = "SELECT t FROM Tesoro t WHERE t.coordenadas = :coordenadas"),
    @NamedQuery(name = "Tesoro.findByEstado", query = "SELECT t FROM Tesoro t WHERE t.estado = :estado"),
    @NamedQuery(name = "Tesoro.findByGoogleUrl", query = "SELECT t FROM Tesoro t WHERE t.googleUrl = :googleUrl"),
    @NamedQuery(name = "Tesoro.findByCodigoPostal", query = "SELECT t FROM Tesoro t WHERE t.codigoPostal = :codigoPostal"),
    @NamedQuery(name = "Tesoro.findByPais", query = "SELECT t FROM Tesoro t WHERE t.pais = :pais"),
    @NamedQuery(name = "Tesoro.findByLocalidad", query = "SELECT t FROM Tesoro t WHERE t.localidad = :localidad"),
    @NamedQuery(name = "Tesoro.findByProvincia", query = "SELECT t FROM Tesoro t WHERE t.provincia = :provincia"),
    @NamedQuery(name = "Tesoro.findByBorradoLogico", query = "SELECT t FROM Tesoro t WHERE t.borradoLogico = :borradoLogico")})
public class Tesoro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTesoro")
    private Integer idTesoro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CodigoTesoro")
    private String codigoTesoro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CodigoValidacion")
    private String codigoValidacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Coordenadas")
    private String coordenadas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Estado")
    private String estado;
    @Size(max = 120)
    @Column(name = "GoogleUrl")
    private String googleUrl;
    @Size(max = 45)
    @Column(name = "CodigoPostal")
    private String codigoPostal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Pais")
    private String pais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Localidad")
    private String localidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Provincia")
    private String provincia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BorradoLogico")
    private boolean borradoLogico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tesoroidTesoro")
    private Collection<Comentariotesoro> comentariotesoroCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tesoro")
    private Collection<Busquedatesoros> busquedatesorosCollection;
    @JoinColumn(name = "Usuario_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuarioidUsuario;
    @JoinColumn(name = "SolicitudTesoro_idSolicitudTesoro", referencedColumnName = "idSolicitudTesoro")
    @ManyToOne(optional = false)
    private Solicitudtesoro solicitudTesoroidSolicitudTesoro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tesoro")
    private Collection<Log> logCollection;

    public Tesoro() {
    }

    public Tesoro(Integer idTesoro) {
        this.idTesoro = idTesoro;
    }

    public Tesoro(Integer idTesoro, String codigoTesoro, String codigoValidacion, String coordenadas, String estado, String pais, String localidad, String provincia, boolean borradoLogico) {
        this.idTesoro = idTesoro;
        this.codigoTesoro = codigoTesoro;
        this.codigoValidacion = codigoValidacion;
        this.coordenadas = coordenadas;
        this.estado = estado;
        this.pais = pais;
        this.localidad = localidad;
        this.provincia = provincia;
        this.borradoLogico = borradoLogico;
    }

    public Integer getIdTesoro() {
        return idTesoro;
    }

    public void setIdTesoro(Integer idTesoro) {
        this.idTesoro = idTesoro;
    }

    public String getCodigoTesoro() {
        return codigoTesoro;
    }

    public void setCodigoTesoro(String codigoTesoro) {
        this.codigoTesoro = codigoTesoro;
    }

    public String getCodigoValidacion() {
        return codigoValidacion;
    }

    public void setCodigoValidacion(String codigoValidacion) {
        this.codigoValidacion = codigoValidacion;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getGoogleUrl() {
        return googleUrl;
    }

    public void setGoogleUrl(String googleUrl) {
        this.googleUrl = googleUrl;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public boolean getBorradoLogico() {
        return borradoLogico;
    }

    public void setBorradoLogico(boolean borradoLogico) {
        this.borradoLogico = borradoLogico;
    }

    @XmlTransient
    public Collection<Comentariotesoro> getComentariotesoroCollection() {
        return comentariotesoroCollection;
    }

    public void setComentariotesoroCollection(Collection<Comentariotesoro> comentariotesoroCollection) {
        this.comentariotesoroCollection = comentariotesoroCollection;
    }

    @XmlTransient
    public Collection<Busquedatesoros> getBusquedatesorosCollection() {
        return busquedatesorosCollection;
    }

    public void setBusquedatesorosCollection(Collection<Busquedatesoros> busquedatesorosCollection) {
        this.busquedatesorosCollection = busquedatesorosCollection;
    }

    public Usuario getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(Usuario usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    public Solicitudtesoro getSolicitudTesoroidSolicitudTesoro() {
        return solicitudTesoroidSolicitudTesoro;
    }

    public void setSolicitudTesoroidSolicitudTesoro(Solicitudtesoro solicitudTesoroidSolicitudTesoro) {
        this.solicitudTesoroidSolicitudTesoro = solicitudTesoroidSolicitudTesoro;
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
        hash += (idTesoro != null ? idTesoro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tesoro)) {
            return false;
        }
        Tesoro other = (Tesoro) object;
        if ((this.idTesoro == null && other.idTesoro != null) || (this.idTesoro != null && !this.idTesoro.equals(other.idTesoro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tesoro[ idTesoro=" + idTesoro + " ]";
    }
    
}
