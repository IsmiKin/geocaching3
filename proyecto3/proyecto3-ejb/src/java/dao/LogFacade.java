/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entity.Log;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author ASUS
 */
@Stateless
public class LogFacade extends AbstractFacade<Log> {
    @PersistenceContext(unitName = "proyecto3-ejbPU")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public LogFacade() {
        super(Log.class);
    }
    
    public List<Log> getListLogBL(){
        List<Log> listLog = null;

        try {
            Query q = em.createQuery("SELECT l FROM Log l WHERE l.borradoLogico = 0");
            listLog = q.getResultList();
        } catch (Exception ex) {}
        
        return listLog;       
    }
    
    public List<Log> getListLogByUserAndTesoro(Integer idUser, Integer idTesoro){
        List<Log> listLog = null;
        try {
            Query q = em.createQuery("SELECT l FROM Log l WHERE l.borradoLogico = 0 AND l.usuario = :usuario AND l.tesoro = :tesoro");
            q.setParameter("usuario", idUser);
            q.setParameter("tesoro", idTesoro);
            listLog = q.getResultList();
        } catch (Exception ex) {}
        return listLog;
    }
    
    public void delete(Integer logid){
        try {
            Query q = em.createQuery("UPDATE Log l SET l.borradoLogico = 1 WHERE l.logPK.idLog ="+logid);
            int updated = q.executeUpdate();
        } catch (Exception ex) {}
    }
    
    public List<Log> getListLogByTesoro(Integer idTesoro){
        List<Log> listLog = null;
        try {
            Query q = em.createQuery("SELECT l FROM Log l WHERE l.borradoLogico = 0 AND l.tesoro.idTesoro = :tesoro");
            q.setParameter("tesoro", idTesoro);
            listLog = q.getResultList();
        } catch (Exception ex) {}
        return listLog;
    }
}
