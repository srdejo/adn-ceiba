package com.ceiba.cliente.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.comando.manejador.ManejadorActualizarCliente;
import com.ceiba.cliente.comando.manejador.ManejadorCrearCliente;
import com.ceiba.cliente.comando.manejador.ManejadorEliminarCliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@Api(tags = {"Controlador comando cliente"})
public class ComandoControladorCliente {

    private final ManejadorCrearCliente manejadorCrearCliente;
    private final ManejadorEliminarCliente manejadorEliminarCliente;
    private final ManejadorActualizarCliente manejadorActualizarCliente;

    @Autowired
    public ComandoControladorCliente(ManejadorCrearCliente manejadorCrearCliente,
                                     ManejadorEliminarCliente manejadorEliminarCliente,
                                     ManejadorActualizarCliente manejadorActualizarCliente) {
        this.manejadorCrearCliente = manejadorCrearCliente;
        this.manejadorEliminarCliente = manejadorEliminarCliente;
        this.manejadorActualizarCliente = manejadorActualizarCliente;
    }

    @PostMapping
    @ApiOperation("Crear Cliente")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCliente comandoCliente) {
        return manejadorCrearCliente.ejecutar(comandoCliente);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar Cliente")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarCliente.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar Cliente")
    public void actualizar(@RequestBody ComandoCliente comandoCliente, @PathVariable Long id) {
        comandoCliente.setId(id);
        manejadorActualizarCliente.ejecutar(comandoCliente);
    }
}
