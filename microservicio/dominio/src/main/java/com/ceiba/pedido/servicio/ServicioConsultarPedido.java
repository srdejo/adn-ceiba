package com.ceiba.pedido.servicio;

import com.ceiba.detalle_pedido.modelo.dto.DtoDetallePedido;
import com.ceiba.detalle_pedido.puerto.dao.DaoDetallePedido;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.puerto.dao.DaoPedido;

import java.util.List;

public class ServicioConsultarPedido {

    private final DaoPedido daoPedido;
    private final DaoDetallePedido daoDetallePedido;

    public ServicioConsultarPedido(DaoPedido daoPedido, DaoDetallePedido daoDetallePedido) {
        this.daoPedido = daoPedido;
        this.daoDetallePedido = daoDetallePedido;
    }

    public DtoPedido ejecutar(Long idPedido) {
        DtoPedido dtoPedido = daoPedido.buscar(idPedido);
        List<DtoDetallePedido> dtoDetallePedidos = daoDetallePedido.listar(idPedido);
        return new DtoPedido(dtoPedido.getId(),
                dtoPedido.getIdCliente(),
                dtoPedido.getHora(),
                dtoPedido.getEstadoPedido(),
                dtoPedido.getValorDomicilio(),
                dtoDetallePedidos,
                dtoPedido.getFechaCreacion());
    }
}
