package com.ceiba.horario.consulta;

import com.ceiba.horario.modelo.dto.DtoHorario;
import com.ceiba.horario.puerto.dao.DaoHorario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarHorarios {

    private final DaoHorario daoHorario;

    public ManejadorListarHorarios(DaoHorario daoHorario) {
        this.daoHorario = daoHorario;
    }

    public List<DtoHorario> ejecutar() {
        return this.daoHorario.listar();
    }
}
