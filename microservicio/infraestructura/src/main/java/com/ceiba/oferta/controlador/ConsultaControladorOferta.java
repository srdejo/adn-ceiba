package com.ceiba.oferta.controlador;

import com.ceiba.oferta.consulta.ManejadorListarOfertas;
import com.ceiba.oferta.modelo.dto.DtoOferta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ofertas")
@Api(tags = {"Controlador consulta oferta"})
public class ConsultaControladorOferta {

    private final ManejadorListarOfertas manejadorListarOfertas;

    public ConsultaControladorOferta(ManejadorListarOfertas manejadorListarOfertas) {
        this.manejadorListarOfertas = manejadorListarOfertas;
    }

    @GetMapping
    @ApiOperation("Listar Usuarios")
    public List<DtoOferta> listar() {
        return this.manejadorListarOfertas.ejecutar();
    }

}
