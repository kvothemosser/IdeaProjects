package com.sistemas.distribuidos.dao;

import com.sistemas.distribuidos.entidad.Alumno;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Moises Tapia Tellez on 12/07/2015.
 */
@Repository("alumnoDAO")
public class AlumnoDAOImpl extends AbstractDAO implements AlumnoDAO {

    @Override
    public void saveAlumno(Alumno alumno) throws Exception {
        persist(alumno);
    }

    @Override
    public void updateAlumno(Alumno alumno) throws Exception {
        getSession().update(alumno);
    }

    @Override
    public List<Alumno> findAll() throws Exception {
        Criteria criteria = getSession().createCriteria(Alumno.class);
        return (List<Alumno>) criteria.list();
    }

    @Override
    public List<Alumno> findByMatricula(String matricula) throws Exception {
        Criteria criteria = getSession().createCriteria(Alumno.class);
        criteria.add(Restrictions.eq("matricula",matricula));
        return (List<Alumno>) criteria.list();
    }

    @Override
    public void deleteByMatricula(String matricula) {
        Query query = getSession().createSQLQuery("delete from Alumno where matricula = :matricula");
        query.setString("matricula", matricula);
        query.executeUpdate();
    }
}
