package org.foobarspam.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.foobarspam.dao.CinesDAO;
import org.foobarspam.model.Cine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CinesAction extends ActionSupport implements SessionAware {

    private Map<String,Object> session;

    private static CinesDAO cinesDAO;

    private List<Cine> lista = new ArrayList<>();

    public CinesAction() {
        cinesDAO = new CinesDAO();
    }

    public Map<String,Object> getSession() {
        return session;
    }

    public void setSession(Map<String,Object> session) {
        this.session = session;
    }

    public List<Cine> getLista() {
        return lista;
    }

    public void setLista(List<Cine> lista) {
        this.lista = lista;
    }

    private void getListaCines() {

        cinesDAO.openCurrentSession();
        try {
            lista = cinesDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            cinesDAO.closeCurrentSession();
        }

    }

    public String execute() throws Exception {
        getListaCines();
        return SUCCESS;
    }

}
