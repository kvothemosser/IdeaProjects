package com.sistemas.distribuidos.dao;

import com.sistemas.distribuidos.entidad.Usuario;

import java.util.List;

/**
 * Created by mtapiat on 16/07/2015.
 */
public interface UsuarioDAO {

    void saveUsuario(Usuario usuario);

    void updateUsuario(Usuario usuario);

    List<Usuario> findAll();

    List<Usuario> findByUsername(String username);

    void deleteByUsername(String username);
}
