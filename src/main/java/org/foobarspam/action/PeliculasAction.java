package org.foobarspam.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.foobarspam.dao.PeliculasDAO;
import org.foobarspam.model.Pelicula;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PeliculasAction extends ActionSupport implements SessionAware {

    private static PeliculasDAO peliculasDAO;

    private Map<String, Object> session;

    private List<Pelicula> lista = new ArrayList<>();

    public PeliculasAction() {
        peliculasDAO = new PeliculasDAO();
    }


    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }

    public List<Pelicula> getLista() {
        return lista;
    }

    public void setLista(List<Pelicula> lista) {
        this.lista = lista;
    }



    private void getListaPeliculas() {

        peliculasDAO.openCurrentSession();
        try {

            lista = peliculasDAO.getAll();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            peliculasDAO.closeCurrentSession();
        }
    }

    public String execute() throws Exception {
        getListaPeliculas();
        return SUCCESS;
    }

}