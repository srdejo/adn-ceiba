package com.ceiba.detalle_pedido.comando.fabrica;

import com.ceiba.detalle_pedido.comando.ComandoDetallePedido;
import com.ceiba.detalle_pedido.modelo.entidad.DetallePedido;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FabricaDetallePedido {

    public DetallePedido crear(ComandoDetallePedido comandoDetallePedido) {
        return new DetallePedido(
                comandoDetallePedido.getId(),
                comandoDetallePedido.getIdPedido(),
                comandoDetallePedido.getIdProducto(),
                comandoDetallePedido.getCantidad(),
                comandoDetallePedido.getObservacion(),
                LocalDateTime.now()
        );
    }

}
