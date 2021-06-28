package com.ceiba.pedido.consulta;

import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPedidos {

    private final DaoPedido daoPedido;

    public ManejadorListarPedidos(DaoPedido daoPedido) {
        this.daoPedido = daoPedido;
    }

    public List<DtoPedido> ejecutar() {
        return this.daoPedido.listar();
    }
}
