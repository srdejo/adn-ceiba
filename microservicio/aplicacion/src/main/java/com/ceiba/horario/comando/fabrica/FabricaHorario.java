package com.ceiba.horario.comando.fabrica;

import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.comando.ComandoHorario;
import org.springframework.stereotype.Component;

@Component
public class FabricaHorario {

    public Horario crear(ComandoHorario comandoHorario) {
        return new Horario(
                comandoHorario.getId(),
                comandoHorario.getHoraInicial(),
                comandoHorario.getHoraFinal(),
                comandoHorario.getDiaSemana(),
                comandoHorario.getIdComercio()
        );
    }

}
