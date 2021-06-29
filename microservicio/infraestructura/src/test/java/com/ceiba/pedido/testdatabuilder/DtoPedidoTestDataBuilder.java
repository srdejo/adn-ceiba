package com.ceiba.pedido.testdatabuilder;

import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.modelo.enums.EstadoPedido;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

public class DtoPedidoTestDataBuilder {

    private Long id;
    private Long clienteId;
    private LocalTime hora;
    private Double valorDomicilio;
    private EstadoPedido estadoPedido;
    private LocalDateTime fechaCreacion;

    public DtoPedidoTestDataBuilder() {
        Random random = new Random();
        id = random.nextLong();
        clienteId = random.nextLong();
        hora = LocalTime.now();
        estadoPedido = EstadoPedido.PENDIENTE;
        valorDomicilio = random.nextDouble();
        fechaCreacion = LocalDateTime.now();
    }


    public DtoPedido build() {
        return new DtoPedido(id, clienteId, hora, estadoPedido, valorDomicilio, fechaCreacion);
    }
}
