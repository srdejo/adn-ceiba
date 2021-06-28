package com.ceiba.oferta.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoOferta {

    private Long id;
    private Time horaInicial;
    private Time horaFinal;
    private LocalDate dia;
    private Double valor;
    private Long idProducto;
}
