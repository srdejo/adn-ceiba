package com.ceiba.horario.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.horario.servicio.testdatabuilder.HorarioTestDataBuilder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;

public class HorarioTest {

    @Test
    public void validarHorarioHoraFinalMenorTest() {
        // arrange
        // act - assert
        BasePrueba.assertThrows(() -> new HorarioTestDataBuilder().horaInicialMayorActual().horaFinalMenor().build(),
                ExcepcionValorInvalido.class, "La hora inicial debe ser menor a la hora final");
    }

    @Test
    public void validarHorarioHoraFinalMayorTest() {
        // arrange
        // act - assert
        try {
            Horario horario = new HorarioTestDataBuilder().horaInicialMayorActual().horaFinalMayor().build();
        }catch (Exception e){
            Assertions.fail(e.getMessage());
        }
    }
}
