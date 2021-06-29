package com.ceiba.horario.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

public class HorarioTest {

    @Test
    public void validarHorarioHoraFinalMenorTest() {
        // arrange
        Random random = new Random();
        LocalTime horaInicial = LocalTime.now();
        LocalTime horaFinal = horaInicial.minusHours(1);
        // act - assert
        BasePrueba.assertThrows(() -> new Horario(random.nextLong(), horaInicial, horaFinal, LocalDateTime.now().getDayOfWeek().getValue(), random.nextLong()),
                ExcepcionValorInvalido.class, "La hora inicial debe ser menor a la hora final");
    }
}
