package com.ceiba.oferta.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

public class OfertaTest {

    @Test
    public void validarOfertaHoraFinalMenorTest() {
        // arrange
        Random random = new Random();
        LocalTime horaInicial = LocalTime.now();
        LocalTime horaFinal = horaInicial.minusHours(1);
        // act - assert
        BasePrueba.assertThrows(() -> new Oferta(random.nextLong(), horaInicial, horaFinal, LocalDate.now(), random.nextDouble(), random.nextLong()),
                ExcepcionValorInvalido.class, "La hora inicial debe ser menor a la hora final");
    }
}
