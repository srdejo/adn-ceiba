package com.ceiba.oferta.servicio.testdatabuilder;

import com.ceiba.oferta.modelo.entidad.Oferta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class OfertaTestDataBuilder {

    private Long id;
    private LocalTime horaInicial;
    private LocalTime horaFinal;
    private LocalDate dia;
    private Double valor;
    private Long idProducto;
    private LocalDateTime fechaCreacion;

    public OfertaTestDataBuilder() {
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        horaInicial = fechaHoraActual.toLocalTime().minusMinutes(5);
        horaFinal = fechaHoraActual.toLocalTime().plusMinutes(30);
        dia = fechaHoraActual.toLocalDate();
        valor = 10.00;
        idProducto = 1L;
        fechaCreacion = fechaHoraActual;
    }

    public OfertaTestDataBuilder conValor(Double valor) {
        this.valor = valor;
        return this;
    }

    public OfertaTestDataBuilder conIdProducto(Long idProducto) {
        this.idProducto = idProducto;
        return this;
    }

    public Oferta build() {
        return new Oferta(id, horaInicial, horaFinal, dia, valor, idProducto);
    }
}
