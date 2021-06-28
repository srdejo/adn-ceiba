package com.ceiba.horario.comando.manejador;

import com.ceiba.horario.servicio.ServicioEliminarHorario;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarHorario implements ManejadorComando<Long> {

    private final ServicioEliminarHorario servicioEliminarHorario;

    public ManejadorEliminarHorario(ServicioEliminarHorario servicioEliminarHorario) {
        this.servicioEliminarHorario = servicioEliminarHorario;
    }

    public void ejecutar(Long idHorario) {
        this.servicioEliminarHorario.ejecutar(idHorario);
    }
}
