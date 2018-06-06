package org.foobarspam.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class ControlAccesoAction extends ActionSupport implements SessionAware {

    public String usuario = "";
    public String password = "";
    public String agencia = "";
    public String proveedor = "";

    public String destino = "";
    public String mensaje = "";
    public String excepcion = "";
    public String result = "";
    public String tipo = "";

    private Map<String, Object> session;

    static final Logger logger = LogManager.getLogger("com.kumointernet");

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getExcepcion() {
        return excepcion;
    }

    public void setExcepcion(String excepcion) {
        this.excepcion = excepcion;
    }

    public String getResultado() {
        return result;
    }

    public void setResultado(String resultado) {
        this.result = resultado;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }


    public String execute() throws Exception {
//        LoginDAO loginDAO = new LoginDAO();
//        ProveedorDAO proveedorDAO = new ProveedorDAO();
//        //control de acceso
//        Usuario u=null;
//        Proveedor prov = null;
//
//        if(StringUtils.isBlank(tipo)) {
//            u = loginDAO.login(usuario, password, agencia);
//        }else if(tipo.equals("extranet")){
//            if (proveedor.equals("")){
//                proveedor = null;
//            }
//            u = loginDAO.loginProveedor(usuario, password, proveedor); //TODO desarrollar este Login nuevo
//            if (u != null) {
//                if (!u.getPerfilByPerfilId().getCodigo().equals("EXTRANET")) {
//                    u = null;
//                }
//            }
//        }
//
//
//        if (u != null) {
//            //meter en la sesion las credenciales
//            getSession().put("usuario", u);
//            getSession().put("fechaUltimaAction", new Date().getTime());
//            //el interceptor lo que tendra que mirar es si tiene permisos para cada pagina
//
//
//            getSession().put("menu", todoMenu(u.getPerfilByPerfilId()));
//
//            //cogemos las acciones
//            List<Accion> accionList = new ArrayList<Accion>();
//            for( PerfilAccion perfilAccion : u.getPerfilByPerfilId().getPerfilAccionsById() ){
//                accionList.add(perfilAccion.getAccionByAccionId());
//            }
//
//            getSession().put("acciones", todoAccion(accionList));
//
//
//            if (tipo.equals("extranet")) {
//                prov = proveedorDAO.recuperarPorCodigo(proveedor);
//                getSession().put("proveedor", prov);
//            }
//
//            if (u.getCodigo().equals("YIELDPLANET")){
//                SendMailNew sendMailNew = new SendMailNew();
//                String destinatario = "soporte@kumointernet.com";
//                String cc = null;
//
//                String bodyMail = "El usuario YieldPlanet ha hecho login en el back";
//
//               try {
//                   sendMailNew.sendHTML("info@kumointernet.com", destinatario, cc, "ACCESO BACK YIELDPLANET", bodyMail, "");
//               }
//               catch (Exception e){
//                   logger.error("*** Error al enviar el email de acceso YieldPlanet ***");
//               }
//            }
//
            return SUCCESS;
//        } else {
//            mensaje = "Login incorrecto";
//            getSession().remove("usuario");
//            return INPUT;
//        }
    }
//
//
//    public List<Menu> listarPadres(Perfil perfil) {
//        List<Menu> lm = new ArrayList<Menu>();
//        try {
//            MenuDAO menuDAO = new MenuDAO();
//            lm = menuDAO.listarPadres(perfil);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return lm;
//    }
//
//    public List<Menu> listarHijos(Menu m, Perfil perfil) {
//
//        List<Menu> lm = new ArrayList<Menu>();
//        try {
//            MenuDAO menuDAO = new MenuDAO();
//            lm = menuDAO.listarHijos(m, perfil);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return lm;
//    }
//
//    public List todoMenu(Perfil perfil) {
//
//        List<HashMap> l = new ArrayList<HashMap>();
//        List<Menu> lp = listarPadres(perfil);
//        for (Menu menuPadre : lp) {
//            HashMap hashMap = new HashMap();
//
//            List<Menu> lh = listarHijos(menuPadre, perfil);
//
//            hashMap.put("PADRE", menuPadre);
//            hashMap.put("HIJOS", lh);
//
//            l.add(hashMap);
//        }
//        return l;
//    }
//
//    private List todoAccion(List<Accion> acciones) {
//        List<String> listaAcciones = new ArrayList<String>();
//        for (Accion accion : acciones) {
//            listaAcciones.add(accion.getAction());
//        }
//        return listaAcciones;
//    }
//



}
