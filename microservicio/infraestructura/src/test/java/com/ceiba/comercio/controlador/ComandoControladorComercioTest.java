package com.ceiba.comercio.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.comercio.comando.ComandoComercio;
import com.ceiba.comercio.controlador.ComandoControladorComercio;
import com.ceiba.comercio.testdatabuilder.ComandoComercioTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorComercio.class)
public class ComandoControladorComercioTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoComercio comercio = new ComandoComercioTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/comercios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comercio)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}"));
    }

    @Test
    public void actualizar() throws Exception{
        // arrange
        Long id = 2L;
        ComandoComercio comercio = new ComandoComercioTestDataBuilder().build();

        // act - assert
        mocMvc.perform(put("/comercios/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comercio)))
                .andExpect(status().isOk());
    }

}
