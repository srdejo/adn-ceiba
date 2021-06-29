package com.ceiba.comercio.puerto.repositorio;

import com.ceiba.comercio.modelo.entidad.Comercio;

public interface RepositorioComercio {
    /**
     * Permite crear un comercio
     *
     * @param comercio
     * @return el id generado
     */
    Long crear(Comercio comercio);

    /**
     * Permite actualizar un comercio
     *
     * @param comercio
     */
    void actualizar(Comercio comercio);

    /**
     * Permite validar si existe un comercio con un nombre
     *
     * @param celular
     * @return si existe o no
     */
    boolean existe(String celular);

}
