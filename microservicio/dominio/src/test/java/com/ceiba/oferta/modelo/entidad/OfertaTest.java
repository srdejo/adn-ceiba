package com.ceiba.oferta.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.oferta.servicio.testdatabuilder.OfertaTestDataBuilder;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

public class OfertaTest {

    @Test
    public void validarOfertaHoraFinalMenorTest() {
        // arrange
        // act - assert
        BasePrueba.assertThrows(() -> new OfertaTestDataBuilder().conHoraFinalMenor().build(),
                ExcepcionValorInvalido.class, "La hora inicial debe ser menor a la hora final");
    }
}
