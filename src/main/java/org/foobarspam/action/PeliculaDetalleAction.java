package org.foobarspam.action;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;
import org.foobarspam.dao.PeliculasDAO;
import org.foobarspam.model.Pelicula;

import java.util.Map;

public class PeliculaDetalleAction  extends ActionSupport implements SessionAware {

    private static PeliculasDAO peliculasDAO;

    private Map<String, Object> session;

    private Integer peliculaID;
    private Pelicula pelicula = null;

    public PeliculaDetalleAction() {
        peliculasDAO = new PeliculasDAO();
    }

    public Integer getPeliculaID() {
        return peliculaID;
    }

    public void setPeliculaID(Integer peliculaID) {
        this.peliculaID = peliculaID;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }


    public void getInformacion() {
        peliculasDAO.openCurrentSession();
        try {
            pelicula = peliculasDAO.findByID(peliculaID);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            peliculasDAO.closeCurrentSession();
        }
    }

    public String execute() throws Exception {
        getInformacion();
        return SUCCESS;
    }

}
