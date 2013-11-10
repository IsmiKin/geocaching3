/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Solicitudtesoro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author IsmiKin
 */
@Stateless
public class SolicitudtesoroFacade extends AbstractFacade<Solicitudtesoro> {
    @PersistenceContext(unitName = "proyecto3-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudtesoroFacade() {
        super(Solicitudtesoro.class);
    }
    
}
