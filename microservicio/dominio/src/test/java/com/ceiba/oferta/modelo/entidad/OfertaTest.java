package com.ceiba.oferta.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.oferta.servicio.testdatabuilder.OfertaTestDataBuilder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class OfertaTest {

    @Test
    public void validarOfertaHoraFinalMenorTest() {
        // arrange
        // act - assert
        BasePrueba.assertThrows(() -> new OfertaTestDataBuilder().conHoraFinalMenor().build(),
                ExcepcionValorInvalido.class, "La hora inicial debe ser menor a la hora final");
    }

    @Test
    public void validarOfertaHoraFinalMayorTest() {
        // arrange
        // act - assert
        Assertions.assertDoesNotThrow(() -> new OfertaTestDataBuilder().build());
    }
}
