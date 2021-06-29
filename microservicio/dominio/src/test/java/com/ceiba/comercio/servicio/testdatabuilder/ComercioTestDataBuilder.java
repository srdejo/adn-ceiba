package com.ceiba.comercio.servicio.testdatabuilder;

import com.ceiba.comercio.modelo.entidad.Comercio;

import java.util.Random;
import java.util.UUID;

public class ComercioTestDataBuilder {

    private Long id;
    private String nombre;

    public ComercioTestDataBuilder() {
        Random random = new Random();
        nombre = UUID.randomUUID().toString();
    }

    public ComercioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Comercio build() {
        return new Comercio(id, nombre);
    }
}
