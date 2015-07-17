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

    private String matriculaBorrar;

    @PostConstruct
    void init(){
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
            if (validarRegistro()) {
                alumnoService.saveAlumno(alumno);
                this.addFacesInfo("El Alumno " + this.alumno.getNombre() + " " +
                        this.alumno.getApellidoPaterno() + this.alumno.getApellidoMaterno() +
                        " ha sido registrado con exito.");
            }
        } catch (Exception e) {
            this.addFacesError("No se pudo guardar el Alumno");
            LOGGER.error("No se pudo guardar el Alumno", e);
        }
        obtenerTodos();
        alumno = new Alumno();
        return "";
    }

    private Boolean validarRegistro() {
        Boolean validacion = Boolean.FALSE;
        if ("".equals(alumno.getNombre())) {
            this.addFacesError("Debe ingresar el nombre del alumno");
        } else if ("".equals(alumno.getApellidoPaterno())) {
            this.addFacesError("Debe ingresar el primer apellido del alumno");
        } else if ("".equals(alumno.getMatricula())) {
            this.addFacesError("Debe ingresar la matricula del alumno");
        } else {
            validacion = Boolean.TRUE;
        }
        return validacion;
    }

    public void obtenerTodos(){
        try {
            setAlumnos(alumnoService.findAll());
        } catch (Exception e) {
            this.addFacesError("No se pudo cargar la lista de Alumnos");
            LOGGER.error("No se pudo cargar la lista de Alumnos", e);
        }
    }

    public void borrarPorMatricula() {
        if (matriculaBorrar != null && !matriculaBorrar.isEmpty()) {
            try {
                alumnoService.deleteByMatricula(matriculaBorrar);
                obtenerTodos();
                matriculaBorrar = "";
            } catch (Exception e) {
                LOGGER.error("Tiene poderes de superusuario, no se puede borrar", e);
                addFacesError("Tiene poderes de superusuario, no se puede borrar");
            }
        } else {
            this.addFacesInfo("Se necesita una matricula para borrar al Alumno");
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

    public String getMatriculaBorrar() {
        return matriculaBorrar;
    }

    public void setMatriculaBorrar(String matriculaBorrar) {
        this.matriculaBorrar = matriculaBorrar;
    }
}
