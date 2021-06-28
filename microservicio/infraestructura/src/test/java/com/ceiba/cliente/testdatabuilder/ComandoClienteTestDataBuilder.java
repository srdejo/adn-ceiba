package com.ceiba.cliente.testdatabuilder;

import com.ceiba.cliente.comando.ComandoCliente;

import java.util.Random;
import java.util.UUID;

public class ComandoClienteTestDataBuilder {

    private Long id;
    private String nombre;
    private String celular;
    private String direccion;

    public ComandoClienteTestDataBuilder() {
        Random random = new Random();
        nombre = UUID.randomUUID().toString();
        celular = ("3" + random.nextLong())
                .substring(0, 15).replace("-", "");
        direccion = UUID.randomUUID().toString();
    }

    public ComandoClienteTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoCliente build() {
        return new ComandoCliente(id, celular, nombre, direccion);
    }
}
