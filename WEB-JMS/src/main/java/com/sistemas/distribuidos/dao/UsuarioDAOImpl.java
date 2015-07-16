package com.sistemas.distribuidos.dao;

import com.sistemas.distribuidos.entidad.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mtapiat on 16/07/2015.
 */
@Repository("usuarioDAO")
public class UsuarioDAOImpl extends AbstractDAO implements UsuarioDAO {

    @Override
    public void saveUsuario(Usuario usuario) {
        persist(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        getSession().update(usuario);
    }

    @Override
    public List<Usuario> findAll() {
        Criteria criteria = getSession().createCriteria(Usuario.class);
        return (List<Usuario>) criteria.list();
    }

    @Override
    public List<Usuario> findByUsername(String username) {
        Criteria criteria = getSession().createCriteria(Usuario.class);
        criteria.add(Restrictions.eq("username", username));
        return (List<Usuario>) criteria.list();
    }

    @Override
    public void deleteByUsername(String username) {
        Query query = getSession().createSQLQuery("delete from Usuario where username = :username");
        query.setString("username", username);
        query.executeUpdate();
    }
}
