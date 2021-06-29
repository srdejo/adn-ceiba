package com.ceiba.horario.servicio;

import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;


public class ServicioCrearHorario {

    private final RepositorioHorario repositorioHorario;

    public ServicioCrearHorario(RepositorioHorario repositorioHorario) {
        this.repositorioHorario = repositorioHorario;
    }

    public Long ejecutar(Horario horario) {
        return this.repositorioHorario.crear(horario);
    }
}
