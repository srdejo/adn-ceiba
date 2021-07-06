package com.ceiba.detalle_pedido.modelo.dto;

import com.ceiba.producto.modelo.dto.DtoProducto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoDetallePedido {

    private Long id;
    private Long idPedido;
    private DtoProducto dtoProducto;
    private Integer cantidad;
    private Double valorUnidad;
    private String observacion;
    private LocalDateTime fechaCreacion;

}
