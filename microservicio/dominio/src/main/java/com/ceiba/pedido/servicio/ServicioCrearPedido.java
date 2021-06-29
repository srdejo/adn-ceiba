package com.ceiba.pedido.servicio;

import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;


public class ServicioCrearPedido {

    private final String EL_CLIENTE_NO_ENCONTRADO = "No sé encontró el cliente para asignar el pedido";
    private final Double VALOR_DOMICILIO = 2000.00;
    private final int CANTIDAD_PEDIDOS_DOMICILIO_GRATIS = 10;

    private final RepositorioPedido repositorioPedido;
    private final RepositorioCliente repositorioCliente;
    private final DaoPedido daoPedido;

    public ServicioCrearPedido(RepositorioPedido repositorioPedido, RepositorioCliente repositorioCliente,
                               DaoPedido daoPedido) {
        this.repositorioPedido = repositorioPedido;
        this.repositorioCliente = repositorioCliente;
        this.daoPedido = daoPedido;
    }

    public Long ejecutar(Pedido pedido) {
        validarClienteExiste(pedido.getIdCliente());
        calcularOfertaDomicilioGratis(pedido);
        pedido.asignarValorDomicilio(calcularOfertaDomicilioGratis(pedido));
        return this.repositorioPedido.crear(pedido);
    }

    private Double calcularOfertaDomicilioGratis(Pedido pedido) {
        if (this.daoPedido.contarPedidosEntregados(pedido.getIdCliente()) % CANTIDAD_PEDIDOS_DOMICILIO_GRATIS != 0) {
            return VALOR_DOMICILIO;
        }else {
            return 0.0;
        }
    }

    private void validarClienteExiste(Long clienteId) {
        if (!this.repositorioCliente.existe(clienteId)) {
            throw new ExcepcionSinDatos(EL_CLIENTE_NO_ENCONTRADO);
        }
    }

}
