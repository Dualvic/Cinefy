package org.foobarspam.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.foobarspam.model.Cine;
import org.foobarspam.model.Pase;
import org.foobarspam.model.Pelicula;
import org.foobarspam.model.Usuario;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.Set;

public class PasesDAO extends GenericDAO {

    static final Logger LOGGER = LogManager.getRootLogger();

    public Set<Pase> comprarPases(String horario, Integer numeroDeEntradas, Cine cine, Pelicula pelicula, Usuario usuario) {

        Set<Pase> pases = new HashSet<Pase>();
        for (int i = 0; i < numeroDeEntradas; i++) {
            Pase p = new Pase();
            p.setHorario(horario);
            p.setCine(cine);
            p.setPelicula(pelicula);
            p.setUsuario(usuario);
            pases.add(p);
            getCurrentSession().save(p);
        }

        return pases;
    }

}
