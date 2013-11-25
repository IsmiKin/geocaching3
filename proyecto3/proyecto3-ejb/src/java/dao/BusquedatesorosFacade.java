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
import entity.Busquedatesoros;
import entity.Tesoro;
import entity.Usuario;

/**
 *
 * @author ASUS
 */
@Stateless
public class BusquedatesorosFacade extends AbstractFacade<Busquedatesoros> {
    @PersistenceContext(unitName = "proyecto3-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BusquedatesorosFacade() {
        super(Busquedatesoros.class);
    }
    
    public List<Tesoro> getBusquedasByUser(Integer idusuario)
    {
        List<Tesoro> listatesoros = null;
        try{
            Query q = em.createQuery("SELECT b.tesoro FROM Busquedatesoros b WHERE b.usuario.idUsuario = :iduser").setParameter("iduser", idusuario);
            listatesoros = q.getResultList();
        }
        catch(Exception e)
        {
            
        }
        return listatesoros;
    }
    
     public void deleteBusquedaByTesoroyUser(Integer idusuario, Integer idtesoro)
    {
        try{
            Query q = em.createQuery("DELETE FROM Busquedatesoros b WHERE b.usuario.idUsuario = :iduser AND b.tesoro.idTesoro = :idtes");
            q = q.setParameter("iduser", idusuario);
            q = q.setParameter("idtes", idtesoro);
            q.executeUpdate();
        }
        catch(Exception e)
        {
            
        }
    }
     public List<Busquedatesoros> findByUsuarioIdUsuario(Integer idUsuario){
        
        List<Busquedatesoros> u = null;
        
        try{
            Query q = em.createQuery("SELECT b FROM Busquedatesoros b WHERE b.busquedatesorosPK.usuarioidUsuario = :usuarioidUsuario AND b.borradoLogico = 0");
            q.setParameter("usuarioidUsuario", idUsuario);
            
            u = q.getResultList();
        }catch (Exception e){} 
        return u;
    }
    
    public List<Busquedatesoros> findByTesoroIdTesoro(Integer idTesoro){
        
        List<Busquedatesoros> t = null;
        
        try{
            Query q = em.createQuery("SELECT b FROM Busquedatesoros b WHERE b.busquedatesorosPK.tesoroidTesoro = :tesoroidTesoro AND b.borradoLogico = 0");
            q.setParameter("tesoroidTesoro", idTesoro);
            
            t = q.getResultList();
        }catch (Exception e){}
        
        return t;
    }
    
    public Busquedatesoros findByTesoroIdTesoroAndByUser(Integer idTesoro, Integer idUsuario){
        
        Busquedatesoros t = null;
        
        try{
            Query q = em.createQuery("SELECT b FROM Busquedatesoros b WHERE b.busquedatesorosPK.tesoroidTesoro = :tesoroidTesoro AND b.busquedatesorosPK.usuarioidUsuario = :usuarioidUsuario AND b.borradoLogico = 0");
            q.setParameter("tesoroidTesoro", idTesoro);
            q.setParameter("usuarioidUsuario", idUsuario);
            t = (Busquedatesoros) q.getSingleResult();
        }catch (Exception e){}
        
        return t;
    }
    public void borradoLogico(Busquedatesoros bt){
        bt.setBorradoLogico(true);
        super.edit(bt);
        
    }
    public void borradoLogico(Integer idTesoro,Integer idUsuario){
        try{
            Query q = em.createQuery("UPDATE Busquedatesoros b SET b.borradoLogico = 1 WHERE b.busquedatesorosPK.tesoroidTesoro = :tesoroidTesoro AND b.busquedatesorosPK.usuarioidUsuario = :usuarioidUsuario");
            q.setParameter("tesoroidTesoro", idTesoro);
            q.setParameter("usuarioidUsuario", idUsuario);
        }catch (Exception e){}
    }
    
}