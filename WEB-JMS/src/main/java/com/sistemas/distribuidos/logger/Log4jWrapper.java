package com.sistemas.distribuidos.logger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


/**
 * Wrapper para los logs. Lee el archivo configuracion.properties que se debe encontar en el modulo EJB del proyecto.
 * <li><b>ruta.log4j</b>=/siat/log4j/${appLogFilename}.properties</li>
 *
 * @author Moises Tapia Tellez.
 */
public final class Log4jWrapper {

    private static final Logger LOGGER = LogManager.getLogger(Log4jWrapper.class);

    static {
        try {
            DOMConfigurator.configure("/application.properties");
        } catch (Exception e) {
            LOGGER.warn("No se pudo cargar el archivo externo de configuracion del log. Se usara el default", e);
        }
    }

    /**
     * Constructor por default.
     */
    private Log4jWrapper() {
    }

    /**
     * Devuelve el log.
     *
     * @param logger
     * @return
     */
    public static Logger getLog(Class logger) {
        return LogManager.getLogger(logger);
    }
}
