/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import entity.Tiposuceso;

/**
 *
 * @author ASUS
 */
@Stateless
public class TiposucesoFacade extends AbstractFacade<Tiposuceso> {
    @PersistenceContext(unitName = "proyecto3-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public TiposucesoFacade() {
        super(Tiposuceso.class);
    }
    public Tiposuceso getByNameTipoSuceso(String name){
        Tiposuceso suceso = null;
        try {
            Query q = em.createQuery("SELECT t FROM Tiposuceso t WHERE t.nombre LIKE :nombre");
            q.setParameter("nombre", name);
            suceso  = (Tiposuceso) q.getSingleResult();
        } catch (Exception ex) {}
        return suceso;
    }
    
}
