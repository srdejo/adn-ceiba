package com.ceiba.oferta.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.oferta.consulta.ManejadorListarOfertas;
import com.ceiba.oferta.modelo.dto.DtoOferta;
import com.ceiba.oferta.testdatabuilder.DtoOfertaTestDataBuilder;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.testdatabuilder.DtoPedidoTestDataBuilder;
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
@WebMvcTest(ConsultaControladorOferta.class)
public class ConsultaControladorOfertaTest {

    @Autowired
    private MockMvc mocMvc;

    @MockBean
    private ManejadorListarOfertas manejadorListarOfertas;

    @Test
    public void listar() throws Exception {
        // arrange
        List<DtoOferta> dtoOfertas = new ArrayList<>();
        dtoOfertas.add(new DtoOfertaTestDataBuilder().horaFinalMayor().build());
        dtoOfertas.add(new DtoOfertaTestDataBuilder().horaFinalMayor().build());
        Mockito.when(manejadorListarOfertas.ejecutar()).thenReturn(dtoOfertas);
        // act - assert
        mocMvc.perform(get("/ofertas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].horaInicial", notNullValue()))
                .andExpect(jsonPath("$[0].horaFinal", notNullValue()))
                .andExpect(jsonPath("$[0].dia", notNullValue()));
    }


}
