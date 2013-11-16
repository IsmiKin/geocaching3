/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.TesoroFacade;
import entity.Tesoro;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author kuku
 */
@Named(value = "cacheBean")
@SessionScoped
public class CacheBean implements Serializable {
    @EJB
    private TesoroFacade tesoroFacade;

    private List<Tesoro> listaTesoros;
    private Tesoro seleccionado;
    private String paginaLlamante;
    private String filtroLocalidad;
    
    /**
     * Creates a new instance of cacheBean
     */

    public CacheBean() {
        
    }

    public List<Tesoro> getListaTesoros() {
        return listaTesoros;
    }

    public void setListaTesoros(List<Tesoro> listaTesoros) {
        this.listaTesoros = listaTesoros;
    }

    public String getFiltroLocalidad() {
        return filtroLocalidad;
    }

    public void setFiltroLocalidad(String filtroLocalidad) {
        this.filtroLocalidad = filtroLocalidad;
    }
    
    public List<Tesoro> getAllTesoros()
    {
        return tesoroFacade.getTesorosByBorradoLogico();
    }
    public void filtrarTesorosByLocalidad()
    {
        this.listaTesoros = tesoroFacade.getTesorosByLocalidad(this.filtroLocalidad);
    }

    public Tesoro getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Tesoro seleccionado) {
        this.seleccionado = seleccionado;
    }
    public String detallesTesoro()
    {
        return "detallesTesoro.jsf";
    }
    
    // IsmiKin : Ya no hace falta este método :D
    public String volverPagina()
    {
        //return this.paginaLlamante;
        return  paginaLlamante.replaceAll("/proyecto3-war/", " ");
    }
    // --- Inservible
    
    public String filtrarLocalidad()
    {
        this.filtrarTesorosByLocalidad();
        return "listarTesoros.jsf";
    }

    public String getPaginaLlamante() {
        return paginaLlamante;
    }

    public void setPaginaLlamante(String paginaLlamante) {
        this.paginaLlamante = paginaLlamante;
    }
}
