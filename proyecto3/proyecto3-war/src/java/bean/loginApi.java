/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.RolFacade;
import dao.UsuarioFacade;
import entity.Usuario;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author IsmiKin
 */
@Named(value = "loginApi")
@SessionScoped
public class loginApi implements Serializable {
    @EJB
    private RolFacade rolFacade;
    @EJB
    private UsuarioFacade usuarioFacade;

    /**
     * Creates a new instance of loginApi
     */
 

    private Usuario usuarioLogueado;
    private Usuario usuarioNuevo;
    
    private String nickname;
    private String password;
    private String levelAccess;
    private HttpSession session;
    
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

    public Usuario getUsuarioNuevo() {
        return usuarioNuevo;
    }

    public void setUsuarioNuevo(Usuario usuarioNuevo) {
        this.usuarioNuevo = usuarioNuevo;
    }
    
    
    
    // METODOS PROPIOS
    
    public String newUserReady() throws IOException{
        
       usuarioNuevo = new Usuario();
       FacesContext.getCurrentInstance().getExternalContext().redirect("registrarse.jsf");
       return "registrarse";
    }
    
    public void loginUser() throws IOException{
     
 
        if(usuarioFacade.checkLogin(nickname, password))
            usuarioLogueado = usuarioFacade.getByNickname(nickname);
        else
            FacesContext.getCurrentInstance().getExternalContext().redirect("errorLogin.jsf");
            
        
         if(usuarioLogueado!=null){
             this.levelAccess =String.valueOf(usuarioLogueado.getRolidRol().getPrioridad()) ;
         }
         
         FacesContext context = FacesContext.getCurrentInstance();
        session = (HttpSession) context.getExternalContext().getSession(true);
         session.setAttribute("usuariologueado",usuarioLogueado);
        
         FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
    }
    
    // Añadir un nuevo Usuario registrandolo
    public void registerUser() throws IOException{
        usuarioNuevo.setRolidRol(rolFacade.getByPrioridad(2));
        usuarioNuevo.setEstado("activo");
        usuarioFacade.create(usuarioNuevo);
        usuarioNuevo = null;
        usuarioNuevo = new Usuario();
         FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
    }
    
    
    // HAY QUE USAR SESSION.. ESTO ES UN PARCHE PASAJERO (ISMIKIN)
    public void logoutUser() throws IOException{
        this.nickname =null;
        this.password=null;        
        this.usuarioLogueado=null;
        FacesContext.getCurrentInstance().getExternalContext().redirect("forwardToJSF.jsf");
    }
}
