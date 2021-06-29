package com.ceiba.detalle_pedido.testdatabuilder;

import com.ceiba.detalle_pedido.comando.ComandoDetallePedido;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

public class ComandoDetallePedidoTestDataBuilder {

    private Long id;
    private Long idPedido;
    private Long idProducto;
    private Integer cantidad;
    private Double valorUnidad;
    private String observacion;
    private LocalDateTime fechaCreacion;

    public ComandoDetallePedidoTestDataBuilder() {
        Random random = new Random();
        cantidad = 1;
        valorUnidad = random.nextDouble();
        fechaCreacion = LocalDateTime.now();
        observacion = UUID.randomUUID().toString();
    }

    public ComandoDetallePedidoTestDataBuilder conIdPedido(Long idPedido) {
        this.idPedido = idPedido;
        return this;
    }

    public ComandoDetallePedidoTestDataBuilder conIdProducto(Long idProducto) {
        this.idProducto = idProducto;
        return this;
    }

    public ComandoDetallePedido build() {
        return new ComandoDetallePedido(id, idPedido, idProducto, cantidad,
                valorUnidad, observacion, fechaCreacion);
    }
}
