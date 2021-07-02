package com.ceiba.pedido.servicio;

import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.detalle_pedido.modelo.dto.DtoDetallePedido;
import com.ceiba.detalle_pedido.puerto.dao.DaoDetallePedido;
import com.ceiba.detalle_pedido.puerto.repositorio.RepositorioDetallePedido;
import com.ceiba.detalle_pedido.servicio.ServicioCrearDetallePedido;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.producto.puerto.dao.DaoProducto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;

import java.util.List;


public class ServicioCrearPedido {

    private static final String EL_CLIENTE_NO_ENCONTRADO = "No sé encontró el cliente para asignar el pedido";
    private static final Double VALOR_DOMICILIO = 2000.00;
    private static final int CANTIDAD_PEDIDOS_DOMICILIO_GRATIS = 10;

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
        pedido.asignarValorDomicilio(calcularOfertaDomicilioGratis(pedido));
        return this.repositorioPedido.crear(pedido);
    }

    private Double calcularOfertaDomicilioGratis(Pedido pedido) {
        int cantidadDomicilios = this.daoPedido.contarPedidosEntregados(pedido.getIdCliente());
        if (cantidadDomicilios == 0 || cantidadDomicilios % CANTIDAD_PEDIDOS_DOMICILIO_GRATIS != 0) {
            return VALOR_DOMICILIO;
        } else {
            return 0.0;
        }
    }

    private void validarClienteExiste(Long clienteId) {
        if (!this.repositorioCliente.existe(clienteId)) {
            throw new ExcepcionSinDatos(EL_CLIENTE_NO_ENCONTRADO);
        }
    }

}
