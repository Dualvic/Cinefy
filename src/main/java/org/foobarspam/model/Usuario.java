package org.foobarspam.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by desarrollo2 on 16/5/18.
 */
@Entity
@Table(name = "Usuarios")
public class Usuario {

    private Integer id;
    private String usuario;
    private String contraseña;
    private Integer privilegios;
    private Set<Pase> pases;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Usuario", nullable = false)
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Basic
    @Column(name = "Contraseña", nullable = false)
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Basic
    @Column(name = "Privilegios")
    public Integer getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(Integer privilegios) {
        this.privilegios = privilegios;
    }

    @OneToMany(mappedBy="usuario", fetch = FetchType.EAGER)
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

        Usuario usuario = (Usuario) o;

        if (id != null ? !id.equals(usuario.id) : usuario.id != null) return false;
        if (this.usuario != null ? !this.usuario.equals(usuario.usuario) : usuario.usuario != null) return false;
        if (contraseña != null ? !contraseña.equals(usuario.contraseña) : usuario.contraseña != null) return false;
        if (privilegios != null ? !privilegios.equals(usuario.privilegios) : usuario.privilegios != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + (contraseña != null ? contraseña.hashCode() : 0);
        result = 31 * result + (privilegios != null ? privilegios.hashCode() : 0);
        return result;
    }
    */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
