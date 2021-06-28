package com.ceiba.pedido.modelo.dto;

import com.ceiba.pedido.modelo.enums.EstadoPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Time;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoPedido {

    private Long id;
    private Long idCliente;
    private Time hora;
    private EstadoPedido estadoPedido;
    private Double valorDomicilio;
    private LocalDateTime fechaCreacion;
}
