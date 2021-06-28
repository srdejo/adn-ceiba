package com.ceiba.pedido.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.comando.manejador.ManejadorActualizarPedido;
import com.ceiba.pedido.comando.manejador.ManejadorCrearPedido;
import com.ceiba.pedido.comando.manejador.ManejadorEliminarPedido;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
@Api(tags = {"Controlador comando pedido"})
public class ComandoControladorPedido {

    private final ManejadorCrearPedido manejadorCrearPedido;
    private final ManejadorEliminarPedido manejadorEliminarPedido;
    private final ManejadorActualizarPedido manejadorActualizarPedido;

    @Autowired
    public ComandoControladorPedido(ManejadorCrearPedido manejadorCrearPedido,
                                    ManejadorEliminarPedido manejadorEliminarPedido,
                                    ManejadorActualizarPedido manejadorActualizarPedido) {
        this.manejadorCrearPedido = manejadorCrearPedido;
        this.manejadorEliminarPedido = manejadorEliminarPedido;
        this.manejadorActualizarPedido = manejadorActualizarPedido;
    }

    @PostMapping
    @ApiOperation("Crear Pedido")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPedido comandoPedido) {
        return manejadorCrearPedido.ejecutar(comandoPedido);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar Pedido")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarPedido.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar Pedido")
    public void actualizar(@RequestBody ComandoPedido comandoPedido, @PathVariable Long id) {
        comandoPedido.setId(id);
        manejadorActualizarPedido.ejecutar(comandoPedido);
    }
}
