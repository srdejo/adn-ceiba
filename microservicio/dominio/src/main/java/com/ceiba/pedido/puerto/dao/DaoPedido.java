package com.ceiba.pedido.puerto.dao;

import com.ceiba.pedido.modelo.dto.DtoPedido;

import java.util.List;

public interface DaoPedido {

    List<DtoPedido> listar();

    Long contarPedidosEntregados(Long idCliente);
}
