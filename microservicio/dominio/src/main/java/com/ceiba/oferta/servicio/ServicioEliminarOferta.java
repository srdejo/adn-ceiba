package com.ceiba.oferta.servicio;

import com.ceiba.oferta.puerto.repositorio.RepositorioOferta;

public class ServicioEliminarOferta {

    private final RepositorioOferta repositorioOferta;

    public ServicioEliminarOferta(RepositorioOferta repositorioOferta) {
        this.repositorioOferta = repositorioOferta;
    }

    public void ejecutar(Long id) {
        this.repositorioOferta.eliminar(id);
    }
}
