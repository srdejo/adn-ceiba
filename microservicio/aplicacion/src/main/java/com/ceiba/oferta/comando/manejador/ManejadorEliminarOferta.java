package com.ceiba.oferta.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.oferta.servicio.ServicioEliminarOferta;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarOferta implements ManejadorComando<Long> {

    private final ServicioEliminarOferta servicioEliminarOferta;

    public ManejadorEliminarOferta(ServicioEliminarOferta servicioEliminarOferta) {
        this.servicioEliminarOferta = servicioEliminarOferta;
    }

    public void ejecutar(Long idOferta) {
        this.servicioEliminarOferta.ejecutar(idOferta);
    }
}
