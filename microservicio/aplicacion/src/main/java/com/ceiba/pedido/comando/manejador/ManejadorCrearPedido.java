package com.ceiba.pedido.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.comando.fabrica.FabricaPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.servicio.ServicioCrearPedido;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPedido implements ManejadorComandoRespuesta<ComandoPedido, ComandoRespuesta<Long>> {

    private final FabricaPedido fabricaPedido;
    private final ServicioCrearPedido servicioCrearPedido;

    public ManejadorCrearPedido(FabricaPedido fabricaPedido, ServicioCrearPedido servicioCrearPedido) {
        this.fabricaPedido = fabricaPedido;
        this.servicioCrearPedido = servicioCrearPedido;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoPedido comandoPedido) {
        Pedido pedido = this.fabricaPedido.crear(comandoPedido);
        return new ComandoRespuesta<>(this.servicioCrearPedido.ejecutar(pedido));
    }
}
