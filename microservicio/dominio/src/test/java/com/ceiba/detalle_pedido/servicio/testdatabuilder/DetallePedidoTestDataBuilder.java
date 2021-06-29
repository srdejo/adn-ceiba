package com.ceiba.detalle_pedido.servicio.testdatabuilder;

import com.ceiba.detalle_pedido.modelo.entidad.DetallePedido;
import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

public class DetallePedidoTestDataBuilder {

    private Long id;
    private Long idPedido;
    private Long idProducto;
    private Integer cantidad;
    private Double valorUnidad;
    private String observacion;
    private LocalDateTime fechaCreacion;

    public DetallePedidoTestDataBuilder() {
        Random random = new Random();
        cantidad = 1;
        valorUnidad = random.nextDouble();
        fechaCreacion = LocalDateTime.now();
        observacion = UUID.randomUUID().toString();
    }

    public DetallePedidoTestDataBuilder conIdPedido(Long idPedido) {
        this.idPedido = idPedido;
        return this;
    }

    public DetallePedidoTestDataBuilder conIdProducto(Long idProducto) {
        this.idProducto = idProducto;
        return this;
    }

    public DetallePedido build() {
        return new DetallePedido(id, idPedido, idProducto, cantidad,
                valorUnidad, observacion, fechaCreacion);
    }
}
