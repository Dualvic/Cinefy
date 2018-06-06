package org.foobarspam.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Cines")
public class Cine {

    private int id;
    private String nombre;
    private String direccion;
    private Set<Pelicula> peliculas;
    private Set<Pase> pases;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "Cine_ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Nombre", unique = true, nullable = false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "Direccion", nullable = false)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "Cines_Peliculas", joinColumns = {
            @JoinColumn(name = "Cine_ID", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "Pelicula_ID", nullable = false, updatable = false)
    })
    public Set<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(Set<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    @OneToMany(mappedBy="cine", fetch = FetchType.EAGER)
    public Set<Pase> getPases() {
        return pases;
    }

    public void setPases(Set<Pase> pases) {
        this.pases = pases;
    }

    /* TODO:: Modificar el equals y el hashCode para contemplarlo como quieras ...,
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cine cine = (Cine) o;

        if (id != cine.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
