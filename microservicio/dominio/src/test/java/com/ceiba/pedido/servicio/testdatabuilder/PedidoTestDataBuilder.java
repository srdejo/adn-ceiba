package com.ceiba.pedido.servicio.testdatabuilder;

import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.modelo.enums.EstadoPedido;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class PedidoTestDataBuilder {

    private Long id;
    private Long idCliente;
    private LocalTime hora;
    private String estadoPedido;
    private Double valorDomicilio;
    private LocalDateTime fechaCreacion;


    public PedidoTestDataBuilder() {
        idCliente = 1L;
        hora = LocalTime.now();
        estadoPedido = EstadoPedido.PENDIENTE.toString();
        valorDomicilio = 2000.00;
        fechaCreacion = LocalDateTime.now();
    }

    public PedidoTestDataBuilder conEstado(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido.toString();
        return this;
    }

    public PedidoTestDataBuilder conClienteId(Long id) {
        this.idCliente = id;
        return this;
    }

    public Pedido build() {
        return new Pedido(id, idCliente, hora, estadoPedido, valorDomicilio, fechaCreacion);
    }
}
