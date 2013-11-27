/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3.services;

import dao.TiposucesoFacade;
import entity.Tiposuceso;
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
@WebService(serviceName = "tiposucesoservice")
public class tiposucesoservice {
    @EJB
    private TiposucesoFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "createTipoSuceso")
    @Oneway
    public void createTipoSuceso(@WebParam(name = "entity") Tiposuceso entity) {
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "editTipoSuceso")
    @Oneway
    public void editTipoSuceso(@WebParam(name = "entity") Tiposuceso entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "removeTipoSuceso")
    @Oneway
    public void removeTipoSuceso(@WebParam(name = "entity") Tiposuceso entity) {
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "findTipoSuceso")
    public Tiposuceso findTipoSuceso(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAllTipoSuceso")
    public List<Tiposuceso> findAllTipoSuceso() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRangeTipoSuceso")
    public List<Tiposuceso> findRangeTipoSuceso(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "countTipoSuceso")
    public int countTipoSuceso() {
        return ejbRef.count();
    }

    @WebMethod(operationName = "getByNameTipoSuceso")
    public Tiposuceso getByNameTipoSuceso(@WebParam(name = "name") String name) {
        return ejbRef.getByNameTipoSuceso(name);
    }
    
}
