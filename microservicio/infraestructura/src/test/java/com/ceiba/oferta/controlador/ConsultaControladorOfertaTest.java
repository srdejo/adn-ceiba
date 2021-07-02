package com.ceiba.oferta.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.oferta.consulta.ManejadorListarOfertas;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

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

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @Test
    public void listar() throws Exception {
        // arrange
        // act - assert
        mocMvc.perform(get("/ofertas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
