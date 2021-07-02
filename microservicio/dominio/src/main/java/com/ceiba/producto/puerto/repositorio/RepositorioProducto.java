package com.ceiba.producto.puerto.repositorio;

import com.ceiba.producto.modelo.entidad.Producto;

public interface RepositorioProducto {
    /**
     * Permite crear un usuario
     *
     * @param producto
     * @return el id generado
     */
    Long crear(Producto producto);

    /**
     * Permite actualizar un producto
     *
     * @param producto
     */
    void actualizar(Producto producto);

    /**
     * Permite eliminar un Cliente
     *
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite consultar la existencia de un producto
     *
     * @param id
     * @return
     */
    boolean existe(Long id);


    /**
     * Permite consultar la existencia de un producto
     *
     * @param id
     * @return
     */
    Double obtenerValor(Long id);
}
