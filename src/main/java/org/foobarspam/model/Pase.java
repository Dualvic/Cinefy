package org.foobarspam.model;


import javax.persistence.*;

import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Pases")
public class Pase {

    private int id;
    private String horario;
    private Pelicula pelicula;
    private Cine cine;
    private Usuario usuario;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Horario", nullable = false)
    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    public Cine getCine () {
        return cine;
    }

    public void setCine(Cine cine) { this.cine = cine ;}

    // No poner cascade All!!
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /* TODO:: Modificar el equals y el hashCode para contemplarlo como quieras ...,
     */
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pase pase = (Pase) o;

        if (id != pase.id) return false;
        if (horario != null ? !horario.equals(pase.horario) : pase.horario != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (horario != null ? horario.hashCode() : 0);
        return result;
    }
    */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pase pase = (Pase) o;
        return id == pase.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
