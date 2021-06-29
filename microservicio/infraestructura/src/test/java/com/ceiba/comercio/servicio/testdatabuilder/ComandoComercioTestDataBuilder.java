package com.ceiba.comercio.servicio.testdatabuilder;

import com.ceiba.comercio.comando.ComandoComercio;

import java.util.Random;
import java.util.UUID;

public class ComandoComercioTestDataBuilder {

    private Long id;
    private String nombre;

    public ComandoComercioTestDataBuilder() {
        Random random = new Random();
        nombre = UUID.randomUUID().toString();
    }

    public ComandoComercioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoComercio build() {
        return new ComandoComercio(id, nombre);
    }
}
