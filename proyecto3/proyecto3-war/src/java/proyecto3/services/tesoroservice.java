/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3.services;

import dao.TesoroFacade;
import entity.Tesoro;
import entity.Usuario;
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
@WebService(serviceName = "tesoroservice")
public class tesoroservice {
    @EJB
    private TesoroFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "createTesoro")
    @Oneway
    public void createTesoro(@WebParam(name = "entity") Tesoro entity) {
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "editTesoro")
    @Oneway
    public void editTesoro(@WebParam(name = "entity") Tesoro entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "removeTesoro")
    @Oneway
    public void removeTesoro(@WebParam(name = "entity") Tesoro entity) {
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "findTesoro")
    public Tesoro findTesoro(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAllTesoro")
    public List<Tesoro> findAllTesoro() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRangeTesoro")
    public List<Tesoro> findRangeTesoro(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "countTesoro")
    public int countTesoro() {
        return ejbRef.count();
    }

    @WebMethod(operationName = "getAllTesoros")
    public List<Tesoro> getAllTesoros() {
        return ejbRef.getAllTesoros();
    }

    @WebMethod(operationName = "getAllTesorosbyEstadoSolicitud")
    public List<Tesoro> getAllTesorosbyEstadoSolicitud(@WebParam(name = "solicitud") String solicitud) {
        return ejbRef.getAllTesorosbyEstadoSolicitud(solicitud);
    }

    @WebMethod(operationName = "getAllTesorosbyEstadoSolicitudandUser")
    public List<Tesoro> getAllTesorosbyEstadoSolicitudandUser(@WebParam(name = "solicitud") String solicitud, @WebParam(name = "idUser") Integer idUser) {
        return ejbRef.getAllTesorosbyEstadoSolicitudandUser(solicitud, idUser);
    }

    @WebMethod(operationName = "findTesoroByCodigoV")
    public Tesoro findTesoroByCodigoV(@WebParam(name = "codigo") String codigo) {
        return ejbRef.findTesoroByCodigoV(codigo);
    }

    @WebMethod(operationName = "getTesorosByLocalidad")
    public List<Tesoro> getTesorosByLocalidad(@WebParam(name = "localidad") String localidad) {
        return ejbRef.getTesorosByLocalidad(localidad);
    }

    @WebMethod(operationName = "getTesorosByBorradoLogico")
    public List<Tesoro> getTesorosByBorradoLogico() {
        return ejbRef.getTesorosByBorradoLogico();
    }

    @WebMethod(operationName = "getTesorosEncontrados")
    public List<Tesoro> getTesorosEncontrados(@WebParam(name = "u") Usuario u) {
        return ejbRef.getTesorosEncontrados(u);
    }
    
}
