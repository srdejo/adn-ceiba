package com.ceiba.horario.adaptador.dao;

import com.ceiba.horario.modelo.dto.DtoHorario;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MapeoHorario implements RowMapper<DtoHorario>, MapperResult {

    @Override
    public DtoHorario mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        LocalTime horaInicial = extraerLocalTime(resultSet, "hora_inicial");
        LocalTime horaFinal = extraerLocalTime(resultSet, "hora_final");
        Integer diaSemana = resultSet.getInt("dia_semana");
        Long idComercio = resultSet.getLong("id_comercio");
        LocalDateTime fechaCreacion = extraerLocalDateTime(resultSet, "fecha_creacion");


        return new DtoHorario(id, horaInicial, horaFinal, idComercio, diaSemana, fechaCreacion);
    }

}
