package com.sistemas.distribuidos.dao;

import com.sistemas.distribuidos.entidad.Alumno;

import java.util.List;

/**
 * Created by Moises Tapia Tellez on 12/07/2015.
 */
public interface AlumnoDAO {

    void saveAlumno(Alumno alumno);

    void updateAlumno(Alumno alumno);

    List<Alumno> findAll();

    List<Alumno> findByMatricula(String matricula);

    void deleteByMatricula(String matricula);
}
