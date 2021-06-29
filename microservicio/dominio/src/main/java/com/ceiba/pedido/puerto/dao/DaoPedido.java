package com.ceiba.pedido.puerto.dao;

import com.ceiba.pedido.modelo.dto.DtoPedido;

import java.util.List;
import java.util.Optional;

public interface DaoPedido {

    List<DtoPedido> listar();

    Integer contarPedidosEntregados(Long idCliente);

    DtoPedido buscarPedido(Long idPedido);
}
