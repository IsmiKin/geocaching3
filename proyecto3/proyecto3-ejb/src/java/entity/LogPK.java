/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author IsmiKin
 */
@Embeddable
public class LogPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idLog")
    private int idLog;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Usuario_idUsuario")
    private int usuarioidUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Tesoro_idTesoro")
    private int tesoroidTesoro;

    public LogPK() {
    }

    public LogPK(int idLog, int usuarioidUsuario, int tesoroidTesoro) {
        this.idLog = idLog;
        this.usuarioidUsuario = usuarioidUsuario;
        this.tesoroidTesoro = tesoroidTesoro;
    }

    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    public int getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(int usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    public int getTesoroidTesoro() {
        return tesoroidTesoro;
    }

    public void setTesoroidTesoro(int tesoroidTesoro) {
        this.tesoroidTesoro = tesoroidTesoro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idLog;
        hash += (int) usuarioidUsuario;
        hash += (int) tesoroidTesoro;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogPK)) {
            return false;
        }
        LogPK other = (LogPK) object;
        if (this.idLog != other.idLog) {
            return false;
        }
        if (this.usuarioidUsuario != other.usuarioidUsuario) {
            return false;
        }
        if (this.tesoroidTesoro != other.tesoroidTesoro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LogPK[ idLog=" + idLog + ", usuarioidUsuario=" + usuarioidUsuario + ", tesoroidTesoro=" + tesoroidTesoro + " ]";
    }
    
}
