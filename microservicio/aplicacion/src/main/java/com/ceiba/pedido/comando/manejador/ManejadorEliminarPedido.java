package com.ceiba.pedido.comando.manejador;

import com.ceiba.pedido.servicio.ServicioEliminarPedido;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarPedido implements ManejadorComando<Long> {

    private final ServicioEliminarPedido servicioEliminarPedido;

    public ManejadorEliminarPedido(ServicioEliminarPedido servicioEliminarPedido) {
        this.servicioEliminarPedido = servicioEliminarPedido;
    }

    public void ejecutar(Long idPedido) {
        this.servicioEliminarPedido.ejecutar(idPedido);
    }
}
