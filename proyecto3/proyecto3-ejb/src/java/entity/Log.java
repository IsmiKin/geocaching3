/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Log.findAll", query = "SELECT l FROM Log l"),
    @NamedQuery(name = "Log.findByIdLog", query = "SELECT l FROM Log l WHERE l.logPK.idLog = :idLog"),
    @NamedQuery(name = "Log.findByFecha", query = "SELECT l FROM Log l WHERE l.fecha = :fecha"),
    @NamedQuery(name = "Log.findByUsuarioidUsuario", query = "SELECT l FROM Log l WHERE l.logPK.usuarioidUsuario = :usuarioidUsuario"),
    @NamedQuery(name = "Log.findByTesoroidTesoro", query = "SELECT l FROM Log l WHERE l.logPK.tesoroidTesoro = :tesoroidTesoro"),
    @NamedQuery(name = "Log.findByComentario", query = "SELECT l FROM Log l WHERE l.comentario = :comentario"),
    @NamedQuery(name = "Log.findByBorradoLogico", query = "SELECT l FROM Log l WHERE l.borradoLogico = :borradoLogico")})
public class Log implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LogPK logPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 250)
    @Column(name = "Comentario")
    private String comentario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BorradoLogico")
    private boolean borradoLogico;
    @JoinColumn(name = "Usuario_idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "TipoSuceso_idTipoSuceso", referencedColumnName = "idTipoSuceso")
    @ManyToOne(optional = false)
    private Tiposuceso tipoSucesoidTipoSuceso;
    @JoinColumn(name = "Tesoro_idTesoro", referencedColumnName = "idTesoro", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tesoro tesoro;

    public Log() {
    }

    public Log(LogPK logPK) {
        this.logPK = logPK;
    }

    public Log(LogPK logPK, Date fecha, boolean borradoLogico) {
        this.logPK = logPK;
        this.fecha = fecha;
        this.borradoLogico = borradoLogico;
    }

    public Log(int idLog, int usuarioidUsuario, int tesoroidTesoro) {
        this.logPK = new LogPK(idLog, usuarioidUsuario, tesoroidTesoro);
    }

    public LogPK getLogPK() {
        return logPK;
    }

    public void setLogPK(LogPK logPK) {
        this.logPK = logPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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

    public Tiposuceso getTipoSucesoidTipoSuceso() {
        return tipoSucesoidTipoSuceso;
    }

    public void setTipoSucesoidTipoSuceso(Tiposuceso tipoSucesoidTipoSuceso) {
        this.tipoSucesoidTipoSuceso = tipoSucesoidTipoSuceso;
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
        hash += (logPK != null ? logPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Log)) {
            return false;
        }
        Log other = (Log) object;
        if ((this.logPK == null && other.logPK != null) || (this.logPK != null && !this.logPK.equals(other.logPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Log[ logPK=" + logPK + " ]";
    }
    
}
