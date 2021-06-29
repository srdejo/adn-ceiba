package com.ceiba.horario.servicio.testdatabuilder;

import com.ceiba.horario.modelo.entidad.Horario;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

public class HorarioTestDataBuilder {

    private Long id;
    private LocalTime horaInicial;
    private LocalTime horaFinal;
    private Long idComercio;
    private Integer diaSemana;
    private LocalDateTime fechaCreacion;

    public HorarioTestDataBuilder() {
        Random random = new Random();
        id = random.nextLong();
        horaInicial = LocalTime.now();
        idComercio = 1L;
        diaSemana = LocalDateTime.now().getDayOfWeek().getValue();
        fechaCreacion = LocalDateTime.now();
    }

    public HorarioTestDataBuilder conIdComercio(Long id) {
        idComercio = id;
        return this;
    }


    public HorarioTestDataBuilder horaFinalMayor() {
        horaFinal = this.horaInicial.plusMinutes(10);
        return this;
    }

    public HorarioTestDataBuilder horaFinalMenor() {
        horaFinal = this.horaInicial.minusHours(2);
        return this;
    }

    public HorarioTestDataBuilder horaInicialMayorActual() {
        horaInicial = LocalTime.now().plusMinutes(5);
        return this;
    }

    public Horario build() {
        return new Horario(id, horaInicial, horaFinal, diaSemana, idComercio);
    }
}
