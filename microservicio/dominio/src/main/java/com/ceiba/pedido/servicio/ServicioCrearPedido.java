package com.ceiba.pedido.servicio;

import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.detalle_pedido.puerto.repositorio.RepositorioDetallePedido;
import com.ceiba.detalle_pedido.servicio.ServicioCrearDetallePedido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;


public class ServicioCrearPedido {

    private final static String EL_CLIENTE_NO_ENCONTRADO = "No sé encontró el cliente para asignar el pedido";
    private final static Double VALOR_DOMICILIO = 2000.00;
    private final static int CANTIDAD_PEDIDOS_DOMICILIO_GRATIS = 10;

    private final RepositorioPedido repositorioPedido;
    private final RepositorioCliente repositorioCliente;
    private final ServicioCrearDetallePedido servicioCrearDetallePedido;
    private final DaoPedido daoPedido;



    public ServicioCrearPedido(RepositorioPedido repositorioPedido, RepositorioCliente repositorioCliente,
                               ServicioCrearDetallePedido servicioCrearDetallePedido, DaoPedido daoPedido) {
        this.repositorioPedido = repositorioPedido;
        this.repositorioCliente = repositorioCliente;
        this.servicioCrearDetallePedido = servicioCrearDetallePedido;
        this.daoPedido = daoPedido;
    }

    public Long ejecutar(Pedido pedido) {
        validarClienteExiste(pedido.getClienteId());
        calcularOfertaDomicilioGratis(pedido);

        Long idPedido = this.repositorioPedido.crear(pedido);
        pedido.getDetallePedidos().forEach(detallePedido -> {
            detallePedido.setIdPedido(idPedido);
            this.servicioCrearDetallePedido.ejecutar(detallePedido);
        });

        return idPedido;
    }

    private void calcularOfertaDomicilioGratis(Pedido pedido) {
        if (this.daoPedido.contarPedidosEntregados(pedido.getClienteId()) % CANTIDAD_PEDIDOS_DOMICILIO_GRATIS != 0) {
            pedido.setValorDomicilio(VALOR_DOMICILIO);
        }
    }

    private void validarClienteExiste(Long clienteId){
        if (this.repositorioCliente.existe(clienteId)) {
            throw new ExcepcionValorObligatorio(EL_CLIENTE_NO_ENCONTRADO);
        }
    }

}
