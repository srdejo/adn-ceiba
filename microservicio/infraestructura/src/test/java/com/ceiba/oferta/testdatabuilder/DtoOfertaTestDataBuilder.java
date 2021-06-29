package com.ceiba.oferta.testdatabuilder;

import com.ceiba.oferta.modelo.dto.DtoOferta;
import com.ceiba.producto.modelo.entidad.Producto;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

public class DtoOfertaTestDataBuilder {

    private Long id;
    private LocalTime horaInicial;
    private LocalTime horaFinal;
    private LocalDate dia;
    private Double valor;
    private Producto producto;
    private LocalDateTime fechaCreacion;

    public DtoOfertaTestDataBuilder() {
        Random random = new Random();
        LocalDateTime fechaHoraActual = LocalDateTime.now();

        id = random.nextLong();
        horaInicial = fechaHoraActual.toLocalTime();
        dia = fechaHoraActual.toLocalDate();
        valor = random.nextDouble();
        producto = null;
        fechaCreacion = fechaHoraActual;
    }

    public DtoOfertaTestDataBuilder horaFinalMayor() {
        this.horaFinal = this.horaInicial.plusMinutes(10);
        return this;
    }

    public DtoOfertaTestDataBuilder horaFinalMenor() {
        this.horaFinal = this.horaInicial.minusHours(2);
        return this;
    }

    public DtoOferta build() {
        return new DtoOferta(id, horaInicial, horaFinal, dia, valor, fechaCreacion, producto);
    }
}
