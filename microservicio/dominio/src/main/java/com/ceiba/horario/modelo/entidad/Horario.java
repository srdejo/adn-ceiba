package com.ceiba.horario.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Horario {
    private static final String SE_DEBE_INGRESAR_HORA_INICIAL = "Se debe ingresar la hora inicial";
    private static final String SE_DEBE_INGRESAR_HORA_FINAL = "Se debe ingresar la hora final";
    private static final String SE_DEBE_SELECCIONAR_COMERCIO = "Se debe seleccionar un comercio";
    private static final String HORA_INICIAL_MENOR = "La hora inicial debe ser menor a la hora final";

    private Long id;
    private LocalTime horaInicial;
    private LocalTime horaFinal;
    private Long idComercio;
    private Integer diaSemana;
    private LocalDateTime fechaCreacion;


    public Horario(Long id, LocalTime horaInicial, LocalTime horaFinal, Integer diaSemana, Long idComercio) {
        validarObligatorio(horaInicial, SE_DEBE_INGRESAR_HORA_INICIAL);
        validarObligatorio(horaFinal, SE_DEBE_INGRESAR_HORA_FINAL);
        validarObligatorio(idComercio, SE_DEBE_SELECCIONAR_COMERCIO);

        if (horaInicial.isAfter(horaFinal)) {
            throw new ExcepcionValorInvalido(HORA_INICIAL_MENOR);
        }
        this.id = id;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.idComercio = idComercio;
        this.diaSemana = diaSemana;
        this.fechaCreacion = LocalDateTime.now();
    }
}
