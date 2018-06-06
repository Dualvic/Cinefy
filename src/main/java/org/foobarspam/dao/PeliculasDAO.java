package org.foobarspam.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.foobarspam.model.Pelicula;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class PeliculasDAO extends GenericDAO {

    static final Logger LOGGER = LogManager.getRootLogger();

    public Pelicula findByID(int id) throws Exception {

        Pelicula pelicula = null;
        try {

            Query query;
            query = getCurrentSession().createQuery("from Pelicula where id = :id");
            query.setParameter("id", id);
            pelicula = (Pelicula) query.setCacheable(false).uniqueResult();

        } catch (Exception ex) {

            LOGGER.error("Error en buscar pelicula por id", ex);
            throw ex;
        }

        return pelicula;
    }

    public List getAll() throws Exception {

        List list = new ArrayList<>();

        try {
            StringBuffer sqlQuery = new StringBuffer();
            sqlQuery.append("from Pelicula");

            LOGGER.debug(sqlQuery.toString());

            Query query = getCurrentSession().createQuery(sqlQuery.toString());
            query.setCacheable(true);

            list = query.list();

        } catch (Exception ex) {
            LOGGER.error("Error en listar Peliculas", ex);
            throw ex;
        }

        return list;
    }

}
