/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Rol;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author IsmiKin
 */
@Stateless
public class RolFacade extends AbstractFacade<Rol> {
    @PersistenceContext(unitName = "proyecto3-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolFacade() {
        super(Rol.class);
    }
    
    public Rol getByPrioridad(int prioridad){
        //Rol salida = (Rol) em.createNamedQuery("Rol.findByPrioridad").setParameter("prioridad", prioridad).getSingleResult();
        Rol salida = (Rol) em.createQuery("SELECT r FROM Rol r WHERE r.prioridad = :prioridad").setParameter("prioridad", prioridad).getSingleResult();
        return salida;
    }
    
}
