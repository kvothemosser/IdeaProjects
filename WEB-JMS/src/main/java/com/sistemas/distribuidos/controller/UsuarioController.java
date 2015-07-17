package com.sistemas.distribuidos.controller;

import com.sistemas.distribuidos.entidad.Usuario;
import com.sistemas.distribuidos.servicios.UsuarioService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 * Created by mtapiat on 16/07/2015.
 */
@ManagedBean(name = "usuarioController")
@SessionScoped
public class UsuarioController extends BaseController {

    @ManagedProperty("#{usuarioService}")
    private UsuarioService usuarioService;

    private Usuario usuario;

    @PostConstruct
    void init() {
        setUsuario(new Usuario());
    }

    public String autentificar() {
        String url = "";
        try {
            Usuario usuarioEncontrado = usuarioService.findByUsername(getUsuario().getUsuario());
            if (usuarioEncontrado != null && usuarioEncontrado.getPassword().equals(getUsuario().getPassword())) {
                url = "pages/registro-alumno?faces-redirect=true";
            } else {
                this.addFacesInfo("Usuario/Password incorrectos");
            }
        } catch (Exception e) {
            this.addFacesError("No se pudo validar Usuario/Password");
            LOGGER.error("No se pudo validar Usuario/Password", e);
        }
        return url;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
}
