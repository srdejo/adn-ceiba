package com.ceiba.producto.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;

@Getter
public class Producto {
    private static final String SE_DEBE_INGRESAR_VALOR = "Se debe ingresar el valor";
    private static final String SE_DEBE_INGRESAR_VALOR_VALIDO = "Se debe ingresar un valor valido";
    private static final String SE_DEBE_INGRESAR_NOMBRE = "Se debe ingresar el nombre";
    private static final String SE_DEBE_SELECCIONAR_COMERCIO = "Se debe seleccionar un comercio";

    private Long id;
    private String nombre;
    private String descripcion;
    private Double valor;
    private Long idComercio;
    private LocalDateTime fechaCreacion;

    public Producto(Long id, String nombre, String descripcion, Double valor, Long idComercio, LocalDateTime fechaCreacion) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_VALOR);
        validarObligatorio(valor, SE_DEBE_INGRESAR_NOMBRE);
        validarObligatorio(idComercio, SE_DEBE_SELECCIONAR_COMERCIO);
        validarPositivo(valor, SE_DEBE_INGRESAR_VALOR_VALIDO);

        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valor = valor;
        this.idComercio = idComercio;
        this.fechaCreacion = fechaCreacion;
    }
}
