package com.sistemas.distribuidos.entidad;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Moises Tapia Tellez on 12/07/2015.
 */
@Entity
public class Alumno {
    private int idAlumno;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String matricula;

    @Id
    @Column(name = "ID_ALUMNO", nullable = false, insertable = true, updatable = true)
    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    @Basic
    @Column(name = "NOMBRE", nullable = false, insertable = true, updatable = true, length = 100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "APELLIDO_PATERNO", nullable = false, insertable = true, updatable = true, length = 100)
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    @Basic
    @Column(name = "APELLIDO_MATERNO", nullable = true, insertable = true, updatable = true, length = 100)
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    @Basic
    @Column(name = "MATRICULA", nullable = false, insertable = true, updatable = true, length = 10)
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alumno alumno = (Alumno) o;

        if (idAlumno != alumno.idAlumno) return false;
        if (nombre != null ? !nombre.equals(alumno.nombre) : alumno.nombre != null) return false;
        if (apellidoPaterno != null ? !apellidoPaterno.equals(alumno.apellidoPaterno) : alumno.apellidoPaterno != null)
            return false;
        if (apellidoMaterno != null ? !apellidoMaterno.equals(alumno.apellidoMaterno) : alumno.apellidoMaterno != null)
            return false;
        return !(matricula != null ? !matricula.equals(alumno.matricula) : alumno.matricula != null);

    }

    @Override
    public int hashCode() {
        int result = idAlumno;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellidoPaterno != null ? apellidoPaterno.hashCode() : 0);
        result = 31 * result + (apellidoMaterno != null ? apellidoMaterno.hashCode() : 0);
        result = 31 * result + (matricula != null ? matricula.hashCode() : 0);
        return result;
    }
}
