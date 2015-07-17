package com.sistemas.distribuidos.carga;

import com.sistemas.distribuidos.constante.Nombre;
import com.sistemas.distribuidos.entidad.Alumno;
import com.sistemas.distribuidos.entidad.Usuario;
import com.sistemas.distribuidos.logger.Log4jWrapper;
import com.sistemas.distribuidos.servicios.AlumnoService;
import com.sistemas.distribuidos.servicios.UsuarioService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by Moises Tapia Tellez on 16/07/2015.
 */
public class CargaInicial extends HttpServlet {

    private static final Logger LOGGER = Log4jWrapper.getLog(CargaInicial.class);

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AlumnoService alumnoService;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
        actualizarParametros();
    }

    public void actualizarParametros() {
        DateFormat df = new SimpleDateFormat("yyMMddHHmmss");
        int SIZE = 99;
        Random RANDOM = new Random();
        try {
            Usuario u = new Usuario();
            u.setNombre("ADMIN");
            u.setApellidoPaterno("ADMIN");
            u.setApellidoMaterno("ADMIN");
            u.setUsuario("admin");
            u.setPassword("admin");
            usuarioService.saveUsuario(u);
            for (int i = 0; i < 25; i++) {
                Calendar c = Calendar.getInstance();
                c.add(Calendar.DAY_OF_YEAR, RANDOM.nextInt());
                c.add(Calendar.SECOND, RANDOM.nextInt());
                Date today = c.getTime();
                Alumno alumno = new Alumno(Nombre.randomNombre().getNombre(),
                        Nombre.randomNombre().getNombre(),
                        Nombre.randomNombre().getNombre(),
                        df.format(today));
                alumnoService.saveAlumno(alumno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
