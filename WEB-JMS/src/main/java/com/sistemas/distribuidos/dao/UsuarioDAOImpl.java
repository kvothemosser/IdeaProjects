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
    public void saveUsuario(Usuario usuario) throws Exception {
        persist(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) throws Exception {
        getSession().update(usuario);
    }

    @Override
    public List<Usuario> findAll() throws Exception {
        Criteria criteria = getSession().createCriteria(Usuario.class);
        return (List<Usuario>) criteria.list();
    }

    @Override
    public Usuario findByUsername(String usuario) throws Exception {
        Criteria criteria = getSession().createCriteria(Usuario.class);
        criteria.add(Restrictions.eq("usuario", usuario));
        return (Usuario) criteria.uniqueResult();
    }

    @Override
    public void deleteByUsername(String usuario) throws Exception {
        Query query = getSession().createSQLQuery("delete from Usuario where usuario = :usuario");
        query.setString("usuario", usuario);
        query.executeUpdate();
    }
}
