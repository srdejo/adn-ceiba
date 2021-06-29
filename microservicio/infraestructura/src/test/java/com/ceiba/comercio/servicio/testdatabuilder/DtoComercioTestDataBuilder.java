package com.ceiba.comercio.servicio.testdatabuilder;

import com.ceiba.comercio.modelo.dto.DtoComercio;

import java.util.Random;
import java.util.UUID;

public class DtoComercioTestDataBuilder {

    private Long id;
    private String nombre;

    public DtoComercioTestDataBuilder() {
        Random random = new Random();
        nombre = UUID.randomUUID().toString();
    }

    public DtoComercioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public DtoComercio build() {
        return new DtoComercio(id, nombre);
    }
}
