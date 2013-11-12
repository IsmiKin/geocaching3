/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import dao.UsuarioFacade;
import entity.Usuario;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author IsmiKin
 */
@Named(value = "loginApi")
@ApplicationScoped
public class loginApi implements Serializable {
    @EJB
    private UsuarioFacade usuarioFacade;

    /**
     * Creates a new instance of loginApi
     */
 

    private Usuario usuarioLogueado;
    
    private String nickname="";
    private String password="";
    private String levelAccess="";
    
    /**
     * Creates a new instance of userManager
     */
     public loginApi() {
    }
     
    // GETTER AND SETTERS
    public UsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public void setUsuarioLogueado(Usuario usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevelAccess() {
        return levelAccess;
    }

    public void setLevelAccess(String levelAccess) {
        this.levelAccess = levelAccess;
    }
    
    
    
    // METODOS PROPIOS
    
    public void checkExistUsername() throws IOException{
        
       
    }
    
    public void loginUser() throws IOException{
     
        
        if(usuarioFacade.checkLogin(nickname, password))
            usuarioLogueado = usuarioFacade.getByNickname(nickname);
        else
            FacesContext.getCurrentInstance().getExternalContext().redirect("errorLogin.jsf");
            
        
         if(usuarioLogueado!=null){
             this.levelAccess =String.valueOf(usuarioLogueado.getRolidRol().getPrioridad()) ;
             /*if(usuarioLogueado.getRolidRol().getPrioridad().equals("Administrador")) this.levelAccess = "0";
             else if(usuarioLogueado.getRol().equals("Controlador")) this.levelAccess = "1";
             else if(usuarioLogueado.getRol().equals("JefeServicio")) this.levelAccess = "2";
             else if(usuarioLogueado.getRol().equals("Usuario")) this.levelAccess = "3";             */
         }
            
        
         FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
    }
    
    // HAY QUE USAR SESSION.. ESTO ES UN PARCHE PASAJERO (ISMIKIN)
    public void logoutUser() throws IOException{
        this.nickname ="";
        this.password="";        
        this.usuarioLogueado=null;
         FacesContext.getCurrentInstance().getExternalContext().redirect("../home/index2.jsf");
    }
}
