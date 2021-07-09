package com.ceiba.producto.controlador;

import com.ceiba.producto.consulta.ManejadorListarProductos;
import com.ceiba.producto.consulta.ManejadorListarProductosDisponibles;
import com.ceiba.producto.modelo.dto.DtoProducto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@Api(tags = {"Controlador consulta producto"})
public class ConsultaControladorProducto {

    private final ManejadorListarProductos manejadorListarProductos;
    private final ManejadorListarProductosDisponibles manejadorListarProductosDisponibles;

    public ConsultaControladorProducto(ManejadorListarProductos manejadorListarProductos,
                                       ManejadorListarProductosDisponibles manejadorListarProductosDisponibles) {
        this.manejadorListarProductos = manejadorListarProductos;
        this.manejadorListarProductosDisponibles = manejadorListarProductosDisponibles;
    }


    @GetMapping(value = "/{id}")
    @ApiOperation("Listar productos")
    public List<DtoProducto> listar(@PathVariable Long id) {
        return this.manejadorListarProductos.ejecutar(id);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/disponible")
    @ApiOperation("Listar productos")
    public List<DtoProducto> listarDisponible() {
        return this.manejadorListarProductosDisponibles.ejecutar();
    }

}
