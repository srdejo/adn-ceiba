package com.ceiba.cliente.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.cliente.testdatabuilder.ComandoClienteTestDataBuilder;
import com.ceiba.cliente.comando.ComandoCliente;
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
@WebMvcTest(ComandoControladorCliente.class)
public class ComandoControladorClienteTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoCliente cliente = new ComandoClienteTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}"));
    }

    @Test
    public void actualizar() throws Exception{
        // arrange
        Long id = 2L;
        ComandoCliente cliente = new ComandoClienteTestDataBuilder().build();

        // act - assert
        mocMvc.perform(put("/clientes/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk());
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 2L;

        // act - assert
        mocMvc.perform(delete("/clientes/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
