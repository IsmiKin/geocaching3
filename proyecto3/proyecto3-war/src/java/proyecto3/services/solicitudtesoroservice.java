/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3.services;

import dao.SolicitudtesoroFacade;
import entity.Solicitudtesoro;
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
@WebService(serviceName = "solicitudtesoroservice")
public class solicitudtesoroservice {
    @EJB
    private SolicitudtesoroFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "createSolicitudTesoro")
    @Oneway
    public void createSolicitudTesoro(@WebParam(name = "entity") Solicitudtesoro entity) {
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "editSolicitudTesoro")
    @Oneway
    public void editSolicitudTesoro(@WebParam(name = "entity") Solicitudtesoro entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "removeSolicitudTesoro")
    @Oneway
    public void removeSolicitudTesoro(@WebParam(name = "entity") Solicitudtesoro entity) {
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "findSolicitudTesoro")
    public Solicitudtesoro findSolicitudTesoro(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAllSolicitudTesoro")
    public List<Solicitudtesoro> findAllSolicitudTesoro() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRangeSolicitudTesoro")
    public List<Solicitudtesoro> findRangeSolicitudTesoro(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "countSolicitudTesoro")
    public int countSolicitudTesoro() {
        return ejbRef.count();
    }
    
}
