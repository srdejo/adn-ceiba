package com.ceiba.horario.testdatabuilder;

import com.ceiba.horario.comando.ComandoHorario;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

public class ComandoHorarioTestDataBuilder {

    private Long id;
    private LocalTime horaInicial;
    private LocalTime horaFinal;
    private Long idComercio;
    private Integer diaSemana;
    private LocalDateTime fechaCreacion;

    public ComandoHorarioTestDataBuilder() {
        Random random = new Random();
        id = random.nextLong();
        horaInicial = LocalTime.now();
        idComercio = 1L;
        diaSemana = 1;
        fechaCreacion = LocalDateTime.now();
    }

    public ComandoHorarioTestDataBuilder horaFinalMayor() {
        horaFinal = this.horaInicial.plusMinutes(10);
        return this;
    }

    public ComandoHorarioTestDataBuilder horaFinalMenor() {
        horaFinal = this.horaInicial.minusHours(2);
        return this;
    }

    public ComandoHorario build() {
        return new ComandoHorario(id, horaInicial, horaFinal, idComercio, diaSemana, fechaCreacion);
    }
}
