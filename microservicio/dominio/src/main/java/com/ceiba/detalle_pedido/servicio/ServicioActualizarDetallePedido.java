package com.ceiba.detalle_pedido.servicio;

import com.ceiba.detalle_pedido.modelo.entidad.DetallePedido;
import com.ceiba.detalle_pedido.puerto.repositorio.RepositorioDetallePedido;

public class ServicioActualizarDetallePedido {

    private final RepositorioDetallePedido repositorioCliente;

    public ServicioActualizarDetallePedido(RepositorioDetallePedido repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public void ejecutar(DetallePedido detallePedido) {
        this.repositorioCliente.actualizar(detallePedido);
    }

}
