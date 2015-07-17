package com.sistemas.distribuidos.dao;

import com.sistemas.distribuidos.entidad.Usuario;

import java.util.List;

/**
 * Created by mtapiat on 16/07/2015.
 */
public interface UsuarioDAO {

    void saveUsuario(Usuario usuario) throws Exception;

    void updateUsuario(Usuario usuario) throws Exception;

    List<Usuario> findAll() throws Exception;

    Usuario findByUsername(String username) throws Exception;

    void deleteByUsername(String username) throws Exception;
}
