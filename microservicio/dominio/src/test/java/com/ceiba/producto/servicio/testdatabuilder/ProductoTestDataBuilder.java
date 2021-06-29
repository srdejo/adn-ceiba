package com.ceiba.producto.servicio.testdatabuilder;

import com.ceiba.producto.modelo.entidad.Producto;

import java.time.LocalDateTime;

public class ProductoTestDataBuilder {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double valor;
    private Long idComercio;
    private LocalDateTime fechaCreacion;

    public ProductoTestDataBuilder() {
        nombre = "Perro Caliente";
        descripcion = "De la casa";
        valor = 10000.00;
        idComercio = 1L;
        fechaCreacion = LocalDateTime.now();
    }

    public ProductoTestDataBuilder conIdComercio(Long idComercio) {
        this.idComercio = idComercio;
        return this;
    }

    public ProductoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Producto build() {
        return new Producto(id, nombre, descripcion, valor, idComercio, fechaCreacion);
    }
}
