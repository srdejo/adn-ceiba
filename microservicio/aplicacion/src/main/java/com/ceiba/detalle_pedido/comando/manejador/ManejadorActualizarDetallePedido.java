package com.ceiba.detalle_pedido.comando.manejador;

import com.ceiba.detalle_pedido.comando.ComandoDetallePedido;
import com.ceiba.detalle_pedido.comando.fabrica.FabricaDetallePedido;
import com.ceiba.detalle_pedido.modelo.entidad.DetallePedido;
import com.ceiba.detalle_pedido.servicio.ServicioActualizarDetallePedido;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarDetallePedido implements ManejadorComando<ComandoDetallePedido> {

    private final FabricaDetallePedido fabricaDetallePedido;
    private final ServicioActualizarDetallePedido servicioActualizarDetallePedido;

    public ManejadorActualizarDetallePedido(FabricaDetallePedido fabricaDetallePedido, ServicioActualizarDetallePedido servicioActualizarDetallePedido) {
        this.fabricaDetallePedido = fabricaDetallePedido;
        this.servicioActualizarDetallePedido = servicioActualizarDetallePedido;
    }

    public void ejecutar(ComandoDetallePedido comandoDetallePedido) {
        DetallePedido detallePedido = this.fabricaDetallePedido.crear(comandoDetallePedido);
        this.servicioActualizarDetallePedido.ejecutar(detallePedido);
    }
}
