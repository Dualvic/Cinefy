package org.foobarspam.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.foobarspam.model.Cine;
import org.foobarspam.model.Pelicula;
import org.foobarspam.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CinesDAO extends GenericDAO {

    static final Logger LOGGER = LogManager.getRootLogger();

    public List getAll() throws Exception {

        List list = new ArrayList<>();

        try {
            StringBuffer sqlQuery = new StringBuffer();
            sqlQuery.append("from Cine ");

            LOGGER.debug(sqlQuery.toString());

            Query query = getCurrentSession().createQuery(sqlQuery.toString());
            query.setCacheable(true);

            list = query.list();

        } catch (Exception ex) {
            LOGGER.error("Error en listar Cines", ex);
            throw ex;
        }

        return list;
    }

    public Cine findByID(int id) throws Exception {

        Cine cine = null;
        try {

            Query query;
            query = getCurrentSession().createQuery("from Cine where id = :id");
            query.setParameter("id", id);
            cine = (Cine) query.setCacheable(false).uniqueResult();

        } catch (Exception ex) {

            LOGGER.error("Error en buscar cine por id", ex);
            throw ex;
        }

        return cine;
    }
}
