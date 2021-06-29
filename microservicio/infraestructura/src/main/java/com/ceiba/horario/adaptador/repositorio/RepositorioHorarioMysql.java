package com.ceiba.horario.adaptador.repositorio;

import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class RepositorioHorarioMysql implements RepositorioHorario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "horario", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "horario", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "horario", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "horario", value = "horario_disponible")
    private static String sqlHorarioDisponible;

    public RepositorioHorarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Horario horario) {
        return this.customNamedParameterJdbcTemplate.crear(horario, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }


    @Override
    public boolean estaAbierto(Long idProducto) {
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("hora_actual", fechaHoraActual.toLocalTime());
        paramSource.addValue("dia_semana", fechaHoraActual.getDayOfWeek().getValue());
        paramSource.addValue("id_producto", idProducto);

        Integer horariosDisponibles = this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlHorarioDisponible, paramSource, Integer.class);
        return horariosDisponibles > 0;
    }

    @Override
    public void actualizar(Horario horario) {
        this.customNamedParameterJdbcTemplate.actualizar(horario, sqlActualizar);
    }

}
