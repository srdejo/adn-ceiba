package com.ceiba.horario.modelo.dto;

import com.ceiba.horario.modelo.entidad.Horario;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class DtoHorario {

    private Long id;
    private LocalTime horaInicial;
    private LocalTime horaFinal;
    private Long idComercio ;
    private Integer diaSemana;
    private LocalDateTime fechaCreacion;

}
