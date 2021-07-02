package com.ceiba.pedido.comando.manejador;

import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.comando.fabrica.FabricaCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import com.ceiba.detalle_pedido.comando.fabrica.FabricaDetallePedido;
import com.ceiba.detalle_pedido.servicio.ServicioCrearDetallePedido;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.comando.fabrica.FabricaPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import com.ceiba.pedido.servicio.ServicioActualizarPedido;
import com.ceiba.pedido.servicio.ServicioConsultarPedido;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarPedido implements ManejadorComando<ComandoPedido> {

    private final FabricaPedido fabricaPedido;
    private final ServicioActualizarPedido servicioActualizarPedido;
    private final FabricaDetallePedido fabricaDetallePedido;
    private final FabricaCliente fabricaCliente;
    private final ServicioCrearDetallePedido servicioCrearDetallePedido;
    private final ServicioConsultarPedido servicioConsultarPedido;
    private final DaoPedido daoPedido;
    private final ServicioCrearCliente servicioCrearCliente;

    public ManejadorActualizarPedido(FabricaPedido fabricaPedido, ServicioActualizarPedido servicioActualizarPedido,
                                     FabricaDetallePedido fabricaDetallePedido, FabricaCliente fabricaCliente,
                                     ServicioCrearDetallePedido servicioCrearDetallePedido, ServicioConsultarPedido servicioConsultarPedido,
                                     DaoPedido daoPedido, ServicioCrearCliente servicioCrearCliente) {

        this.fabricaPedido = fabricaPedido;
        this.servicioActualizarPedido = servicioActualizarPedido;
        this.fabricaDetallePedido = fabricaDetallePedido;
        this.fabricaCliente = fabricaCliente;
        this.servicioCrearDetallePedido = servicioCrearDetallePedido;
        this.servicioConsultarPedido = servicioConsultarPedido;
        this.daoPedido = daoPedido;
        this.servicioCrearCliente = servicioCrearCliente;
    }

    public void ejecutar(ComandoPedido comandoPedido) {
        comandoPedido.setCliente(guardarCliente(comandoPedido.getCliente()));
        Pedido pedido = fabricaPedido.crear(comandoPedido);
        this.servicioActualizarPedido.ejecutar(pedido);
    }

    private ComandoCliente guardarCliente(ComandoCliente comandoCliente) {
        Cliente cliente = this.fabricaCliente.crear(comandoCliente);
        comandoCliente.setId(this.servicioCrearCliente.ejecutar(cliente));
        return comandoCliente;
    }

}
