package com.ceiba.cliente.puerto.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;

public interface RepositorioCliente {
    /**
     * Permite crear un usuario
     *
     * @param cliente
     * @return el id generado
     */
    Long crear(Cliente cliente);

    /**
     * Permite actualizar un cliente
     *
     * @param cliente
     */
    void actualizar(Cliente cliente);

    /**
     * Permite eliminar un Cliente
     *
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un Cliente con un id
     *
     * @param celular
     * @return si existe o no
     */
    boolean existe(String celular);

    /**
     * Si un cliente existe obtenerlo por Id
     * @param celular
     * @return
     */
    Long obtenerId(String celular);
    /**
     * Permite validar si existe un ususario
     *
     * @param id
     * @return
     */
    boolean existe(Long id);
}
