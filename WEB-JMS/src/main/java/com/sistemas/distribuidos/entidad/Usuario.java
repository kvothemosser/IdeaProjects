package com.sistemas.distribuidos.entidad;

import javax.persistence.*;

/**
 * Created by mtapiat on 16/07/2015.
 */
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_USUARIO", nullable = false, insertable = true, updatable = true)
    private int idUsuario;

    @Basic
    @Column(name = "NOMBRE", nullable = false, insertable = true, updatable = true, length = 100)
    private String nombre;

    @Basic
    @Column(name = "APELLIDO_PATERNO", nullable = false, insertable = true, updatable = true, length = 100)
    private String apellidoPaterno;

    @Basic
    @Column(name = "APELLIDO_MATERNO", nullable = true, insertable = true, updatable = true, length = 100)
    private String apellidoMaterno;

    @Basic
    @Column(name = "USUARIO", nullable = false, insertable = true, updatable = true, length = 20)
    private String usuario;

    @Basic
    @Column(name = "PASSWORD", nullable = false, insertable = true, updatable = true, length = 10)
    private String password;


    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
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
}
