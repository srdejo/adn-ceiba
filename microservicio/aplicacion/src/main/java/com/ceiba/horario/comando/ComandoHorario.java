package com.ceiba.horario.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoHorario {

    private Long id;
    private LocalTime horaInicial;
    private LocalTime horaFinal;
    private Long idComercio;
    private Integer diaSemana;
    private LocalDateTime fechaCreacion;

}
