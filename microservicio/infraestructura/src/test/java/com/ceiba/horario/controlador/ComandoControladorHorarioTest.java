package com.ceiba.horario.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.horario.comando.ComandoHorario;
import com.ceiba.horario.testdatabuilder.ComandoHorarioTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorHorario.class)
public class ComandoControladorHorarioTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @Test
    @Order(1)
    public void crear() throws Exception {
        // arrange
        ComandoHorario horario = new ComandoHorarioTestDataBuilder().horaFinalMayor().build();

        // act - assert
        mocMvc.perform(post("/horarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(horario)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}"));;
    }

    @Test
    @Order(2)
    public void actualizar() throws Exception {
        // arrange
        Long id = 3L;
        ComandoHorario horario = new ComandoHorarioTestDataBuilder().horaFinalMayor().build();

        // act - assert
        mocMvc.perform(put("/horarios/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(horario)))
                .andExpect(status().isOk());
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 3L;

        // act - assert
        mocMvc.perform(delete("/horarios/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
