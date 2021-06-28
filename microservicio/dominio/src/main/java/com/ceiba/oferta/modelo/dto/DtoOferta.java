package com.ceiba.oferta.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoOferta {

    private Long id;
    private Time horaInicial;
    private Time horaFinal;
    private LocalDate dia;
    private Double valor;
    private Long idProducto;
    private LocalDateTime fechaCreacion;

}
