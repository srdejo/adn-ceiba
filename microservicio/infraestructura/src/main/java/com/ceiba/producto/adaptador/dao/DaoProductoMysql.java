package com.ceiba.producto.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.producto.modelo.dto.DtoProducto;
import com.ceiba.producto.puerto.dao.DaoProducto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class DaoProductoMysql implements DaoProducto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "producto", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "producto", value = "listarPorId")
    private static String sqlListarPorId;

    @SqlStatement(namespace = "producto", value = "listarDisponibles")
    private static String sqlListarDisponibles;

    public DaoProductoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoProducto> listar(Long idComercio) {
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idComercio", idComercio);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, paramSource, new MapeoProducto());
    }

    @Override
    public List<DtoProducto> listarDisponibles() {
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("hora_actual", fechaHoraActual.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        paramSource.addValue("dia_semana", fechaHoraActual.getDayOfWeek().getValue());
        paramSource.addValue("dia", fechaHoraActual.toLocalDate());
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarDisponibles, paramSource, new MapeoProducto());
    }

    @Override
    public DtoProducto obtenerProducto(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorId, paramSource, new MapeoProducto())
                .get(0);
    }
}
