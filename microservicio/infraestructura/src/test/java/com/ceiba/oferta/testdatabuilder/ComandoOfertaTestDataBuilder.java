package com.ceiba.oferta.testdatabuilder;

import com.ceiba.oferta.comando.ComandoOferta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

public class ComandoOfertaTestDataBuilder {

    private Long id;
    private LocalTime horaInicial;
    private LocalTime horaFinal;
    private LocalDate dia;
    private Double valor;
    private Long idProducto;
    private LocalDateTime fechaCreacion;

    public ComandoOfertaTestDataBuilder() {
        Random random = new Random();
        LocalDateTime fechaHoraActual = LocalDateTime.now();

        id = random.nextLong();
        horaInicial = fechaHoraActual.toLocalTime();
        dia = fechaHoraActual.toLocalDate();
        valor = random.nextDouble();
        idProducto = 1L;
        fechaCreacion = fechaHoraActual;
    }

    public ComandoOfertaTestDataBuilder horaFinalMayor() {
        this.horaFinal = this.horaInicial.plusMinutes(10);
        return this;
    }

    public ComandoOfertaTestDataBuilder horaFinalMenor() {
        this.horaFinal = this.horaInicial.minusHours(2);
        return this;
    }

    public ComandoOferta build() {
        return new ComandoOferta(id, horaInicial, horaFinal, dia, valor, idProducto);
    }
}
