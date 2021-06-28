package com.ceiba.detalle_pedido.servicio;

import com.ceiba.detalle_pedido.puerto.repositorio.RepositorioDetallePedido;

public class ServicioEliminarDetallePedido {

    private final RepositorioDetallePedido repositorioDetallePedido;

    public ServicioEliminarDetallePedido(RepositorioDetallePedido repositorioDetallePedido) {
        this.repositorioDetallePedido = repositorioDetallePedido;
    }

    public void ejecutar(Long id) {
        this.repositorioDetallePedido.eliminar(id);
    }
}
