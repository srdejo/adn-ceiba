package com.ceiba.producto.puerto.repositorio;

import com.ceiba.producto.modelo.entidad.Producto;

public interface RepositorioProducto {
    /**
     * Permite crear un usuario
     * @param cliente
     * @return el id generado
     */
    Long crear(Producto cliente);

    /**
     * Permite actualizar un cliente
     * @param cliente
     */
    void actualizar(Producto cliente);

    /**
     * Permite eliminar un Cliente
     * @param id
     */
    void eliminar(Long id);

}
