package com.sistemas.distribuidos.carga;

import com.sistemas.distribuidos.dao.UsuarioDAO;
import com.sistemas.distribuidos.entidad.Usuario;
import com.sistemas.distribuidos.logger.Log4jWrapper;
import com.sistemas.distribuidos.servicios.UsuarioService;
import org.apache.log4j.Logger;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Moises Tapia Tellez on 16/07/2015.
 */
public class CargaInicial extends HttpServlet {

    private static final Logger LOGGER = Log4jWrapper.getLog(CargaInicial.class);

    @Autowired
    private UsuarioService usuarioService;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
        actualizarParametros();
    }

    public void actualizarParametros() {
        System.out.println("---------------------------------------------------------------------------------");
        try {
            Usuario u = new Usuario();
            u.setNombre("ADMIN");
            u.setApellidoPaterno("ADMIN");
            u.setApellidoMaterno("ADMIN");
            u.setUsuario("admin");
            u.setPassword("admin");
            usuarioService.saveUsuario(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("---------------------------------------------------------------------------------");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        actualizarParametros();

        PrintWriter writer = response.getWriter();
        writer.println("<?xml version='1.0' encoding='UTF-8' ?>\n" +
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\"><head>\n" +
                "            <meta http-equiv=\"x-ua-compatible\" content=\"IE=edge\" />\n" +
                "            <meta content=\"text/html; charset=UTF-8\" http-equiv=\"content-type\" />\n" +
                "        <title></title></head><body>");
        writer.println("HOLA");
        writer.println("</body></html>");
    }
}
