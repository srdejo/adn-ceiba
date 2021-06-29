package com.ceiba.detalle_pedido.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.detalle_pedido.comando.ComandoDetallePedido;
import com.ceiba.detalle_pedido.comando.fabrica.FabricaDetallePedido;
import com.ceiba.detalle_pedido.modelo.entidad.DetallePedido;
import com.ceiba.detalle_pedido.servicio.ServicioCrearDetallePedido;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearDetallePedido implements ManejadorComandoRespuesta<ComandoDetallePedido, ComandoRespuesta<Long>> {

    private final FabricaDetallePedido fabricaDetallePedido;
    private final ServicioCrearDetallePedido servicioCrearDetallePedido;

    public ManejadorCrearDetallePedido(FabricaDetallePedido fabricaDetallePedido, ServicioCrearDetallePedido servicioCrearDetallePedido) {
        this.fabricaDetallePedido = fabricaDetallePedido;
        this.servicioCrearDetallePedido = servicioCrearDetallePedido;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoDetallePedido comandoDetallePedido) {
        DetallePedido detallePedido = this.fabricaDetallePedido.crear(comandoDetallePedido);
        return new ComandoRespuesta<>(this.servicioCrearDetallePedido.ejecutar(detallePedido));
    }
}
