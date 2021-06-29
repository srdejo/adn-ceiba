package com.ceiba.detalle_pedido.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.detalle_pedido.comando.ComandoDetallePedido;
import com.ceiba.detalle_pedido.testdatabuilder.ComandoDetallePedidoTestDataBuilder;
import com.ceiba.horario.comando.ComandoHorario;
import com.ceiba.horario.controlador.ComandoControladorHorario;
import com.ceiba.horario.testdatabuilder.ComandoHorarioTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

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

    @Autowired
    private ComandoControladorHorario comandoControladorHorario;

    @Test
    @Order(1)
    public void crear() throws Exception {
        // arrange
        ComandoHorario horario = new ComandoHorarioTestDataBuilder().horaFinalMayor().build();
        comandoControladorHorario.crear(horario);

        ComandoDetallePedido detallePedido = new ComandoDetallePedidoTestDataBuilder()
                .conIdPedido(Long.valueOf(1))
                .conIdProducto(Long.valueOf(1)).build();
        // act - assert
        mocMvc.perform(post("/detalle-pedidos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(detallePedido)))
                .andExpect(status().isOk());
    }

    @Test
    @Order(2)
    public void actualizar() throws Exception {
        // arrange
        ComandoHorario horario = new ComandoHorarioTestDataBuilder().horaFinalMayor().build();
        comandoControladorHorario.crear(horario);
        
        Long id = Long.valueOf(1);
        ComandoDetallePedido detallePedido = new ComandoDetallePedidoTestDataBuilder()
                .conIdPedido(id)
                .conIdProducto(id).build();

        // act - assert
        mocMvc.perform(put("/detalle-pedidos/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(detallePedido)))
                .andExpect(status().isOk());
    }

    @Test
    @Order(3)
    public void eliminar() throws Exception {
        // arrange
        Long id = Long.valueOf(1);

        // act - assert
        mocMvc.perform(delete("/detalle-pedidos/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
