package com.ceiba.producto.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.cliente.controlador.ConsultaControladorCliente;
import com.ceiba.producto.consulta.ManejadorListarProductos;
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
@WebMvcTest(ConsultaControladorProducto.class)
public class ConsultaControladorProductoTest {

    @Autowired
    private MockMvc mocMvc;

    @MockBean
    private ManejadorListarProductos manejadorListarProductos;

    @Test
    public void listar() throws Exception {
        // arrange
        List<DtoProducto> dtoProductoList = new ArrayList<>();
        dtoProductoList.add(new DtoProductoTestDataBuilder().build());
        dtoProductoList.add(new DtoProductoTestDataBuilder().build());
        Mockito.when(manejadorListarProductos.ejecutar()).thenReturn(dtoProductoList);
        // act - assert
        mocMvc.perform(get("/productos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nombre", notNullValue()))
                .andExpect(jsonPath("$[0].descripcion", notNullValue()))
                .andExpect(jsonPath("$[0].valor", notNullValue()));
    }


}
