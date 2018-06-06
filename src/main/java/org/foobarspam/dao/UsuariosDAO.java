package org.foobarspam.dao;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.foobarspam.model.Usuario;
import org.hibernate.query.Query;

import java.util.List;

public class UsuariosDAO extends GenericDAO {

    static final Logger LOGGER = LogManager.getRootLogger();

    public List listar() throws Exception {
        return listar(null, "usuario", "");
    }

    public List listar(Usuario filtro, String campoOrdenacion, String orden) throws Exception {

        List lista;
        try {

            StringBuffer sqlQuery = new StringBuffer();

            sqlQuery.append("from Usuario ");
            sqlQuery.append("where 1=1 ");

            if (filtro.getUsuario() != null) {
                sqlQuery.append("and usuario = :usuario ");
            }
            if (filtro.getContraseña() != null) {
                sqlQuery.append("and contraseña = :contraseña ");
            }

            if (StringUtils.isNotBlank(campoOrdenacion)) {
                sqlQuery.append("order by ");
                sqlQuery.append(campoOrdenacion);
                sqlQuery.append(" ");
                sqlQuery.append(orden);
            }

            LOGGER.debug(sqlQuery.toString());

            Query query = getCurrentSession().createQuery(sqlQuery.toString());

            if (filtro != null && StringUtils.isNotBlank(filtro.getUsuario())) {
                query.setParameter("usuario", filtro.getUsuario());
            }
            if (filtro != null && StringUtils.isNotBlank(filtro.getContraseña())) {
                query.setParameter("contraseña", filtro.getContraseña());
            }

            query.setCacheable(true);

            lista = query.list();

        } catch (Exception ex) {
            LOGGER.error("Error en listar Usuario", ex);
            throw ex;
        }

        return lista;
    }

    public Usuario recuperar(Usuario modelo) throws Exception {
        Usuario aux;
        try {
            Query query;
            if (modelo.getId() != 0) {
                query = getCurrentSession().createQuery("from Usuario where id = :id");
                query.setParameter("id", modelo.getId());
            } else {
                query = getCurrentSession().createQuery("from Usuario where id = :id and usuario = :usuario");
                query.setParameter("id", modelo.getId());
                query.setParameter("usuario", modelo.getUsuario());
            }
            aux = (Usuario) query.setCacheable(true).uniqueResult();
        } catch (Exception ex) {
            LOGGER.error("error en recuperar Usuario", ex);
            throw ex;
        }

        return aux;
    }

    public Usuario findByID(int id) throws Exception {

        Usuario usuario = null;
        try {

            Query query;
            query = getCurrentSession().createQuery("from Usuario where id = :id");
            query.setParameter("id", id);
            usuario = (Usuario) query.setCacheable(false).uniqueResult();

        } catch (Exception ex) {

            LOGGER.error("Error en buscar pelicula por id", ex);
            throw ex;
        }

        return usuario;
    }

    public boolean cambiarPassword() {
        return true;
    }


    public void borrar(Usuario modelo) throws Exception {

        try {

            Query query = getCurrentSession().createQuery("from Usuario where id = :id");
            query.setParameter("id", modelo.getId());
            Usuario aux = (Usuario) query.uniqueResult();
            getCurrentSession().delete(aux);

            getCurrentSession().flush();
            getCurrentSession().clear();

        } catch (Exception ex) {
            getCurrentSession().clear();
            LOGGER.error("error en borrar Usuario", ex);
            throw ex;
        }

    }

    public void guardar(Usuario modelo) throws Exception {

        try {
            getCurrentSession().saveOrUpdate(modelo);

            getCurrentSession().flush();
            getCurrentSession().clear();

            LOGGER.debug("USuario grabado OK");
        } catch (Exception ex) {
            getCurrentSession().clear();
            LOGGER.error("error en guardar Usuario", ex);
            throw ex;
        }

    }

    public boolean existe(int id, String usuario) throws Exception {
        int aux = 0;
        try {
            Query query = getCurrentSession().createQuery("select id from Usuario where id=:id and usuario=:usuario");
            query.setParameter("id", id);
            query.setParameter("usuario", usuario);
            List<Integer> lista = query.list();
            if (lista != null) {
                aux = lista.size();
            }
        } catch (Exception ex) {
            LOGGER.error("Error en existe Usuario: ", ex);
            throw ex;
        }

        if (aux > 0) {
            return true;
        }
        return false;
    }

    public boolean existeByPassword(String password) throws Exception {
        int aux = 0;
        try {

            Query query = getCurrentSession().createQuery("select id, usuario, contraseña, privilegios from Usuario where contraseña=:password");
            query.setParameter("password", password);

            List<Integer> lista = query.list();
            if (lista != null) {
                aux = lista.size();
            }
        } catch (Exception ex) {
            LOGGER.error("Error en existe Usuario: ", ex);
            throw ex;
        }

        if (aux > 0) {
            return true;
        }
        return false;
    }

}
