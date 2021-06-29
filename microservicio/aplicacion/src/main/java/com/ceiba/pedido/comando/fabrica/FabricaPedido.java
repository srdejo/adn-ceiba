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
                comandoPedido.getIdCliente(),
                comandoPedido.getHora(),
                comandoPedido.getEstadoPedido().toString(),
                0.0,
                LocalDateTime.now()
        );
    }

}
