package com.ceiba.pedido.testdatabuilder;

import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.modelo.enums.EstadoPedido;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class ComandoPedidoTestDataBuilder {

    private Long id;
    private Long idCliente;
    private LocalTime hora;
    private EstadoPedido estadoPedido;
    private Double valorDomicilio;
    private LocalDateTime fechaCreacion;

    public ComandoPedidoTestDataBuilder() {
        id = null;
        idCliente = Long.valueOf(1);
        hora = LocalTime.now();
        estadoPedido = EstadoPedido.PENDIENTE;
        valorDomicilio = 2000.00;
        fechaCreacion = LocalDateTime.now();
    }

    public ComandoPedidoTestDataBuilder conEstado(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
        return this;
    }

    public ComandoPedido build() {
        return new ComandoPedido(id, idCliente, hora, estadoPedido, valorDomicilio);
    }
}
