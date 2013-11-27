/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3.services;

import dao.UsuarioFacade;
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
@WebService(serviceName = "usuarioservice")
public class usuarioservice {
    @EJB
    private UsuarioFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "createUsuario")
    @Oneway
    public void createUsuario(@WebParam(name = "entity") Usuario entity) {
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "editUsuario")
    @Oneway
    public void editUsuario(@WebParam(name = "entity") Usuario entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "removeUsuario")
    @Oneway
    public void removeUsuario(@WebParam(name = "entity") Usuario entity) {
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "findUsuario")
    public Usuario findUsuario(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAllUsuario")
    public List<Usuario> findAllUsuario() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRangeUsuario")
    public List<Usuario> findRangeUsuario(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "countUsuario")
    public int countUsuario() {
        return ejbRef.count();
    }

    @WebMethod(operationName = "findAllBLUsuario")
    public List<Usuario> findAllBLUsuario() {
        return ejbRef.findAllBL();
    }

    @WebMethod(operationName = "checkLoginUsuario")
    public boolean checkLoginUsuario(@WebParam(name = "nickname") String nickname, @WebParam(name = "pass") String pass) {
        return ejbRef.checkLogin(nickname, pass);
    }

    @WebMethod(operationName = "getIdByNicknameUsuario")
    public int getIdByNicknameUsuario(@WebParam(name = "nickname") String nickname) {
        return ejbRef.getIdByNickname(nickname);
    }

    @WebMethod(operationName = "getByNicknameUsuario")
    public Usuario getByNicknameUsuario(@WebParam(name = "nickname") String nickname) {
        return ejbRef.getByNickname(nickname);
    }
    
}
