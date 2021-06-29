package com.ceiba.cliente.servicio.testdatabuilder;

import com.ceiba.cliente.modelo.dto.DtoCliente;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

public class DtoClienteTestDataBuilder {

    private Long id;
    private String nombre;
    private String celular;
    private String direccion;
    private LocalDateTime fechaCreacion;

    public DtoClienteTestDataBuilder() {
        Random random = new Random();
        nombre = UUID.randomUUID().toString();
        celular = ("3" + random.nextLong())
                .substring(0, 15).replace("-", "");
        direccion = UUID.randomUUID().toString();
        fechaCreacion = LocalDateTime.now();
    }

    public DtoClienteTestDataBuilder conCelular(String celular) {
        this.celular = celular;
        return this;
    }

    public DtoCliente build() {
        return new DtoCliente(id, celular, nombre, direccion, fechaCreacion);
    }
}
