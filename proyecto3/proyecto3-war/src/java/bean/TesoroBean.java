/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import dao.BusquedatesorosFacade;
import dao.RolFacade;
import dao.SolicitudtesoroFacade;
import dao.TesoroFacade;
import dao.UsuarioFacade;
import entity.Busquedatesoros;
import entity.BusquedatesorosPK;
import entity.Solicitudtesoro;
import entity.Tesoro;
import entity.Usuario;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pepe
 */
@Named(value = "tesoroBean")
@SessionScoped
public class TesoroBean implements Serializable {
    @EJB
    private BusquedatesorosFacade busquedatesorosFacade;
    @EJB
    private RolFacade rolFacade;
    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB
    private SolicitudtesoroFacade solicitudtesoroFacade;
    @EJB
    private TesoroFacade tesoroFacade;
    
    

    @ManagedProperty("#{apiLogin}")

    private loginApi userManager;

    private Tesoro nuevoTesoro;
    private Tesoro tesoroAValidar;
    private Tesoro tesoroAEditar;
    private Solicitudtesoro solicitudAEvaluar;
    private HttpSession session;
    
    
    /**
     * Creates a new instance of TesoroBean
     */
    public TesoroBean() {
    }
    
    public List<Tesoro> obtenerTesoros()
    {
        return tesoroFacade.getAllTesoros();
    }
    
    public List<Tesoro> obtenerTesorosPendientes()
    {
        /*Me traigo los tesoros pendientes porque le pongo "pendiente"*/
        return tesoroFacade.getAllTesorosbyEstadoSolicitud("pendiente");
    }
    
    public List<Tesoro> obtenerTesorosValidados()
    {
        return tesoroFacade.getAllTesorosbyEstadoSolicitud("aceptado");
    }
    
    public List<Tesoro> obtenerMisTesorosPendientes()
    {
       // List<Tesoro> l = tesoroFacade.getAllTesorosbyEstadoSolicitudandUser("pendiente", 10);
        /*Aqui hay que volver a obtener el id del usuario que este logueado*/
        
         FacesContext context = FacesContext.getCurrentInstance();
        session = (HttpSession) context.getExternalContext().getSession(true);
         Usuario logueado = (Usuario) session.getAttribute("usuariologueado");
        
        //List<Tesoro> tesoritos = tesoroFacade.getAllTesorosbyEstadoSolicitudandUser("pendiente", logueado.getIdUsuario());
        
        return tesoroFacade.getAllTesorosbyEstadoSolicitudandUser("pendiente", logueado.getIdUsuario());
    }
    
    public List<Tesoro> obtenerMisTesorosValidados()
    {
        /*Aqui debería de traerme el idUsuario del logueado*/
          FacesContext context = FacesContext.getCurrentInstance();
         session = (HttpSession) context.getExternalContext().getSession(true);
          Usuario logueado = (Usuario) session.getAttribute("usuariologueado");
        
        return tesoroFacade.getAllTesorosbyEstadoSolicitudandUser("aceptado", logueado.getIdUsuario());
    }
    
    
    public String crearTesoro()
    {
        try{
            
          FacesContext context = FacesContext.getCurrentInstance();
         session = (HttpSession) context.getExternalContext().getSession(true);
          Usuario logueado = (Usuario) session.getAttribute("usuariologueado");
          
        Solicitudtesoro sol = new Solicitudtesoro();
        sol.setAprobado("PENDIENTE");
        sol.setComentario("PENDIENTE");
        solicitudtesoroFacade.create(sol);
        /*Aqui debería de traerme el idUsuario del logueado*/
        nuevoTesoro.setUsuarioidUsuario(usuarioFacade.find(logueado.getIdUsuario()));
        nuevoTesoro.setSolicitudTesoroidSolicitudTesoro(sol);
        tesoroFacade.create(nuevoTesoro);
        return "/tesoros/readMisTesorosValidados.jsf";
        }
        catch (Exception e)
        {
            return "/tesoros/readTesorosValidados.jsf";
        }
    }
    
    public String prepararCrearTesoro()
    {
        /*Hay que hacerlo ya que ya no usar los campos de una entidad, si no una propia entidad, es necesario hacer un create previo*/
        nuevoTesoro = new Tesoro();
        return "/tesoros/createTesoro.jsf";
    }
    
    public String prepararEvaluarTesoro(Tesoro t)
    {
        Solicitudtesoro sol = solicitudtesoroFacade.find(t.getSolicitudTesoroidSolicitudTesoro().getIdSolicitudTesoro());
        solicitudAEvaluar = sol;
        tesoroAValidar = tesoroFacade.find(t.getIdTesoro());
        return "/tesoros/validateATreasure.jsf";
        /*Preguntar si quieren un PopUP, o lo que sea*/
        /*sol.setAprobado("ACEPTADO");
        sol.setComentario("Aceptado premoh");
        solicitudtesoroFacade.edit(sol);
        Usuario u;
        u = usuarioFacade.find(t.getUsuarioidUsuario().getIdUsuario());
        /*Esto de aquí es bastante feo, mejor me creo una consulta que sea traerme los roles por un string*/
        /*u.setRolidRol(rolFacade.find(Integer.parseInt("2")));
        usuarioFacade.edit(u);
        return "/tesoros/validateTesoro.jsf";*/
    }
    
