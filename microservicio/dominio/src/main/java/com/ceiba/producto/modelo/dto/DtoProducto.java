package com.ceiba.producto.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoProducto {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double valor;
    private Long idComercio;
    private LocalDateTime fechaCreacion;

}
