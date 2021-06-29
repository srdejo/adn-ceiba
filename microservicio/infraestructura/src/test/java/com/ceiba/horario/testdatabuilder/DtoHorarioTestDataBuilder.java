package com.ceiba.horario.testdatabuilder;

import com.ceiba.horario.comando.ComandoHorario;
import com.ceiba.horario.modelo.dto.DtoHorario;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

public class DtoHorarioTestDataBuilder {

    private Long id;
    private LocalTime horaInicial;
    private LocalTime horaFinal;
    private Long idComercio;
    private Integer diaSemana;
    private LocalDateTime fechaCreacion;

    public DtoHorarioTestDataBuilder() {
        Random random = new Random();
        id = random.nextLong();
        horaInicial = LocalTime.now();
        idComercio = 1L;
        diaSemana = 1;
        fechaCreacion = LocalDateTime.now();
    }

    public DtoHorarioTestDataBuilder horaFinalMayor() {
        horaFinal = this.horaInicial.plusMinutes(10);
        return this;
    }

    public DtoHorarioTestDataBuilder horaFinalMenor() {
        horaFinal = this.horaInicial.minusHours(2);
        return this;
    }

    public DtoHorario build() {
        return new DtoHorario(id, horaInicial, horaFinal, idComercio, diaSemana, fechaCreacion);
    }
}
