/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3.services;

import dao.ComentariotesoroFacade;
import entity.Comentariotesoro;
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
@WebService(serviceName = "comentariotesoroservice")
public class comentariotesoroservice {
    @EJB
    private ComentariotesoroFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "createComentarioTesoro")
    @Oneway
    public void createComentarioTesoro(@WebParam(name = "entity") Comentariotesoro entity) {
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "editComentarioTesoro")
    @Oneway
    public void editComentarioTesoro(@WebParam(name = "entity") Comentariotesoro entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "removeComentarioTesoro")
    @Oneway
    public void removeComentarioTesoro(@WebParam(name = "entity") Comentariotesoro entity) {
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "findComentarioTesoro")
    public Comentariotesoro findComentarioTesoro(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAllComentarioTesoro")
    public List<Comentariotesoro> findAllComentarioTesoro() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRangeComentarioTesoro")
    public List<Comentariotesoro> findRangeComentarioTesoro(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "countComentarioTesoro")
    public int countComentarioTesoro() {
        return ejbRef.count();
    }
    
}
