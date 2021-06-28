package com.ceiba.oferta.puerto.repositorio;

import com.ceiba.oferta.modelo.entidad.Oferta;

public interface RepositorioOferta {
    /**
     * Permite crear un usuario
     * @param oferta
     * @return el id generado
     */
    Long crear(Oferta oferta);

    /**
     * Permite actualizar un oferta
     * @param oferta
     */
    void actualizar(Oferta oferta);

    /**
     * Permite eliminar un oferta
     * @param id
     */
    void eliminar(Long id);

}
