package com.ceiba.detalle_pedido.puerto.dao;

import com.ceiba.detalle_pedido.modelo.dto.DtoDetallePedido;

import java.util.List;

public interface DaoDetallePedido {

    List<DtoDetallePedido> listar(Long idPedido);
}
