package com.ceiba.detalle_pedido.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.ComandoRespuesta;
import com.ceiba.detalle_pedido.comando.ComandoDetallePedido;
import com.ceiba.detalle_pedido.comando.manejador.ManejadorActualizarDetallePedido;
import com.ceiba.detalle_pedido.comando.manejador.ManejadorCrearDetallePedido;
import com.ceiba.detalle_pedido.servicio.ServicioActualizarDetallePedido;
import com.ceiba.detalle_pedido.servicio.ServicioCrearDetallePedido;
import com.ceiba.detalle_pedido.testdatabuilder.ComandoDetallePedidoTestDataBuilder;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
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

import java.time.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorDetallePedido.class)
public class ComandoControladorDetallePedidoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @MockBean
    private ServicioCrearDetallePedido servicioCrearDetallePedido;

    @MockBean
    private ServicioActualizarDetallePedido servicioActualizarDetallePedido;

    @Test
    public void crear() throws Exception {
        // arrange
        RepositorioHorario repositorioHorario = Mockito.mock(RepositorioHorario.class);
        ComandoDetallePedido detallePedido = new ComandoDetallePedidoTestDataBuilder()
                .conIdPedido(1L)
                .conIdProducto(10L).build();

        Mockito.when(servicioCrearDetallePedido.ejecutar(Mockito.any())).thenReturn(Mockito.anyLong());
        // act - assert
        mocMvc.perform(post("/detalle-pedidos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(detallePedido)))
                .andExpect(status().isOk());
    }

    @Test
    public void actualizar() throws Exception {
        // arrange
        Long id = 1L;
        ComandoDetallePedido detallePedido = new ComandoDetallePedidoTestDataBuilder()
                .conIdPedido(1L)
                .conIdProducto(1L).build();

        Mockito.doNothing().when(servicioActualizarDetallePedido).ejecutar(Mockito.any());
        // act - assert
        mocMvc.perform(put("/detalle-pedidos/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(detallePedido)))
                .andExpect(status().isOk());
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 1L;

        // act - assert
        mocMvc.perform(delete("/detalle-pedidos/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
