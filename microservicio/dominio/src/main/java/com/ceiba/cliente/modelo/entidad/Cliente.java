package com.ceiba.cliente.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Cliente {
    private static final String SE_DEBE_INGRESAR_CELULAR = "Se debe ingresar el celular";
    private static final String SE_DEBE_INGRESAR_NOMBRE = "Se debe ingresar el nombre";
    private static final String SE_DEBE_INGRESAR_DIRECCION = "Se debe ingresar la dirección";

    private Long id;
    private String celular;
    private String nombre;
    private String direccion;
    private LocalDateTime fechaCreacion;

    public Cliente(Long id, String celular, String nombre, String direccion) {
        validarObligatorio(celular, SE_DEBE_INGRESAR_CELULAR);
        validarObligatorio(nombre, SE_DEBE_INGRESAR_NOMBRE);
        validarObligatorio(direccion, SE_DEBE_INGRESAR_DIRECCION);

        this.id = id;
        this.celular = celular;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaCreacion = LocalDateTime.now();
    }
}
