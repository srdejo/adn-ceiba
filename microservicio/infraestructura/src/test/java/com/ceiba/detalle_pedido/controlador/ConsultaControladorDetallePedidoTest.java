package com.ceiba.detalle_pedido.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.detalle_pedido.consulta.ManejadorListarDetallePedidos;
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
import java.util.Random;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorDetallePedido.class)
public class ConsultaControladorDetallePedidoTest {

    @Autowired
    private MockMvc mocMvc;

    @MockBean
    private ManejadorListarDetallePedidos manejadorListarDetallePedidos;

    @Test
    public void listar() throws Exception {
        // arrange
        Random random = new Random();
        Long idPedido = random.nextLong();
        List<DtoDetallePedido> dtoDetallePedidos = new ArrayList<>();
        dtoDetallePedidos.add(new DtoDetallePedidoTestDataBuilder().conIdPedido(idPedido).build());
        dtoDetallePedidos.add(new DtoDetallePedidoTestDataBuilder().conIdPedido(idPedido).build());
        Mockito.when(manejadorListarDetallePedidos.ejecutar(Mockito.anyLong())).thenReturn(dtoDetallePedidos);

        // act - assert
        mocMvc.perform(get("/detalle-pedidos/{idPedido}", idPedido)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].idPedido", notNullValue()))
                .andExpect(jsonPath("$[0].cantidad", notNullValue()))
                .andExpect(jsonPath("$[0].valorUnidad", notNullValue()));
    }


}
