package com.ceiba.pedido.servicio;

import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;

public class ServicioActualizarPedido {

    private static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El pedido ya existe en el sistema";

    private final RepositorioPedido repositorioPedido;

    public ServicioActualizarPedido(RepositorioPedido repositorioPedido) {
        this.repositorioPedido = repositorioPedido;
    }

    public void ejecutar(Pedido pedido) {
        this.repositorioPedido.actualizar(pedido);
    }
    
}
