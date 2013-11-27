/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3.services;

import dao.RolFacade;
import entity.Rol;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author ASUS
 */
@WebService(serviceName = "rolservice")
public class rolservice {
    @EJB
    private RolFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "createRol")
    @Oneway
    public void createRol(@WebParam(name = "entity") Rol entity) {
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "editRol")
    @Oneway
    public void editRol(@WebParam(name = "entity") Rol entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "removeRol")
    @Oneway
    public void removeRol(@WebParam(name = "entity") Rol entity) {
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "findRol")
    public Rol findRol(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAllRol")
    public List<Rol> findAllRol() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRangeRol")
    public List<Rol> findRangeRol(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "countRol")
    public int countRol() {
        return ejbRef.count();
    }

    @WebMethod(operationName = "getByPrioridadRol")
    public Rol getByPrioridadRol(@WebParam(name = "prioridad") int prioridad) {
        return ejbRef.getByPrioridad(prioridad);
    }
    
}
