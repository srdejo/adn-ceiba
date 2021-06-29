package com.ceiba.cliente.servicio.testdatabuilder;

import com.ceiba.cliente.modelo.entidad.Cliente;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

public class ClienteTestDataBuilder {

    private Long id;
    private String nombre;
    private String celular;
    private String direccion;

    public ClienteTestDataBuilder() {
        Random random = new Random();
        nombre = UUID.randomUUID().toString();
        celular = ("3" + random.nextLong())
                .substring(0, 15).replace("-", "");
        direccion = UUID.randomUUID().toString();
    }

    public ClienteTestDataBuilder conCelular(String celular) {
        this.celular = celular;
        return this;
    }


    public Cliente build() {
        return new Cliente(id, celular, nombre, direccion);
    }
}
