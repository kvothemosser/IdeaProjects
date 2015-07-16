package com.sistemas.distribuidos.controller;

import com.sistemas.distribuidos.entidad.Alumno;
import com.sistemas.distribuidos.servicios.AlumnoService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by Moises Tapia Tellez on 12/07/2015.
 */
@ManagedBean(name = "alumnoController")
@SessionScoped
public class AlumnoController {
    @ManagedProperty("#{alumnoService}")
    private AlumnoService alumnoService;

    private Alumno alumno;

    private List<Alumno> alumnos;


    @PostConstruct
    void init(){
        this.alumno = new Alumno();
        this.setAlumnos(alumnoService.findAll());
    }

    public String registrar(){
        alumnoService.saveAlumno(alumno);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("El Alumno " + this.alumno.getNombre() + " " +
                        this.alumno.getApellidoPaterno() + this.alumno.getApellidoMaterno() +
                        " ha sido registrado con exito."));
        obtenerTodos();
        alumno = new Alumno();
        return "";
    }

    public void obtenerTodos(){
        setAlumnos(alumnoService.findAll());
    }

    public AlumnoService getAlumnoService() {
        return alumnoService;
    }

    public void setAlumnoService(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