    public String evaluarTesoro()
    {
        if(solicitudAEvaluar.equals("ACEPTADO"))
        {
        Usuario u;
        solicitudtesoroFacade.edit(solicitudAEvaluar);
        u = usuarioFacade.find(tesoroAValidar.getUsuarioidUsuario().getIdUsuario());
        u.setRolidRol(rolFacade.getByPrioridad(1));
        usuarioFacade.edit(u);
        return "/tesoros/readTesorosValidados.jsf";
        }
        else
        {
            Usuario u;
            solicitudtesoroFacade.edit(solicitudAEvaluar);
            return "/tesoros/readTesorosValidados.jsf";
        }
    }
    
    public String prepararEditarTesoro(Tesoro t)
    {
        tesoroAEditar = tesoroFacade.find(t.getIdTesoro());
        return "/tesoros/editTesoro.jsf";
    }
    
    public String editarTesoro()
    {
        tesoroFacade.edit(tesoroAEditar);
        return "/tesoros/readMisTesorosValidados.jsf";
    }
    
    /* BUSQUEDAS */
    
    public List<Tesoro> obtenerMisBusquedas(){
        /*Aqui va el usuario logueado*/
        
         FacesContext context = FacesContext.getCurrentInstance();
        session = (HttpSession) context.getExternalContext().getSession(true);
         Usuario logueado = (Usuario) session.getAttribute("usuariologueado");
         
        return busquedatesorosFacade.getBusquedasByUser(logueado.getIdUsuario());
    }
    
    public String crearBusqueda(Tesoro t)
    {
        Busquedatesoros bt = new Busquedatesoros();
        BusquedatesorosPK btpk = new BusquedatesorosPK();
        /*Aqui va el usuario logueado*/
        
           FacesContext context = FacesContext.getCurrentInstance();
        session = (HttpSession) context.getExternalContext().getSession(true);
         Usuario logueado = (Usuario) session.getAttribute("usuariologueado");
        
        btpk.setTesoroidTesoro(t.getIdTesoro());
        btpk.setUsuarioidUsuario(logueado.getIdUsuario());
        bt.setBusquedatesorosPK(btpk);
        bt.setUsuario(logueado);
        bt.setTesoro(tesoroFacade.find(t.getIdTesoro()));
        busquedatesorosFacade.create(bt);
        return "/tesoros/misBusquedas.jsf";
    }
    
    
    // Added by IsmiKin : necesita este metodo para poder añadir busqueda desde
    // otra vista que no sea el listar
    public void crearBusqueda(){
        crearBusqueda(nuevoTesoro);
    }
    
    public List<Tesoro> obtenerTesorosSinBuscar()
    {
        
         FacesContext context = FacesContext.getCurrentInstance();
        session = (HttpSession) context.getExternalContext().getSession(true);
         Usuario logueado = (Usuario) session.getAttribute("usuariologueado");
         
        List<Tesoro> listatesorosdisponibles = tesoroFacade.getAllTesorosbyEstadoSolicitud("aceptado");
        List<Tesoro> listatesorosbuscados = busquedatesorosFacade.getBusquedasByUser(logueado.getIdUsuario());
        
        if(listatesorosbuscados != null){
        listatesorosdisponibles.removeAll(listatesorosbuscados);
        }
        return listatesorosdisponibles;
    }
    
    public String eliminarBusqueda(Tesoro t)
    {
        
         FacesContext context = FacesContext.getCurrentInstance();
        session = (HttpSession) context.getExternalContext().getSession(true);
         Usuario logueado = (Usuario) session.getAttribute("usuariologueado");
        
        busquedatesorosFacade.deleteBusquedaByTesoroyUser(logueado.getIdUsuario(), t.getIdTesoro());
        return "/tesoros/misBusquedas.jsf";
    }
    
    
    /*GETTER Y SETTERS*/
    public TesoroFacade getTesoroFacade() {
        return tesoroFacade;
    }

    public void setTesoroFacade(TesoroFacade tesoroFacade) {
        this.tesoroFacade = tesoroFacade;
    }

    public Tesoro getNuevoTesoro() {
        return nuevoTesoro;
    }

    public void setNuevoTesoro(Tesoro nuevoTesoro) {
        this.nuevoTesoro = nuevoTesoro;
    }

    public Tesoro getTesoroAValidar() {
        return tesoroAValidar;
    }

    public void setTesoroAValidar(Tesoro tesoroAValidar) {
        this.tesoroAValidar = tesoroAValidar;
    }

    public Tesoro getTesoroAEditar() {
        return tesoroAEditar;
    }

    public void setTesoroAEditar(Tesoro tesoroAEditar) {
        this.tesoroAEditar = tesoroAEditar;
    }

    public Solicitudtesoro getSolicitudAEvaluar() {
        return solicitudAEvaluar;
    }

    public void setSolicitudAEvaluar(Solicitudtesoro solicitudAEvaluar) {
        this.solicitudAEvaluar = solicitudAEvaluar;
    }
    
    public List<Tesoro> obtenerTesorosEncontrados()
    {
          FacesContext context = FacesContext.getCurrentInstance();
         session = (HttpSession) context.getExternalContext().getSession(true);
          Usuario logueado = (Usuario) session.getAttribute("usuariologueado");
        
          return tesoroFacade.getTesorosEncontrados(logueado) ;
        
    }
    
    
}
