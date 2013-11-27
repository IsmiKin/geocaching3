/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3.services;

import dao.LogFacade;
import entity.Log;
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
@WebService(serviceName = "logservice")
public class logservice {
    @EJB
    private LogFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "createLog")
    @Oneway
    public void createLog(@WebParam(name = "entity") Log entity) {
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "editLog")
    @Oneway
    public void editLog(@WebParam(name = "entity") Log entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "removeLog")
    @Oneway
    public void removeLog(@WebParam(name = "entity") Log entity) {
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "findLog")
    public Log findLog(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAllLog")
    public List<Log> Log() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRangeLog")
    public List<Log> findRangeLog(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "countLog")
    public int countLog() {
        return ejbRef.count();
    }

    @WebMethod(operationName = "getListLogBL")
    public List<Log> getListLogBL() {
        return ejbRef.getListLogBL();
    }

    @WebMethod(operationName = "getListLogByUserAndTesoro")
    public List<Log> getListLogByUserAndTesoro(@WebParam(name = "idUser") Integer idUser, @WebParam(name = "idTesoro") Integer idTesoro) {
        return ejbRef.getListLogByUserAndTesoro(idUser, idTesoro);
    }

    @WebMethod(operationName = "deleteLog")
    @Oneway
    public void deleteLog(@WebParam(name = "logid") Integer logid) {
        ejbRef.delete(logid);
    }

    @WebMethod(operationName = "getListLogByTesoro")
    public List<Log> getListLogByTesoro(@WebParam(name = "idTesoro") Integer idTesoro) {
        return ejbRef.getListLogByTesoro(idTesoro);
    }
    
}
