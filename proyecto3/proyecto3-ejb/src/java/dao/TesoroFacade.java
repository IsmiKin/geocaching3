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
import entity.Usuario;

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
    public Tesoro findTesoroByCodigoV(String codigo){
        Tesoro t = null;
        try {
            Query q = em.createQuery("SELECT t FROM Tesoro t WHERE t.borradoLogico=0 AND t.codigoValidacion LIKE :codigo");
            q.setParameter("codigo", codigo);
            t =(Tesoro) q.getSingleResult();
        } catch (Exception ex) {}
        return t;
    }
     public List<Tesoro> getTesorosByLocalidad(String localidad)
    {
        List<Tesoro> tesoros = null;
        try{
            Query q = em.createQuery("SELECT t FROM Tesoro t WHERE t.borradoLogico = 0 AND t.localidad like :localidad");
            tesoros = q.getResultList();
        }
        catch(Exception ex)
        {}
        
        return tesoros;
        //em.createNamedQuery("Tesoro.findByLocalidad").setParameter("localidad", localidad).getResultList();
        
        //Usuario salida = (Usuario) em.createNamedQuery("Usuario.findByNickname").setParameter("nickname", nickname).getSingleResult();
    }
    
    public List<Tesoro> getTesorosByBorradoLogico ()
    {
        List<Tesoro> lista =null;
        
        try
        {
            Query q = em.createQuery("SELECT t FROM Tesoro t WHERE t.borradoLogico = 0");
            lista = q.getResultList();
        }
        catch(Exception ex){}
                
        
        return lista;
    }
    
    public List<Tesoro> getTesorosEncontrados (Usuario u)
    {
        List<Tesoro> lista =null;
        
        try
        {
            Query q = em.createQuery("SELECT l.tesoro FROM Log l WHERE l.usuario.idUsuario = :user AND l.tipoSucesoidTipoSuceso.nombre LIKE 'Encontrado' ");
            q = q.setParameter("user", u.getIdUsuario());
            lista = q.getResultList();
        }
        catch(Exception ex){}
                
        
        return lista;
    }
    
    
}