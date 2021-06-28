package com.ceiba.oferta.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.oferta.modelo.entidad.Oferta;
import com.ceiba.oferta.puerto.repositorio.RepositorioOferta;

public class ServicioActualizarOferta {

    private final RepositorioOferta repositorioOferta;

    public ServicioActualizarOferta(RepositorioOferta repositorioOferta) {
        this.repositorioOferta = repositorioOferta;
    }

    public void ejecutar(Oferta oferta) {
        this.repositorioOferta.actualizar(oferta);
    }

}
