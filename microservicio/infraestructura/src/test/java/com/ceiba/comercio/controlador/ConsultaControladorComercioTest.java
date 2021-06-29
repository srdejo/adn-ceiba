package com.ceiba.comercio.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.comercio.consulta.ManejadorListarComercios;
import com.ceiba.comercio.controlador.ConsultaControladorComercio;
import com.ceiba.comercio.modelo.dto.DtoComercio;
import com.ceiba.comercio.servicio.testdatabuilder.DtoComercioTestDataBuilder;
import com.ceiba.detalle_pedido.modelo.dto.DtoDetallePedido;
import com.ceiba.detalle_pedido.testdatabuilder.DtoDetallePedidoTestDataBuilder;
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

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ConsultaControladorComercio.class)
public class ConsultaControladorComercioTest {

    @Autowired
    private MockMvc mocMvc;

    @MockBean
    private ManejadorListarComercios manejadorListarComercios;

    @Test
    public void listar() throws Exception {
        // arrange
        List<DtoComercio> dtoComercios = new ArrayList<>();
        dtoComercios.add(new DtoComercioTestDataBuilder().build());
        dtoComercios.add(new DtoComercioTestDataBuilder().build());
        Mockito.when(manejadorListarComercios.ejecutar()).thenReturn(dtoComercios);
        // act - assert
        mocMvc.perform(get("/comercios")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nombre", notNullValue()));
    }


}
