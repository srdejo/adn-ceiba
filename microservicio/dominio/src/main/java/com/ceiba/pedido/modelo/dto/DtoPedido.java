package com.ceiba.pedido.modelo.dto;

import com.ceiba.pedido.modelo.enums.EstadoPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class DtoPedido {

    private Long id;
    private Long idCliente;
    private LocalTime hora;
    private EstadoPedido estadoPedido;
    private Double valorDomicilio;
    private LocalDateTime fechaCreacion;
}
