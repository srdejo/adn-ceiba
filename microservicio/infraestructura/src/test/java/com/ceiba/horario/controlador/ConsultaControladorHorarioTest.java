package com.ceiba.horario.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.horario.consulta.ManejadorListarHorarios;
import com.ceiba.horario.modelo.dto.DtoHorario;
import com.ceiba.horario.testdatabuilder.DtoHorarioTestDataBuilder;
import com.ceiba.oferta.testdatabuilder.DtoOfertaTestDataBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorHorario.class)
public class ConsultaControladorHorarioTest {

    @Autowired
    private MockMvc mocMvc;

    @MockBean
    private ManejadorListarHorarios manejadorListarHorarios;

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @Test
    public void listar() throws Exception {
        // arrange
        // act - assert
        mocMvc.perform(get("/horarios")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
