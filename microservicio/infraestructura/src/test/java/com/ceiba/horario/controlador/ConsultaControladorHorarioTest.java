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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
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

    @Test
    public void listar() throws Exception {
        // arrange
        List<DtoHorario> dtoHorarios = new ArrayList<>();
        dtoHorarios.add(new DtoHorarioTestDataBuilder().horaFinalMayor().build());
        dtoHorarios.add(new DtoHorarioTestDataBuilder().horaFinalMayor().build());
        Mockito.when(manejadorListarHorarios.ejecutar()).thenReturn(dtoHorarios);
        // act - assert
        mocMvc.perform(get("/horarios")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", notNullValue()))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].horaInicial", notNullValue()))
                .andExpect(jsonPath("$[0].horaFinal", notNullValue()))
                .andExpect(jsonPath("$[0].idComercio", notNullValue()))
                .andExpect(jsonPath("$[0].diaSemana", notNullValue()));
    }


}
