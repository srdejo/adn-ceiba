package com.ceiba.horario.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.horario.servicio.testdatabuilder.HorarioTestDataBuilder;
import org.junit.Test;

public class HorarioTest {

    @Test
    public void validarHorarioHoraFinalMenorTest() {
        // arrange
        // act - assert
        BasePrueba.assertThrows(() -> new HorarioTestDataBuilder().horaInicialMayorActual().horaFinalMenor().build(),
                ExcepcionValorInvalido.class, "La hora inicial debe ser menor a la hora final");
    }
}
