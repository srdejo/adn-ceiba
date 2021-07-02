package com.ceiba.pedido.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.comando.fabrica.FabricaCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import com.ceiba.detalle_pedido.comando.ComandoDetallePedido;
import com.ceiba.detalle_pedido.comando.fabrica.FabricaDetallePedido;
import com.ceiba.detalle_pedido.servicio.ServicioCrearDetallePedido;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.comando.fabrica.FabricaPedido;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.modelo.enums.EstadoPedido;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import com.ceiba.pedido.servicio.ServicioConsultarPedido;
import com.ceiba.pedido.servicio.ServicioCrearPedido;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorCrearPedido implements ManejadorComandoRespuesta<ComandoPedido, ComandoRespuesta<DtoPedido>> {

    private final FabricaPedido fabricaPedido;
    private final FabricaDetallePedido fabricaDetallePedido;
    private final FabricaCliente fabricaCliente;
    private final ServicioCrearPedido servicioCrearPedido;
    private final ServicioCrearDetallePedido servicioCrearDetallePedido;
    private final ServicioConsultarPedido servicioConsultarPedido;
    private final DaoPedido daoPedido;
    private final ServicioCrearCliente servicioCrearCliente;

    public ManejadorCrearPedido(FabricaPedido fabricaPedido, FabricaDetallePedido fabricaDetallePedido,
                                FabricaCliente fabricaCliente, ServicioCrearPedido servicioCrearPedido,
                                ServicioCrearDetallePedido servicioCrearDetallePedido,
                                ServicioConsultarPedido servicioConsultarPedido, DaoPedido daoPedido,
                                ServicioCrearCliente servicioCrearCliente) {
        this.fabricaPedido = fabricaPedido;
        this.fabricaDetallePedido = fabricaDetallePedido;
        this.fabricaCliente = fabricaCliente;
        this.servicioCrearPedido = servicioCrearPedido;
        this.servicioCrearDetallePedido = servicioCrearDetallePedido;
        this.servicioConsultarPedido = servicioConsultarPedido;
        this.daoPedido = daoPedido;
        this.servicioCrearCliente = servicioCrearCliente;
    }

    public ComandoRespuesta<DtoPedido> ejecutar(ComandoPedido comandoPedido) {
        comandoPedido.setCliente(guardarCliente(comandoPedido.getCliente()));
        Long idPedido = guardarPedido(comandoPedido);
        guardarDetallePedido(comandoPedido.getDetallePedidos(), idPedido);
        return new ComandoRespuesta<>(this.servicioConsultarPedido.ejecutar(idPedido));
    }

    private ComandoCliente guardarCliente(ComandoCliente comandoCliente) {
        Cliente cliente = this.fabricaCliente.crear(comandoCliente);
        comandoCliente.setId(this.servicioCrearCliente.ejecutar(cliente));
        return comandoCliente;
    }

    private Long guardarPedido(ComandoPedido comandoPedido) {
        comandoPedido.setEstadoPedido(EstadoPedido.PENDIENTE.toString());
        Pedido pedido = this.fabricaPedido.crear(comandoPedido);
        return this.servicioCrearPedido.ejecutar(pedido);
    }

    private void guardarDetallePedido(List<ComandoDetallePedido> comandoDetallePedido, Long idPedido) {
        comandoDetallePedido.forEach(detallePedido -> {
            detallePedido.setIdPedido(idPedido);
            servicioCrearDetallePedido.ejecutar(fabricaDetallePedido.crear(detallePedido));
        });
    }
}
