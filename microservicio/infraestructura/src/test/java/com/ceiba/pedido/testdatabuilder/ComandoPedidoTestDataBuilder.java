package com.ceiba.pedido.testdatabuilder;

import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ComandoClienteTestDataBuilder;
import com.ceiba.detalle_pedido.comando.ComandoDetallePedido;
import com.ceiba.detalle_pedido.testdatabuilder.ComandoDetallePedidoTestDataBuilder;
import com.ceiba.pedido.comando.ComandoPedido;

import java.util.ArrayList;
import java.util.List;

public class ComandoPedidoTestDataBuilder {

    private Long id;
    private ComandoCliente cliente;
    private List<ComandoDetallePedido> detallePedidoList;
    private String estadoPedido;

    public ComandoPedidoTestDataBuilder() {
        id = null;
        cliente = new ComandoClienteTestDataBuilder().build();
        detallePedidoList = this.obtenerDetallePedidos();
    }


    public ComandoPedidoTestDataBuilder conEstado(String estadoPedido) {
        this.estadoPedido = estadoPedido;
        return this;
    }


    private List<ComandoDetallePedido> obtenerDetallePedidos() {
        List<ComandoDetallePedido> detallePedidos = new ArrayList<>();

        detallePedidos.add(new ComandoDetallePedidoTestDataBuilder().conIdProducto(1L).build());
        detallePedidos.add(new ComandoDetallePedidoTestDataBuilder().conIdProducto(1L).build());
        return detallePedidos;
    }

    public ComandoPedido build() {
        return new ComandoPedido(id, cliente, detallePedidoList, estadoPedido);
    }

}
