package org.foobarspam.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

import java.util.List;
import java.util.Map;

/**
 * Created by desarrollo2 on 9/2/18.
 */
public class homeAction extends ActionSupport implements SessionAware {

    private static final Logger LOGGER = LogManager.getLogger("com.kumointernet");

    private Map<String,Object> session;

    public String mensaje = "";
    public String excepcion = "";
    public String nomSeccion = "Inicio";
    public String pagina = "";
    public int bread = 0;
    public int nuevos = 0;
    public String tipo = "";
    public String result = "";

//    private Usuario credenciales;
    public List acciones;

//    public Usuario getCredenciales() {
//        return credenciales;
//    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Map<String,Object> getSession() {
        return session;
    }

    public void setSession(Map<String,Object> session) {
        this.session = session;
    }

//    public String getNomUsu() {
//        return credenciales.getNombre();
//    }

    public String execute() throws Exception {

        getSession().put("Extranet", false);
        return SUCCESS;

    }

}
