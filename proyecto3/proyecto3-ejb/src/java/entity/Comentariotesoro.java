/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author IsmiKin
 */
@Entity
@Table(name = "comentariotesoro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comentariotesoro.findAll", query = "SELECT c FROM Comentariotesoro c"),
    @NamedQuery(name = "Comentariotesoro.findByIdComentarioTesoro", query = "SELECT c FROM Comentariotesoro c WHERE c.idComentarioTesoro = :idComentarioTesoro"),
    @NamedQuery(name = "Comentariotesoro.findByTexto", query = "SELECT c FROM Comentariotesoro c WHERE c.texto = :texto"),
    @NamedQuery(name = "Comentariotesoro.findByFecha", query = "SELECT c FROM Comentariotesoro c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Comentariotesoro.findByBorradoLogico", query = "SELECT c FROM Comentariotesoro c WHERE c.borradoLogico = :borradoLogico")})
public class Comentariotesoro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idComentarioTesoro")
    private Integer idComentarioTesoro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "Texto")
    private String texto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BorradoLogico")
    private boolean borradoLogico;
    @JoinColumn(name = "Usuario_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuarioidUsuario;
    @JoinColumn(name = "Tesoro_idTesoro", referencedColumnName = "idTesoro")
    @ManyToOne(optional = false)
    private Tesoro tesoroidTesoro;

    public Comentariotesoro() {
    }

    public Comentariotesoro(Integer idComentarioTesoro) {
        this.idComentarioTesoro = idComentarioTesoro;
    }

    public Comentariotesoro(Integer idComentarioTesoro, String texto, Date fecha, boolean borradoLogico) {
        this.idComentarioTesoro = idComentarioTesoro;
        this.texto = texto;
        this.fecha = fecha;
        this.borradoLogico = borradoLogico;
    }

    public Integer getIdComentarioTesoro() {
        return idComentarioTesoro;
    }

    public void setIdComentarioTesoro(Integer idComentarioTesoro) {
        this.idComentarioTesoro = idComentarioTesoro;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean getBorradoLogico() {
        return borradoLogico;
    }

    public void setBorradoLogico(boolean borradoLogico) {
        this.borradoLogico = borradoLogico;
    }

    public Usuario getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(Usuario usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    public Tesoro getTesoroidTesoro() {
        return tesoroidTesoro;
    }

    public void setTesoroidTesoro(Tesoro tesoroidTesoro) {
        this.tesoroidTesoro = tesoroidTesoro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComentarioTesoro != null ? idComentarioTesoro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentariotesoro)) {
            return false;
        }
        Comentariotesoro other = (Comentariotesoro) object;
        if ((this.idComentarioTesoro == null && other.idComentarioTesoro != null) || (this.idComentarioTesoro != null && !this.idComentarioTesoro.equals(other.idComentarioTesoro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Comentariotesoro[ idComentarioTesoro=" + idComentarioTesoro + " ]";
    }
    
}
