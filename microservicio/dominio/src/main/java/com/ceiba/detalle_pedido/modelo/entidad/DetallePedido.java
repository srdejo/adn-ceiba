package com.ceiba.detalle_pedido.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class DetallePedido {
    private static final String SE_DEBE_INGRESAR_CELULAR = "Se debe ingresar el celular";
    private static final String SE_DEBE_INGRESAR_NOMBRE = "Se debe ingresar el nombre";
    private static final String SE_DEBE_INGRESAR_DIRECCION = "Se debe ingresar la dirección";

    private Long idPedido;
    private Long ordinal;
    private Long idProducto;
    private Integer cantidad;
    private Double valorUnidad;
    private String observacion;
    private LocalDateTime fechaCreacion;

    public DetallePedido(Long idPedido, Long ordinal, Long idProducto, Integer cantidad, Double valorUnidad, String observacion) {

        this.idPedido = idPedido;
        this.ordinal = ordinal;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.valorUnidad = valorUnidad;
        this.observacion = observacion;
        this.fechaCreacion = LocalDateTime.now();
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }
}
