package com.ceiba.pedido.controlador;

import com.ceiba.pedido.consulta.ManejadorListarPedidos;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.servicio.ServicioConsultarPedido;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@Api(tags = {"Controlador consulta pedido"})
public class ConsultaControladorPedido {

    private final ManejadorListarPedidos manejadorListarPedidos;
    private final ServicioConsultarPedido servicioConsultarPedido;

    public ConsultaControladorPedido(ManejadorListarPedidos manejadorListarPedidos, ServicioConsultarPedido servicioConsultarPedido) {
        this.manejadorListarPedidos = manejadorListarPedidos;
        this.servicioConsultarPedido = servicioConsultarPedido;
    }

    @GetMapping
    @ApiOperation("Listar pedidos")
    public List<DtoPedido> listar() {
        return this.manejadorListarPedidos.ejecutar();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation("Consultar pedido")
    public DtoPedido buscar(@PathVariable Long id) {
        return this.servicioConsultarPedido.ejecutar(id);
    }

}
