package org.foobarspam.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Peliculas")
public class Pelicula {

    private int id;
    private String titulo;
    private String sinopsis;
    private Set<Cine> cines;
    private Set<Valoracion> valoraciones;
    private Set<Pase> pases;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "Pelicula_ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Titulo", nullable = false, unique = true)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Basic
    @Column(name = "Sinopsis")
    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "peliculas")
    public Set<Cine> getCines() {
        return cines;
    }

    public void setCines(Set<Cine> cines) {
        this.cines = cines;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "pelicula")
    public Set<Valoracion> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(Set<Valoracion> valoraciones) {
        this.valoraciones = valoraciones;
    }

    @OneToMany(mappedBy="pelicula", fetch = FetchType.EAGER)
    public Set<Pase> getPases() {
        return pases;
    }

    public void setPases(Set<Pase> pases) {
        this.pases = pases;
    }


    /* TODO:: Modificar el equals y el hashCode para contemplarlo como quieras ...,
     */

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pelicula peliculas = (Pelicula) o;

        if (id != peliculas.id) return false;
        if (titulo != null ? !titulo.equals(peliculas.titulo) : peliculas.titulo != null) return false;
        if (sinopsis != null ? !sinopsis.equals(peliculas.sinopsis) : peliculas.sinopsis != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        result = 31 * result + (sinopsis != null ? sinopsis.hashCode() : 0);
        return result;
    }
    **/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return id == pelicula.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
