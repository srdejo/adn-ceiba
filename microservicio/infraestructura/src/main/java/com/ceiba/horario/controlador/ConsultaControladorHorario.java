package com.ceiba.horario.controlador;

import com.ceiba.horario.consulta.ManejadorListarHorarios;
import com.ceiba.horario.modelo.dto.DtoHorario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/horarios")
@Api(tags = {"Controlador consulta horario"})
public class ConsultaControladorHorario {

    private final ManejadorListarHorarios manejadorListarHorarios;

    public ConsultaControladorHorario(ManejadorListarHorarios manejadorListarHorarios) {
        this.manejadorListarHorarios = manejadorListarHorarios;
    }

    @GetMapping
    @ApiOperation("Listar horarios")
    public List<DtoHorario> listar() {
        return this.manejadorListarHorarios.ejecutar();
    }

}
