package com.ceiba.detalle_pedido.testdatabuilder;

import com.ceiba.detalle_pedido.comando.ComandoDetallePedido;
import com.ceiba.detalle_pedido.modelo.dto.DtoDetallePedido;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

public class DtoDetallePedidoTestDataBuilder {

    private Long id;
    private Long idPedido;
    private Long idProducto;
    private Integer cantidad;
    private Double valorUnidad;
    private String observacion;
    private LocalDateTime fechaCreacion;

    public DtoDetallePedidoTestDataBuilder() {
        Random random = new Random();
        cantidad = 1;
        valorUnidad = random.nextDouble();
        fechaCreacion = LocalDateTime.now();
        observacion = UUID.randomUUID().toString();
    }

    public DtoDetallePedidoTestDataBuilder conIdPedido(Long idPedido) {
        this.idPedido = idPedido;
        return this;
    }

    public DtoDetallePedidoTestDataBuilder conIdProducto(Long idProducto) {
        this.idProducto = idProducto;
        return this;
    }

    public DtoDetallePedido build() {
        return new DtoDetallePedido(id, idPedido, idProducto, cantidad,
                valorUnidad, observacion, fechaCreacion);
    }
}
