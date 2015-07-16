package com.sistemas.distribuidos.servicios;

import com.sistemas.distribuidos.dao.UsuarioDAO;
import com.sistemas.distribuidos.entidad.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mtapiat on 16/07/2015.
 */
@Service("usuarioService")
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioDAO usuarioDAO;

    public void saveUsuario(Usuario usuario) {
        usuarioDAO.saveUsuario(usuario);
    }

    public void updateUsuario(Usuario usuario) {
        usuarioDAO.updateUsuario(usuario);
    }

    public List<Usuario> findAll() {
        return usuarioDAO.findAll();
    }

    public List<Usuario> findByUsername(String username) {
        return usuarioDAO.findByUsername(username);
    }

    public void deleteByUsername(String username) {
        usuarioDAO.deleteByUsername(username);
    }
}
