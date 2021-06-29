package com.ceiba.oferta.servicio;

import com.ceiba.oferta.modelo.entidad.Oferta;
import com.ceiba.oferta.puerto.repositorio.RepositorioOferta;


public class ServicioCrearOferta {

    private final RepositorioOferta repositorioOferta;

    public ServicioCrearOferta(RepositorioOferta repositorioOferta) {
        this.repositorioOferta = repositorioOferta;
    }

    public Long ejecutar(Oferta oferta) {
        return this.repositorioOferta.crear(oferta);
    }
}
