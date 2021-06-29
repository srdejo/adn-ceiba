package com.ceiba.detalle_pedido.puerto.repositorio;

import com.ceiba.detalle_pedido.modelo.entidad.DetallePedido;

public interface RepositorioDetallePedido {
    /**
     * Permite crear un detalle pedido
     *
     * @param detallePedido
     * @return el id generado
     */
    Long crear(DetallePedido detallePedido);

    /**
     * Permite actualizar un detalle pedido
     *
     * @param detallePedido
     */
    void actualizar(DetallePedido detallePedido);

    /**
     * Permite eliminar un detalle pedido
     *
     * @param id
     */
    void eliminar(Long id);

}
