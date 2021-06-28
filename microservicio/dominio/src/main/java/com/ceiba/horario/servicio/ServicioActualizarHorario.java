package com.ceiba.horario.servicio;

import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;

public class ServicioActualizarHorario {

    private final RepositorioHorario repositorioHorario;

    public ServicioActualizarHorario(RepositorioHorario repositorioHorario) {
        this.repositorioHorario = repositorioHorario;
    }

    public void ejecutar(Horario horario) {
        this.repositorioHorario.actualizar(horario);
    }
}
