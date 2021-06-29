package com.ceiba.pedido.servicio.testdatabuilder;

import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.modelo.enums.EstadoPedido;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class PedidoTestDataBuilder {

    private Long id;
    private Long clienteId;
    private LocalTime hora;
    private EstadoPedido estadoPedido;


    public PedidoTestDataBuilder() {
        clienteId = 1L;
        hora = LocalTime.now();
        estadoPedido = EstadoPedido.PENDIENTE;
    }

    public PedidoTestDataBuilder conEstado(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
        return this;
    }

    public PedidoTestDataBuilder conClienteId(Long id) {
        this.clienteId = id;
        return this;
    }

    public Pedido build() {
        return new Pedido(id, clienteId, hora, estadoPedido, LocalDateTime.now());
    }
}
