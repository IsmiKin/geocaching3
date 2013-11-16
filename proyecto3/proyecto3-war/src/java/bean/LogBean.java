/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.BusquedatesorosFacade;
import dao.LogFacade;
import dao.TesoroFacade;
import dao.TiposucesoFacade;
import entity.Busquedatesoros;
import entity.Log;
import entity.LogPK;
import entity.Tesoro;
import entity.Tiposuceso;
import entity.Usuario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.util.Date;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Digger
 */
@Named(value = "logBean")
@SessionScoped
public class LogBean implements Serializable {
    @EJB
    private TesoroFacade tesoroFacade;
    @EJB
    private BusquedatesorosFacade busquedaTesorosFacade;
    @EJB
    private TiposucesoFacade tiposucesoFacade;
    @EJB
    private LogFacade logFacade;
    
   
    private Tesoro tesoro = null;
    private String comentario = "";
    private String v_tesoro ="";    
    /**
     * Creates a new instance of LogBean
     */
    public LogBean() {
        
    }
    public boolean validar(){
       
        tesoro = tesoroFacade.findTesoroByCodigoV(v_tesoro);
       /* boolean valido = false;
        if (tesoro!=null){
            locateLog();
            valido = true;
        }
        
        return valido;*/
        return validar(tesoro);
    }
    
    // Added IsmiKin : Validar sabiendo el Tesoro, te ahorras de buscarlo
    public boolean validar(Tesoro tesoro){
             
        boolean valido = false;
        if (tesoro!=null){
            locateLog();
            valido = true;
        }
        
        return valido;
    }
    
    public List<Log> getListLogByTesoro(){
        return logFacade.getListLogByTesoro(tesoro.getIdTesoro());
    }
    public void createLog(Tesoro tesoro, String comentario, String nameSuceso) {
        Tiposuceso suceso = tiposucesoFacade.getByNameTipoSuceso(nameSuceso);
        Usuario usuario = getUserSession();
        
        LogPK lp = new LogPK();
        Log newLog = new Log();
        Date date = new Date();
        
        if(tesoro!=null){
             lp.setTesoroidTesoro(tesoro.getIdTesoro());
            lp.setUsuarioidUsuario(usuario.getIdUsuario());

            newLog.setLogPK(lp);
            newLog.setBorradoLogico(false);
            newLog.setComentario(comentario);
            newLog.setFecha(date);
            newLog.setTesoro(tesoro);
            newLog.setTipoSucesoidTipoSuceso(suceso);
            newLog.setUsuario(usuario);

            logFacade.create(newLog);
        }
        
       
    }
    public void locateLog(Tesoro tesoro, String comentario) {
        createLog(tesoro,comentario,"Encontrado");
        Usuario usuario = getUserSession();
        Busquedatesoros bt = busquedaTesorosFacade.findByTesoroIdTesoroAndByUser(tesoro.getIdTesoro(), usuario.getIdUsuario());
        if (bt!=null){
            busquedaTesorosFacade.remove(bt);
        }
    }
    public void locateLog(Tesoro tesoro) {
        locateLog(tesoro,"");
    }
    public void locateLog(){
        locateLog(tesoro,comentario);
    }
    public void noLocatedLog(Tesoro tesoro, String comentario) {
        comentario="";
        createLog(tesoro,comentario,"NoEncontrado");
    }
    public void noLocatedLog(Tesoro tesoro) {
        noLocatedLog(tesoro,"");
    }
     public void noLocatedLog(){
         noLocatedLog(tesoro,comentario);
    }
    public void problemLog(Tesoro tesoro, String comentario) {
        createLog(tesoro,comentario,"Problema");
    }
    public void problemLog(Tesoro tesoro) {
        problemLog(tesoro,"");
    }
    public void problemLog(){
        problemLog(tesoro,comentario);
    }
    
    public Usuario getUserSession(){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        return (Usuario) session.getAttribute("usuariologueado");
    }
    public Tesoro getTesoro() {
        return tesoro;
    }

    public void setTesoro(Tesoro tesoro) {
        this.tesoro = tesoro;
    }

    public String getComentario() {
        return comentario;
    }
    
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getV_tesoro() {
        return v_tesoro;
    }

    public void setV_tesoro(String v_tesoro) {
        this.v_tesoro = v_tesoro;
    }
    
    // Added by IsmiKin : se necesita para redireccionar a la vista de Log
    public String mostrarLogTesoro(){
        return "ListLog.jsf";
    }
        
    
}
