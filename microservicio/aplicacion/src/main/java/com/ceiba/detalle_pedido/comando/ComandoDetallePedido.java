package com.ceiba.detalle_pedido.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoDetallePedido {

    private Long id;
    private Long idPedido;
    private Long idProducto;
    private Integer cantidad;
    private Double valorUnidad;
    private String observacion;
    private LocalDateTime fechaCreacion;
}
