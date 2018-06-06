package org.foobarspam.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.foobarspam.dao.UsuariosDAO;
import org.foobarspam.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class UsuariosAction extends ActionSupport implements SessionAware {


    private Map<String, Object> session;

    static final Logger LOGGER = LogManager.getRootLogger();

    public Usuario modelo = new Usuario();
    public List<Usuario> listaUsuarios = new ArrayList<Usuario>();

    public String mensaje = "";
    public String excepcion = "";
    public String result = "";
    public String nomSeccion = "ProveedorRegimen";
    public String accion = "";

    public String campoOrdenacion = "usuario";
    public String orden = "desc";

    public String usuario;
    public String password;

    public String olderPw;
    public String newPw;

    public Usuario filtro = new Usuario();
    public List<Usuario> lista = new ArrayList<>();

    private static UsuariosDAO usuariosDAO;

    public Usuario Usuario = new Usuario();

    public UsuariosAction() {
        usuariosDAO = new UsuariosDAO();
    }

    public String execute() throws Exception {
        return SUCCESS;
    }

    public String Usuarios() {

        try {


        } catch (Exception ex) {
            this.mensaje = "Se ha producido un error.";
            this.excepcion = ex.toString();
            LOGGER.error("Se ha producido un error:", ex);
            return ERROR;
        }


        return SUCCESS;
    }

    public String listar() throws Exception {

        String retorno = null;

        try {

            usuariosDAO.openCurrentSession();

            filtro.setUsuario(usuario);
            filtro.setContraseña(password);

            lista = usuariosDAO.listar(filtro, campoOrdenacion, orden);

            retorno = SUCCESS;

        } catch (Exception ex) {

            this.mensaje = "Se ha producido un error.";
            this.excepcion = ex.toString();
            LOGGER.error("Se ha producido un error:", ex);

            retorno = ERROR;

        } finally {

            usuariosDAO.closeCurrentSession();
            return retorno;
        }

    }

    public String logginIn() {

        String retorno = "";

        try {

            filtro.setUsuario(usuario);
            filtro.setContraseña(password);

            usuariosDAO.openCurrentSession();
            lista = usuariosDAO.listar(filtro, campoOrdenacion, orden);


            for (Usuario user : lista) {
                if (Objects.equals(user.getUsuario(), usuario) && Objects.equals(user.getContraseña(), password)) {
                    // METEMOS EN SESION EL USUARIO_ID!
                    getSession().put("usuario_id", user.getId());
                    retorno = SUCCESS;
                } else {
                    retorno = ERROR;
                }
            }
        } catch (Exception ex) {

            LOGGER.debug("Fallo en loging: ", ex);
            retorno = ERROR;

        } finally {

            usuariosDAO.closeCurrentSession();
            return retorno;
        }

    }

    public String changePw() throws Exception {

        String retorno = null;

        try {

            usuariosDAO.openCurrentSession();

            if (usuariosDAO.existeByPassword(olderPw)) {

                filtro.setContraseña(olderPw);
                lista = usuariosDAO.listar(filtro, campoOrdenacion, orden);

                usuariosDAO.closeCurrentSession();

                usuariosDAO.openCurrentSessionwithTransaction();
                Usuario user = new Usuario();
                user.setId(lista.get(0).getId());
                user.setUsuario(lista.get(0).getUsuario());
                user.setContraseña(newPw);
                user.setPrivilegios(lista.get(0).getPrivilegios());
                usuariosDAO.guardar(user);

                retorno = SUCCESS;
            } else {
                retorno = ERROR;
            }


        } catch (Exception ex) {

            LOGGER.debug("Fallo en changePw: ", ex);
            retorno = ERROR;

        } finally {

            usuariosDAO.closeCurrentSessionwithTransaction();
            return retorno;
        }




    }

    /** GETTERS Y SETTERS **/

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }

    public String getExcepcion() {
        return excepcion;
    }

    public void setExcepcion(String excepcion) {
        this.excepcion = excepcion;
    }

    public String getNomSeccion() {
        return nomSeccion;
    }

    public void setNomSeccion(String nomSeccion) {
        this.nomSeccion = nomSeccion;
    }

}