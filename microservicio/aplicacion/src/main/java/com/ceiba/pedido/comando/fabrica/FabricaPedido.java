package com.ceiba.pedido.comando.fabrica;

import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FabricaPedido {

    public Pedido crear(ComandoPedido comandoPedido) {
        return new Pedido(
                comandoPedido.getId(),
                comandoPedido.getClienteId(),
                comandoPedido.getHora(),
                comandoPedido.getEstadoPedido(),
                LocalDateTime.now()
        );
    }

}
