/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import entity.Tesoro;

/**
 *
 * @author ASUS
 */
@Stateless
public class TesoroFacade extends AbstractFacade<Tesoro> {
    @PersistenceContext(unitName = "proyecto3-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TesoroFacade() {
        super(Tesoro.class);
    }
    
    public List<Tesoro> getAllTesoros()
    {
        List<Tesoro> listaTesoro = null;
        try{
            Query q = em.createQuery("SELECT t FROM Tesoro t WHERE t.borradoLogico = 0");
            listaTesoro = q.getResultList();
        }
        catch (Exception e){
        }
        return listaTesoro;
    }
    
    public List<Tesoro> getAllTesorosbyEstadoSolicitud(String solicitud)
    {
        List<Tesoro> listaTesoro = null;
        try{
            Query q = em.createQuery("SELECT t FROM Tesoro t WHERE t.borradoLogico = 0 AND t.solicitudTesoroidSolicitudTesoro.aprobado LIKE :estado").setParameter("estado", solicitud);
            listaTesoro = q.getResultList();
        }
        catch (Exception e){
        }
        return listaTesoro;
    }
    
    public List<Tesoro> getAllTesorosbyEstadoSolicitudandUser(String solicitud, Integer idUser)
    {
        List<Tesoro> listaTesoro = null;
        Integer a = idUser;
        try{
            Query q = em.createQuery("SELECT t FROM Tesoro t WHERE  t.solicitudTesoroidSolicitudTesoro.aprobado LIKE :estado AND t.usuarioidUsuario.idUsuario = :user");
            q = q.setParameter("estado", solicitud);
            q = q.setParameter("user", idUser);
            listaTesoro = q.getResultList();
        }
        catch (Exception e){
        }
        return listaTesoro;
    }
    
}
