package com.ceiba.horario.adaptador.dao;

import com.ceiba.horario.modelo.dto.DtoHorario;
import com.ceiba.horario.puerto.dao.DaoHorario;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DaoHorarioMysql implements DaoHorario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "horario", value = "listar")
    private static String sqlListar;

    public DaoHorarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoHorario> listar() {
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("hora_actual", fechaHoraActual.toLocalTime());
        paramSource.addValue("dia_semana", fechaHoraActual.getDayOfWeek().getValue());

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, paramSource, new MapeoHorario());
    }
}
