/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import entity.Rol;
import entity.Usuario;
import dao.RolFacade;
import dao.TesoroFacade;
import dao.UsuarioFacade;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Pablo
 */
@Named(value = "userManagedBean")
@RequestScoped
public class UserManagedBean {
    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB
    private RolFacade rolFacade;
    @EJB
    private TesoroFacade tesoroFacade;
   
   
  
   
    
    private Usuario seleccionado;
    private Usuario editable;
    
    private List<Usuario> todosU;
    private List<Rol> todosR;
    
    private String FK_Rol;
    private String v_tesoro="";
    private String comentario;
    /**
     * Creates a new instance of usuariosBean
     */
    @PostConstruct
    public void init(){
        
        todosU=usuarioFacade.findAllBL();
        todosR=rolFacade.findAll();
        seleccionado = new Usuario();
        editable = new Usuario();
    }

    
    

    public void añadirUsuario() throws IOException{
        
        if (FK_Rol!=""){
            seleccionado.setRolidRol(rolFacade.find(Integer.parseInt(FK_Rol)));
        }
        
        seleccionado.setEstado("Activo"); // or defecto
        seleccionado.setBorradoLogico(false); // por defecto
        
        usuarioFacade.create(seleccionado);
        //seleccionado.setRolidRol(rol);
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("listUser.jsf");
    }
    
    public void eliminarUsuario(Usuario aEliminar){
        
        usuarioFacade.remove(aEliminar);
        todosU.remove(aEliminar);
        
    }
    
    public String goToEditarUsuario(){
        return "editUser.jsf";
    }
    
    public void editar() throws IOException{
        
        
        editable.setRolidRol(rolFacade.find(Integer.parseInt(FK_Rol)));
     
        usuarioFacade.edit(editable);
        todosU=usuarioFacade.findAllBL();
        todosR=rolFacade.findAll();
        //return "listUser.jsf";
        FacesContext.getCurrentInstance().getExternalContext().redirect("listUser.jsf");
    }
    
    public void activarUsuario(Integer id){
        Usuario e = usuarioFacade.find(id);
        e.setEstado("Activo");
        usuarioFacade.edit(e);
        
        todosU = usuarioFacade.findAllBL();
    }
    
    public void inactivarUsuario(Integer id){
        
        Usuario e = usuarioFacade.find(id);
        e.setEstado("Inactivo");
        usuarioFacade.edit(e);
        
        todosU = usuarioFacade.findAllBL();
    }
    
    public void banearUsuario(Integer id){
        
        Usuario e = usuarioFacade.find(id);
        e.setEstado("Baneado");
        usuarioFacade.edit(e);
        
        todosU = usuarioFacade.findAllBL();
    }
    
    public boolean compEstadoA(String e){
        
        return (0==(e.compareTo("Activo")));
    }
    
      public boolean compEstadoI(String e){
        
        return (0==(e.compareTo("Inactivo")));
    }
      
        public boolean compEstadoB(String e){
        
        return (0==(e.compareTo("Baneado")));
    }
        
   
    public UserManagedBean() {
        //todosR=rolFacade.findAll();
        //todosU=usuarioFacade.findAll();
    }

    public Usuario getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Usuario seleccionado) {
        this.seleccionado = seleccionado;
    }

    public List<Usuario> getTodosU() {
        return todosU;
    }

    public void setTodosU(List<Usuario> todosU) {
        this.todosU = todosU;
    }

    public List<Rol> getTodosR() {
        return todosR;
    }

    public void setTodosR(List<Rol> todosR) {
        this.todosR = todosR;
    }

    public String getFK_Rol() {
        return FK_Rol;
    }

    public void setFK_Rol(String FK_Rol) {
        this.FK_Rol = FK_Rol;
    }

    public Usuario getEditable() {
        return editable;
    }

    public void setEditable(Usuario editable) {
        this.editable = editable;
    }

    public String getV_tesoro() {
        return v_tesoro;
    }

    public void setV_tesoro(String v_tesoro) {
        this.v_tesoro = v_tesoro;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
