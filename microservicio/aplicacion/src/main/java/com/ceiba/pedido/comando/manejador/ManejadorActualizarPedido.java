package com.ceiba.pedido.comando.manejador;

import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.comando.fabrica.FabricaCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.comando.fabrica.FabricaPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import com.ceiba.pedido.servicio.ServicioActualizarPedido;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarPedido implements ManejadorComando<ComandoPedido> {

    private final FabricaPedido fabricaPedido;
    private final ServicioActualizarPedido servicioActualizarPedido;
    private final FabricaCliente fabricaCliente;
    private final ServicioCrearCliente servicioCrearCliente;

    public ManejadorActualizarPedido(FabricaPedido fabricaPedido, ServicioActualizarPedido servicioActualizarPedido,
                                     FabricaCliente fabricaCliente, ServicioCrearCliente servicioCrearCliente) {

        this.fabricaPedido = fabricaPedido;
        this.servicioActualizarPedido = servicioActualizarPedido;
        this.fabricaCliente = fabricaCliente;
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
