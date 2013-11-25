/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author IsmiKin
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {
    @PersistenceContext(unitName = "proyecto3-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

   
    public List<Usuario> findAllBL(){
        List<Usuario> usuariolist = null;

        try {
            Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.borradoLogico = 0");
            usuariolist = q.getResultList();
        } catch (Exception ex) {}
        
        return usuariolist;
    }
    public boolean checkLogin(String nickname, String pass){
        Query consulta = em.createQuery("SELECT u FROM Usuario u WHERE u.nickname LIKE :Nickname AND u.password LIKE :Pass AND u.borradoLogico = 0").setParameter("Nickname", nickname).setParameter("Pass", pass);
        //SELECT s from Computers s where s.id.column1 = :column1").setParameter("column1", "SONY LAPTOPS");
        int checking = consulta.getResultList().size();     // Comprobamos si concuerda password y nickname, si es 0 es que casca
        return checking==1;
    }
    
    public int getIdByNickname(String nickname){
        Query consulta = em.createQuery("SELECT u FROM Usuario u WHERE u.nickname LIKE :nickname AND u.borradoLogico = 0").setParameter("nickname", nickname);
        Usuario resultado = (Usuario)consulta.getSingleResult();
        int salida = -1;
        if(resultado!=null)
            salida = resultado.getIdUsuario();
        return salida;
    }
     
    public Usuario getByNickname(String nickname){
        Query consulta = em.createQuery("SELECT u FROM Usuario u WHERE u.nickname LIKE :nickname AND u.borradoLogico = 0").setParameter("nickname", nickname);
        Usuario resultado = (Usuario)consulta.getSingleResult();
        return resultado;
    }

    
}