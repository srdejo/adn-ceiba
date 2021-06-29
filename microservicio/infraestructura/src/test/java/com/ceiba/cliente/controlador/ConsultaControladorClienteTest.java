package com.ceiba.cliente.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.cliente.consulta.ManejadorListarClientes;
import com.ceiba.cliente.controlador.ConsultaControladorCliente;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.servicio.testdatabuilder.DtoClienteTestDataBuilder;
import com.ceiba.comercio.modelo.dto.DtoComercio;
import com.ceiba.comercio.servicio.testdatabuilder.DtoComercioTestDataBuilder;
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
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ConsultaControladorCliente.class)
public class ConsultaControladorClienteTest {

    @Autowired
    private MockMvc mocMvc;

    @MockBean
    private ManejadorListarClientes manejadorListarClientes;

    @Test
    public void listar() throws Exception {
        // arrange
        List<DtoCliente> dtoClientes = new ArrayList<>();
        dtoClientes.add(new DtoClienteTestDataBuilder().build());
        dtoClientes.add(new DtoClienteTestDataBuilder().build());
        Mockito.when(manejadorListarClientes.ejecutar()).thenReturn(dtoClientes);
        // act - assert
        mocMvc.perform(get("/clientes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nombre", notNullValue()))
                .andExpect(jsonPath("$[0].celular", notNullValue()))
                .andExpect(jsonPath("$[0].direccion", notNullValue()));
    }


}
