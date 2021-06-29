package com.ceiba.detalle_pedido.controlador;

import com.ceiba.detalle_pedido.consulta.ManejadorListarDetallePedidos;
import com.ceiba.detalle_pedido.modelo.dto.DtoDetallePedido;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/detalle-pedidos")
@Api(tags = {"Controlador consulta detalle pedido"})
public class ConsultaControladorDetallePedido {

    private final ManejadorListarDetallePedidos manejadorListarDetallePedidos;

    public ConsultaControladorDetallePedido(ManejadorListarDetallePedidos manejadorListarDetallePedidos) {
        this.manejadorListarDetallePedidos = manejadorListarDetallePedidos;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation("Listar detalle pedido")
    public List<DtoDetallePedido> listar(@PathVariable Long idPedido) {
        return this.manejadorListarDetallePedidos.ejecutar(idPedido);
    }

}
