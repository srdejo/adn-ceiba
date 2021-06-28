package com.ceiba.comercio.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Comercio {
    private static final String SE_DEBE_INGRESAR_NOMBRE = "Se debe ingresar el nombre";

    private Long id;
    private String nombre;

    public Comercio(Long id,  String nombre) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_NOMBRE);

        this.id = id;
        this.nombre = nombre;
    }
}
