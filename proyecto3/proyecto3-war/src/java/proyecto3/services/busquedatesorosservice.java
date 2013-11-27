/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3.services;

import dao.BusquedatesorosFacade;
import entity.Busquedatesoros;
import entity.Tesoro;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;

/**
 *
 * @author ASUS
 */
@WebService(serviceName = "busquedatesorosservice")
public class busquedatesorosservice {
    @EJB
    private BusquedatesorosFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "createBusquedaTesoro")
    @Oneway
    public void createBusquedaTesoro(@WebParam(name = "entity") Busquedatesoros entity) {
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "editBusquedaTesoro")
    @Oneway
    public void editBusquedaTesoro(@WebParam(name = "entity") Busquedatesoros entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "removeBusquedaTesoro")
    @Oneway
    public void removeBusquedaTesoro(@WebParam(name = "entity") Busquedatesoros entity) {
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "findBusquedaTesoro")
    public Busquedatesoros findBusquedaTesoro(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAllBusquedaTesoro")
    public List<Busquedatesoros> findAllBusquedaTesoro() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRangeBusquedaTesoro")
    public List<Busquedatesoros> findRangeBusquedaTesoro(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "countBusquedaTesoro")
    public int countBusquedaTesoro() {
        return ejbRef.count();
    }

    @WebMethod(operationName = "getBusquedasByUser")
    public List<Tesoro> getBusquedasByUser(@WebParam(name = "idusuario") Integer idusuario) {
        return ejbRef.getBusquedasByUser(idusuario);
    }

    @WebMethod(operationName = "deleteBusquedaByTesoroyUser")
    @Oneway
    public void deleteBusquedaByTesoroyUser(@WebParam(name = "idusuario") Integer idusuario, @WebParam(name = "idtesoro") Integer idtesoro) {
        ejbRef.deleteBusquedaByTesoroyUser(idusuario, idtesoro);
    }

    @WebMethod(operationName = "findByUsuarioIdUsuarioBusquedaTesoro")
    public List<Busquedatesoros> findByUsuarioIdUsuario(@WebParam(name = "idUsuario") Integer idUsuario) {
        return ejbRef.findByUsuarioIdUsuario(idUsuario);
    }

    @WebMethod(operationName = "findByTesoroIdTesoroBusquedaTesoro")
    public List<Busquedatesoros> findByTesoroIdTesoro(@WebParam(name = "idTesoro") Integer idTesoro) {
        return ejbRef.findByTesoroIdTesoro(idTesoro);
    }

    @WebMethod(operationName = "findByTesoroIdTesoroAndByUserBusquedaTesoro")
    public Busquedatesoros findByTesoroIdTesoroAndByUser(@WebParam(name = "idTesoro") Integer idTesoro, @WebParam(name = "idUsuario") Integer idUsuario) {
        return ejbRef.findByTesoroIdTesoroAndByUser(idTesoro, idUsuario);
    }

    @WebMethod(operationName = "borradoLogicoBusquedaTesoro")
    @Oneway
    public void borradoLogicoBusquedaTesoro(@WebParam(name = "bt") Busquedatesoros bt) {
        ejbRef.borradoLogico(bt);
    }

    @WebMethod(operationName = "borradoLogico_1")
    @RequestWrapper(className = "borradoLogico_1")
    @Oneway
    public void borradoLogico(@WebParam(name = "idTesoro") Integer idTesoro, @WebParam(name = "idUsuario") Integer idUsuario) {
        ejbRef.borradoLogico(idTesoro, idUsuario);
    }
    
}
