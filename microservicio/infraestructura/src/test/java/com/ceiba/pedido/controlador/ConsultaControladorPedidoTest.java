package com.ceiba.pedido.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.pedido.consulta.ManejadorListarPedidos;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.testdatabuilder.DtoPedidoTestDataBuilder;
import com.ceiba.producto.modelo.dto.DtoProducto;
import com.ceiba.producto.testdatabuilder.DtoProductoTestDataBuilder;
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
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ConsultaControladorPedido.class)
public class ConsultaControladorPedidoTest {

    @Autowired
    private MockMvc mocMvc;

    @MockBean
    private ManejadorListarPedidos manejadorListarPedidos;

    @Test
    public void listar() throws Exception {
        // arrange
        List<DtoPedido> dtoPedidos = new ArrayList<>();
        dtoPedidos.add(new DtoPedidoTestDataBuilder().build());
        dtoPedidos.add(new DtoPedidoTestDataBuilder().build());
        Mockito.when(manejadorListarPedidos.ejecutar()).thenReturn(dtoPedidos);
        // act - assert
        mocMvc.perform(get("/pedidos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].idCliente", notNullValue()))
                .andExpect(jsonPath("$[0].hora", notNullValue()))
                .andExpect(jsonPath("$[0].valorDomicilio", notNullValue()));
    }


}
