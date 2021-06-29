package com.ceiba.oferta.modelo.dto;

import com.ceiba.producto.modelo.entidad.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class DtoOferta {

    private Long id;
    private LocalTime horaInicial;
    private LocalTime horaFinal;
    private LocalDate dia;
    private Double valor;
    private Long idProducto;
    private LocalDateTime fechaCreacion;
    private Producto producto;

}
