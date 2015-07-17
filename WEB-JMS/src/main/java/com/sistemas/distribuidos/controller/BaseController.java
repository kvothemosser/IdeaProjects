package com.sistemas.distribuidos.controller;

import com.sistemas.distribuidos.constante.ConstanteLiteral;
import com.sistemas.distribuidos.logger.Log4jWrapper;
import org.apache.log4j.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by mtapiat on 16/07/2015.
 */
public class BaseController {

    public static final Logger LOGGER = Log4jWrapper.getLog(BaseController.class);

    public void addFacesWarning(String summary) {
        this.addFacesWarning(summary, ConstanteLiteral.CADENA_VACIA);
    }

    public void addFacesError(String summary) {
        this.addFacesError(summary, ConstanteLiteral.CADENA_VACIA);
    }

    public void addFacesInfo(String summary) {
        this.addFacesInfo(summary, ConstanteLiteral.CADENA_VACIA);
    }

    public void addFacesInfo(List<String> summary) {
        for (String cadena : summary) {
            this.addFacesInfo(cadena);
        }
    }

    public void addFacesError(List<String> summary) {
        for (String cadena : summary) {
            this.addFacesError(cadena);
        }
    }

    public void addFacesWarning(String summary, String detail) {
        this.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, summary, detail));
    }

    public void addFacesError(String summary, String detail) {
        this.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail));
    }

    public void addFacesInfo(String summary, String detail) {
        this.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));
    }

    public void addMessage(String arg, FacesMessage fm) {
        if (this.getFacesContext() != null) {
            this.getFacesContext().addMessage(arg, fm);
        }
    }

    public FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    protected HttpServletRequest getRequest() {
        return (HttpServletRequest) getFacesContext().getExternalContext().getRequest();
    }

    protected HttpSession getSession() {
        return getRequest().getSession(false);
    }

    public ExternalContext getExternalContext() {
        return getFacesContext().getExternalContext();
    }
}
