package com.ceiba.pedido.consulta;

import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import org.springframework.stereotype.Component;

@Component
public class ManejadorConsultarPedido {

    private final DaoPedido daoPedido;

    public ManejadorConsultarPedido(DaoPedido daoPedido) {
        this.daoPedido = daoPedido;
    }

    public DtoPedido ejecutar(Long id) {
        return this.daoPedido.buscar(id);
    }
}
