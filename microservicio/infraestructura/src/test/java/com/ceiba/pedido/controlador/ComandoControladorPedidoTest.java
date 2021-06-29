package com.ceiba.pedido.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.comando.manejador.ManejadorActualizarPedido;
import com.ceiba.pedido.modelo.enums.EstadoPedido;
import com.ceiba.pedido.servicio.ServicioActualizarPedido;
import com.ceiba.pedido.servicio.ServicioCrearPedido;
import com.ceiba.pedido.testdatabuilder.ComandoPedidoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorPedido.class)
public class ComandoControladorPedidoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @MockBean
    private ServicioCrearPedido servicioCrearPedido;


    @MockBean
    private ServicioActualizarPedido servicioActualizarPedido;

    @Test
    public void crear() throws Exception {
        // arrange
        ComandoPedido pedido = new ComandoPedidoTestDataBuilder().build();
        Mockito.when(servicioCrearPedido.ejecutar(Mockito.any())).thenReturn(Mockito.anyLong());

        // act - assert
        mocMvc.perform(post("/pedidos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(pedido)))
                .andExpect(status().isOk());
    }

    @Test
    public void actualizar() throws Exception {
        // arrange
        Long id = 2L;
        ComandoPedido pedido = new ComandoPedidoTestDataBuilder().conEstado(EstadoPedido.DESPACHADO).build();

        Mockito.doNothing().when(servicioActualizarPedido).ejecutar(Mockito.any());
        // act - assert
        mocMvc.perform(put("/pedidos/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(pedido)))
                .andExpect(status().isOk());
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 2L;

        // act - assert
        mocMvc.perform(delete("/pedidos/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
