package com.ceiba.producto.testdatabuilder;

import com.ceiba.producto.modelo.dto.DtoProducto;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

public class DtoProductoTestDataBuilder {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double valor;
    private Long idComercio;
    private LocalDateTime fechaCreacion;

    public DtoProductoTestDataBuilder() {
        Random random = new Random();
        nombre = UUID.randomUUID().toString();
        valor = random.nextDouble();
        idComercio = random.nextLong();
        descripcion = UUID.randomUUID().toString();
        fechaCreacion = LocalDateTime.now();
    }

    public DtoProducto build() {
        return new DtoProducto(id, nombre, descripcion, valor, idComercio, fechaCreacion);
    }
}
