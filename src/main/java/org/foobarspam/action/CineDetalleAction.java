package org.foobarspam.action;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;
import org.foobarspam.dao.CinesDAO;
import org.foobarspam.dao.PeliculasDAO;
import org.foobarspam.model.Cine;
import org.foobarspam.model.Pelicula;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CineDetalleAction extends ActionSupport implements SessionAware {

    private static CinesDAO cinesDAO;

    private Map<String,Object> session;

    private Integer cineID = null;
    private Cine cine = null;


    public CineDetalleAction() {
        cinesDAO = new CinesDAO();
    }

    public Map<String,Object> getSession() {
        return session;
    }

    public void setSession(Map<String,Object> session) {
        this.session = session;
    }

    public Cine getCine() {
        return cine;
    }

    public void setCine(Cine cine) {
        this.cine = cine;
    }

    public Integer getCineID() {
        return cineID;
    }

    public void setCineID(Integer cineID) {
        this.cineID = cineID;
    }

    public void getInformacion() {

        cinesDAO.openCurrentSession();
        try {
            cine = cinesDAO.findByID(cineID);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            cinesDAO.closeCurrentSession();
        }
    }


    public String execute() throws Exception {
        getInformacion();
        return SUCCESS;
    }

}
