package com.ceiba.oferta.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;

@Getter
public class Oferta {
    private static final String SE_DEBE_INGRESAR_DIA = "Se debe ingresar el dia";
    private static final String SE_DEBE_INGRESAR_VALOR = "Se debe ingresar el valor";
    private static final String SE_DEBE_INGRESAR_VALOR_VALIDO = "Se debe ingresar un valor valido";
    private static final String SE_DEBE_SELECCIONAR_PRODUCTO = "Se debe seleccionar un producto";
    private static final String HORA_INICIAL_MENOR = "La hora inicial debe ser menor a la hora final";

    private Long id;
    private LocalTime horaInicial;
    private LocalTime horaFinal;
    private LocalDate dia;
    private Double valor;
    private Long idProducto;
    private LocalDateTime fechaCreacion;

    public Oferta(Long id, LocalTime horaInicial, LocalTime horaFinal, LocalDate dia, Double valor, Long idProducto) {
        validarObligatorio(dia, SE_DEBE_INGRESAR_DIA);
        validarObligatorio(valor, SE_DEBE_INGRESAR_VALOR);
        validarPositivo(valor, SE_DEBE_INGRESAR_VALOR_VALIDO);
        validarObligatorio(idProducto, SE_DEBE_SELECCIONAR_PRODUCTO);
        if (horaInicial.isAfter(horaFinal)) {
            throw new ExcepcionValorInvalido(HORA_INICIAL_MENOR);
        }

        this.id = id;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.dia = dia;
        this.valor = valor;
        this.idProducto = idProducto;
        this.fechaCreacion = LocalDateTime.now();
    }
}
