package com.ceiba.detalle_pedido.comando.manejador;

import com.ceiba.detalle_pedido.servicio.ServicioEliminarDetallePedido;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarDetallePedido implements ManejadorComando<Long> {

    private final ServicioEliminarDetallePedido servicioEliminarDetallePedido;

    public ManejadorEliminarDetallePedido(ServicioEliminarDetallePedido servicioEliminarDetallePedido) {
        this.servicioEliminarDetallePedido = servicioEliminarDetallePedido;
    }

    public void ejecutar(Long idDetallePedido) {
        this.servicioEliminarDetallePedido.ejecutar(idDetallePedido);
    }
}
