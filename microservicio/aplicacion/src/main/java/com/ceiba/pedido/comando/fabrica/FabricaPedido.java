package com.ceiba.pedido.comando.fabrica;

import com.ceiba.detalle_pedido.modelo.entidad.DetallePedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.modelo.enums.EstadoPedido;
import com.ceiba.pedido.comando.ComandoPedido;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class FabricaPedido {

    public Pedido crear(ComandoPedido comandoPedido) {
        return new Pedido(
                comandoPedido.getId(),
                comandoPedido.getCliente().getId(),
                LocalTime.now(),
                comandoPedido.getEstadoPedido(),
                0.0,
                LocalDateTime.now()
        );
    }

}
