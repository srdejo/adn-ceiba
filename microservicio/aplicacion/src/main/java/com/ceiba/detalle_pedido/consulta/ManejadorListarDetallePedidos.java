package com.ceiba.detalle_pedido.consulta;

import com.ceiba.detalle_pedido.modelo.dto.DtoDetallePedido;
import com.ceiba.detalle_pedido.puerto.dao.DaoDetallePedido;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarDetallePedidos {

    private final DaoDetallePedido daoDetallePedido;

    public ManejadorListarDetallePedidos(DaoDetallePedido daoDetallePedido) {
        this.daoDetallePedido = daoDetallePedido;
    }

    public List<DtoDetallePedido> ejecutar(Long idPedido) {
        return this.daoDetallePedido.listar(idPedido);
    }
}
