package com.ceiba.pedido.comando.fabrica;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import org.springframework.stereotype.Component;

@Component
public class FabricaPedido {

    public Pedido crear(ComandoPedido comandoPedido) {
        return new Pedido(
                comandoPedido.getId(),
                comandoPedido.getClienteId(),
                comandoPedido.getDetallePedidos()
        );
    }

}
