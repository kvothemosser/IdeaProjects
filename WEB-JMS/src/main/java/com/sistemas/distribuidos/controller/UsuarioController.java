package com.sistemas.distribuidos.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by mtapiat on 16/07/2015.
 */
@ManagedBean(name = "usuarioController")
@SessionScoped
public class UsuarioController {


    public String autentificar() {
        return "pages/registro-alumno?faces-redirect=true";
    }
}
