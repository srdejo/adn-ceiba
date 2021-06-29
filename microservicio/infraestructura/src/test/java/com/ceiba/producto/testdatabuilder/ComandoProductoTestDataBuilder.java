package com.ceiba.producto.testdatabuilder;

import com.ceiba.producto.comando.ComandoProducto;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

public class ComandoProductoTestDataBuilder {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double valor;
    private Long idComercio;
    private LocalDateTime fechaCreacion;

    public ComandoProductoTestDataBuilder() {
        Random random = new Random();
        nombre = UUID.randomUUID().toString();
        valor = 10000.00;
        idComercio = 1L;
        fechaCreacion = LocalDateTime.now();
    }

    public ComandoProductoTestDataBuilder conIdComercio(Long idComercio) {
        this.idComercio = idComercio;
        return this;
    }

    public ComandoProductoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoProducto build() {
        return new ComandoProducto(id, nombre, descripcion, valor, idComercio);
    }
}
