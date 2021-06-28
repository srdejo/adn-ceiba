package com.ceiba.pedido.puerto.repositorio;

import com.ceiba.pedido.modelo.entidad.Pedido;

public interface RepositorioPedido {
    /**
     * Permite crear un usuario
     * @param pedido
     * @return el id generado
     */
    Long crear(Pedido pedido);

    /**
     * Permite actualizar un pedido
     * @param pedido
     */
    void actualizar(Pedido pedido);

    /**
     * Permite eliminar un pedido
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un pedido con un nombre
     * @param celular
     * @return si existe o no
     */
    boolean existe(String celular);
}
