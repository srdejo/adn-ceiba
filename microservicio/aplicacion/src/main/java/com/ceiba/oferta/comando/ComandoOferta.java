package com.ceiba.oferta.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoOferta {

    private Long id;
    private LocalTime horaInicial;
    private LocalTime horaFinal;
    private LocalDate dia;
    private Double valor;
    private Long idProducto;
}
