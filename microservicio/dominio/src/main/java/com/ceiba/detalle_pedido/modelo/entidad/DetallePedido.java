package com.ceiba.detalle_pedido.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;

@Getter
public class DetallePedido {
    private static final String SE_DEBE_CREAR_UN_PEDIDO = "Se debe crear un pedido previamente";
    private static final String SE_DEBE_SELECCIONAR_UN_PRODUCTO = "Se debe seleccionar un producto";
    private static final String SE_DEBE_INGRESAR_CANTIDAD = "Se debe ingresar la cantidad";
    private static final String SE_DEBE_INGRESAR_VALOR = "Se debe ingresar el valor";
    private static final String SE_DEBE_INGRESAR_CANTIDAD_VALIDA = "Se debe ingresar una cantidad valida";
    private static final String SE_DEBE_INGRESAR_VALOR_VALIDO = "Se debe ingresar un valor valido";

    private Long id;
    private Long idPedido;
    private Long idProducto;
    private Integer cantidad;
    private Double valorUnidad;
    private String observacion;
    private LocalDateTime fechaCreacion;

    public DetallePedido(Long id,Long idPedido, Long idProducto, Integer cantidad, Double valorUnidad, String observacion, LocalDateTime fechaCreacion) {

        validarObligatorio(idProducto, SE_DEBE_SELECCIONAR_UN_PRODUCTO);
        validarObligatorio(cantidad, SE_DEBE_INGRESAR_CANTIDAD);
        validarObligatorio(valorUnidad, SE_DEBE_INGRESAR_VALOR);

        validarPositivo(valorUnidad, SE_DEBE_INGRESAR_VALOR_VALIDO);
        validarPositivo(Double.valueOf(cantidad), SE_DEBE_INGRESAR_CANTIDAD_VALIDA);

        this.id = id;
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.valorUnidad = valorUnidad;
        this.observacion = observacion;
        this.fechaCreacion = fechaCreacion;
    }
}
