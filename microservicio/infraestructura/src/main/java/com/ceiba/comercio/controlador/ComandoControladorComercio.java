package com.ceiba.comercio.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comercio.comando.ComandoComercio;
import com.ceiba.comercio.comando.manejador.ManejadorActualizarComercio;
import com.ceiba.comercio.comando.manejador.ManejadorCrearComercio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comercios")
@Api(tags = {"Controlador comando comercio"})
public class ComandoControladorComercio {

    private final ManejadorCrearComercio manejadorCrearComercio;
    private final ManejadorActualizarComercio manejadorActualizarComercio;

    @Autowired
    public ComandoControladorComercio(ManejadorCrearComercio manejadorCrearComercio,
                                     ManejadorActualizarComercio manejadorActualizarComercio) {
        this.manejadorCrearComercio = manejadorCrearComercio;
        this.manejadorActualizarComercio = manejadorActualizarComercio;
    }

    @PostMapping
    @ApiOperation("Crear Comercio")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoComercio comandoComercio) {
        return manejadorCrearComercio.ejecutar(comandoComercio);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar Comercio")
    public void actualizar(@RequestBody ComandoComercio comandoComercio, @PathVariable Long id) {
        comandoComercio.setId(id);
        manejadorActualizarComercio.ejecutar(comandoComercio);
    }
}
