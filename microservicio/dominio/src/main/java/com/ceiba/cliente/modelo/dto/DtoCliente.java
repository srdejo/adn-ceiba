package com.ceiba.cliente.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoCliente {

    private Long id;
    private String celular;
    private String nombre;
    private String direccion;
    private LocalDateTime fechaCreacion;

}
