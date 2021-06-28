package com.ceiba.horario.puerto.repositorio;

import com.ceiba.horario.modelo.entidad.Horario;

import java.time.LocalTime;

public interface RepositorioHorario {
    /**
     * Permite crear un usuario
     * @param horario
     * @return el id generado
     */
    Long crear(Horario horario);

    /**
     * Permite actualizar un horario
     * @param horario
     */
    void actualizar(Horario horario);

    /**
     * Permite eliminar un Horario
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si un comercio se
     * encuentra abierto a la hora de la consulta
     * @param idComercio
     * @return
     */
    boolean estaAbierto(Long idComercio);
}
