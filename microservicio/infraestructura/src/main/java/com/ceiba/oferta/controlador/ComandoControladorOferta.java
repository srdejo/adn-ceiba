package com.ceiba.oferta.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.oferta.comando.ComandoOferta;
import com.ceiba.oferta.comando.manejador.ManejadorActualizarOferta;
import com.ceiba.oferta.comando.manejador.ManejadorCrearOferta;
import com.ceiba.oferta.comando.manejador.ManejadorEliminarOferta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ofertas")
@Api(tags = {"Controlador comando oferta"})
public class ComandoControladorOferta {

    private final ManejadorCrearOferta manejadorCrearOferta;
    private final ManejadorEliminarOferta manejadorEliminarOferta;
    private final ManejadorActualizarOferta manejadorActualizarOferta;

    @Autowired
    public ComandoControladorOferta(ManejadorCrearOferta manejadorCrearOferta,
                                    ManejadorEliminarOferta manejadorEliminarOferta,
                                    ManejadorActualizarOferta manejadorActualizarOferta) {
        this.manejadorCrearOferta = manejadorCrearOferta;
        this.manejadorEliminarOferta = manejadorEliminarOferta;
        this.manejadorActualizarOferta = manejadorActualizarOferta;
    }

    @PostMapping
    @ApiOperation("Crear Oferta")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoOferta comandoOferta) {
        return manejadorCrearOferta.ejecutar(comandoOferta);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar Oferta")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarOferta.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar Oferta")
    public void actualizar(@RequestBody ComandoOferta comandoOferta, @PathVariable Long id) {
        comandoOferta.setId(id);
        manejadorActualizarOferta.ejecutar(comandoOferta);
    }
}
