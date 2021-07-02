package com.ceiba.pedido.modelo.dto;

import com.ceiba.detalle_pedido.modelo.dto.DtoDetallePedido;
import com.ceiba.pedido.modelo.enums.EstadoPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class DtoPedido {

    private Long id;
    private Long idCliente;
    private LocalTime hora;
    private EstadoPedido estadoPedido;
    private Double valorDomicilio;
    private List<DtoDetallePedido> detallePedidos;
    private LocalDateTime fechaCreacion;
}
