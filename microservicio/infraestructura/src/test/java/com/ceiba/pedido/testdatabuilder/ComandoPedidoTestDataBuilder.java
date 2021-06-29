package com.ceiba.pedido.testdatabuilder;

import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.modelo.enums.EstadoPedido;

import java.time.LocalTime;

public class ComandoPedidoTestDataBuilder {

    private Long id;
    private Long clienteId;
    private LocalTime hora;
    private EstadoPedido estadoPedido;

    public ComandoPedidoTestDataBuilder() {
        clienteId = 1L;
        hora = LocalTime.now();
    }

    public ComandoPedidoTestDataBuilder conEstado(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
        return this;
    }

    public ComandoPedido build() {
        return new ComandoPedido(id, clienteId, hora, estadoPedido);
    }
}
