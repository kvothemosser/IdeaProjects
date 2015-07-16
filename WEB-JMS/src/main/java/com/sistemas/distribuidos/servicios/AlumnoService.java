package com.sistemas.distribuidos.servicios;

import com.sistemas.distribuidos.dao.AlumnoDAO;
import com.sistemas.distribuidos.entidad.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Moises Tapia Tellez on 12/07/2015.
 */
@Service("alumnoService")
@Transactional
public class AlumnoService {

    @Autowired
    private AlumnoDAO alumnoDAO;

    public void saveAlumno(Alumno alumno){
        alumnoDAO.saveAlumno(alumno);
    }

    public void updateAlumno(Alumno alumno){
        alumnoDAO.updateAlumno(alumno);
    }

    public List<Alumno> findAll(){
        return alumnoDAO.findAll();
    }

    public List<Alumno> findByMatricula(String matricula){
        return alumnoDAO.findByMatricula(matricula);
    }

    public void deleteByMatricula(String matricula){
        alumnoDAO.deleteByMatricula(matricula);
    }
}
