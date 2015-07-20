package com.sistemas.distribuidos.servicios;

import com.sistemas.distribuidos.entidad.Alumno;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created by mtapiat on 20/07/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/applicationContext.xml")
public class AlumnoServiceTest {
    @Autowired
    private AlumnoService alumnoService;

    @Test
    public void test() {
        List<Alumno> alumnoList = null;
        try {
            alumnoList = alumnoService.findAll();
        } catch (Exception e) {

        }
        assertThat(alumnoList, is(notNullValue()));
    }
}
