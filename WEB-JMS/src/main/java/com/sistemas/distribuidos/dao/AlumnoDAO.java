package com.sistemas.distribuidos.dao;

import com.sistemas.distribuidos.entidad.Alumno;

import java.util.List;

/**
 * Created by Moises Tapia Tellez on 12/07/2015.
 */
public interface AlumnoDAO {

    void saveAlumno(Alumno alumno) throws Exception;

    void updateAlumno(Alumno alumno) throws Exception;

    List<Alumno> findAll() throws Exception;

    List<Alumno> findByMatricula(String matricula) throws Exception;

    void deleteByMatricula(String matricula) throws Exception;
}
