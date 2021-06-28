package com.ceiba.comercio.controlador;

import com.ceiba.comercio.consulta.ManejadorListarComercios;
import com.ceiba.comercio.modelo.dto.DtoComercio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comercios")
@Api(tags = {"Controlador consulta comercio"})
public class ConsultaControladorComercio {

    private final ManejadorListarComercios manejadorListarComercios;

    public ConsultaControladorComercio(ManejadorListarComercios manejadorListarComercios) {
        this.manejadorListarComercios = manejadorListarComercios;
    }

    @GetMapping
    @ApiOperation("Listar Usuarios")
    public List<DtoComercio> listar() {
        return this.manejadorListarComercios.ejecutar();
    }

}
