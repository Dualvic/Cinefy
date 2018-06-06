package org.foobarspam.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.foobarspam.dao.CinesDAO;
import org.foobarspam.dao.PasesDAO;
import org.foobarspam.dao.PeliculasDAO;
import org.foobarspam.dao.UsuariosDAO;
import org.foobarspam.model.Cine;
import org.foobarspam.model.Pase;
import org.foobarspam.model.Pelicula;
import org.foobarspam.model.Usuario;
import org.foobarspam.utils.CinefyConstants;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConfirmacionEntradasAction extends ActionSupport implements SessionAware {

    private static UsuariosDAO usuariosDAO;
    private static CinesDAO cinesDAO;
    private static PeliculasDAO peliculasDAO;
    private static PasesDAO pasesDAO;

    private Map<String,Object> session;

    private Integer cineID;
    private Integer peliculaID;
    private String horario;
    private Integer numeroEntradas;

    private Integer precio;

    private Set<Pase> pasesComprados = new HashSet<Pase>();

    public ConfirmacionEntradasAction() {
        usuariosDAO = new UsuariosDAO();
        cinesDAO = new CinesDAO();
        peliculasDAO = new PeliculasDAO();
        pasesDAO = new PasesDAO();
    }

    public Map<String,Object> getSession() {
        return session;
    }

    public void setSession(Map<String,Object> session) {
        this.session = session;
    }

    public Integer getCineID() {
        return cineID;
    }

    public void setCineID(Integer cineID) {
        this.cineID = cineID;
    }

    public Integer getPeliculaID() {
        return peliculaID;
    }

    public void setPeliculaID(Integer peliculaID) {
        this.peliculaID = peliculaID;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Integer getNumeroEntradas() {
        return numeroEntradas;
    }

    public void setNumeroEntradas(Integer numeroEntradas) {
        this.numeroEntradas = numeroEntradas;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Set<Pase> getPasesComprados() {
        return pasesComprados;
    }

    public void setPasesComprados(Set<Pase> pasesComprados) {
        this.pasesComprados = pasesComprados;
    }

    public String execute() throws Exception {



        try {

            // TODO:: Recuperar el usuario logeado. Completalo cuando tengas el login 100%
            int usuarioLogeadoID;
            // MALO: De momento como no tenemos usuario logeado por defecto cogemos el 1.
            usuarioLogeadoID = (int) getSession().getOrDefault("usuario_id", 1);

            /* BUENO - TODO: Descomentar cuando el login lo tengas
            if ( getSession().get("usuario_id") != null) {
                BUENO: usuarioLogeadoID = (int) getSession().get("usuario_id");
            }
            */



            peliculasDAO.openCurrentSession();
            Pelicula pelicula = peliculasDAO.findByID(peliculaID);
            peliculasDAO.closeCurrentSession();

            cinesDAO.openCurrentSession();
            Cine cine = cinesDAO.findByID(cineID);
            cinesDAO.closeCurrentSession();

            usuariosDAO.openCurrentSession();
            Usuario u = new Usuario();
            u.setId(usuarioLogeadoID);
            Usuario usuario = usuariosDAO.recuperar(u);
            usuariosDAO.closeCurrentSession();

            pasesDAO.openCurrentSessionwithTransaction();
            pasesComprados = pasesDAO.comprarPases(horario, numeroEntradas, cine, pelicula, usuario);

            precio = numeroEntradas * CinefyConstants.PRECIO_POR_ENTRADA;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            pasesDAO.closeCurrentSessionwithTransaction();
            return SUCCESS;
        }

    }
}