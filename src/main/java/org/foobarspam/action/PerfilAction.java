package org.foobarspam.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.foobarspam.dao.UsuariosDAO;
import org.foobarspam.model.Usuario;

import java.util.Map;

public class PerfilAction extends ActionSupport implements SessionAware {

    private Usuario usuario = null;

    private Map<String,Object> session;

    public Map<String,Object> getSession() {
        return session;
    }

    public void setSession(Map<String,Object> session) {
        this.session = session;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    private static UsuariosDAO usuariosDAO;

    public PerfilAction() {
        usuariosDAO = new UsuariosDAO();
    }

    public void getInformacion() {

        usuariosDAO.openCurrentSession();
        try {
            usuario = usuariosDAO.findByID((int) getSession().getOrDefault("usuario_id", 1));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            usuariosDAO.closeCurrentSession();
        }
    }


    public String execute() throws Exception {
        getInformacion();
        if (usuario.getPases().size()>0)
            return SUCCESS;
        else return ERROR;
    }

}


