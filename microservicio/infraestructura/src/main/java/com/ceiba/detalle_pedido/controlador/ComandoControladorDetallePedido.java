package com.ceiba.detalle_pedido.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.detalle_pedido.comando.ComandoDetallePedido;
import com.ceiba.detalle_pedido.comando.manejador.ManejadorActualizarDetallePedido;
import com.ceiba.detalle_pedido.comando.manejador.ManejadorCrearDetallePedido;
import com.ceiba.detalle_pedido.comando.manejador.ManejadorEliminarDetallePedido;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detalle-pedidos")
@Api(tags = {"Controlador comando detalle pedido"})
public class ComandoControladorDetallePedido {

    private final ManejadorCrearDetallePedido manejadorCrearDetallePedido;
    private final ManejadorEliminarDetallePedido manejadorEliminarDetallePedido;
    private final ManejadorActualizarDetallePedido manejadorActualizarDetallePedido;

    @Autowired
    public ComandoControladorDetallePedido(ManejadorCrearDetallePedido manejadorCrearDetallePedido,
                                           ManejadorEliminarDetallePedido manejadorEliminarDetallePedido,
                                           ManejadorActualizarDetallePedido manejadorActualizarDetallePedido) {
        this.manejadorCrearDetallePedido = manejadorCrearDetallePedido;
        this.manejadorEliminarDetallePedido = manejadorEliminarDetallePedido;
        this.manejadorActualizarDetallePedido = manejadorActualizarDetallePedido;
    }

    @PostMapping
    @ApiOperation("Crear DetallePedido")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoDetallePedido comandoDetallePedido) {
        return manejadorCrearDetallePedido.ejecutar(comandoDetallePedido);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar DetallePedido")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarDetallePedido.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar DetallePedido")
    public void actualizar(@RequestBody ComandoDetallePedido comandoDetallePedido, @PathVariable Long id) {
        comandoDetallePedido.setId(id);
        manejadorActualizarDetallePedido.ejecutar(comandoDetallePedido);
    }
}
