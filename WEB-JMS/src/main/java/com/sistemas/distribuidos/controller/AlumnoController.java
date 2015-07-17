package com.sistemas.distribuidos.controller;

import com.sistemas.distribuidos.entidad.Alumno;
import com.sistemas.distribuidos.servicios.AlumnoService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by Moises Tapia Tellez on 12/07/2015.
 */
@ManagedBean(name = "alumnoController")
@SessionScoped
public class AlumnoController extends BaseController {
    @ManagedProperty("#{alumnoService}")
    private AlumnoService alumnoService;

    private Alumno alumno;

    private List<Alumno> alumnos;


    @PostConstruct
    void init(){
        Alumno a = new Alumno();
        a.setNombre("Moises");
        a.setApellidoPaterno("Tapia");
        a.setApellidoMaterno("Tellez");
        a.setMatricula("2043");
        try {
            alumnoService.saveAlumno(a);
        } catch (Exception e) {
            this.LOGGER.error("No se pudo inicializar un alumno", e);
        }
        this.alumno = new Alumno();
        try {
            this.setAlumnos(alumnoService.findAll());
        } catch (Exception e) {
            this.addFacesError("No se pudo cargar la lista de alumnos");
            LOGGER.error("No se pudo cargar la lista de alumnos", e);
        }
    }

    public String registrar(){
        try {
            alumnoService.saveAlumno(alumno);
            this.addFacesInfo("El Alumno " + this.alumno.getNombre() + " " +
                    this.alumno.getApellidoPaterno() + this.alumno.getApellidoMaterno() +
                    " ha sido registrado con exito.");
        } catch (Exception e) {
            this.addFacesError("No se pudo guardar el Alumno");
            LOGGER.error("No se pudo guardar el Alumno", e);
        }
        obtenerTodos();
        alumno = new Alumno();
        return "";
    }

    public void obtenerTodos(){
        try {
            setAlumnos(alumnoService.findAll());
        } catch (Exception e) {
            this.addFacesError("No se pudo cargar la lista de Alumnos");
            LOGGER.error("No se pudo cargar la lista de Alumnos", e);
        }
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
