package com.ceiba.oferta.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.oferta.modelo.dto.DtoOferta;
import com.ceiba.oferta.puerto.dao.DaoOferta;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DaoOfertaMysql implements DaoOferta {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "oferta", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "oferta", value = "consultarOferta")
    private static String sqlConsultarOferta;

    public DaoOfertaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoOferta> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoOferta());
    }

    @Override
    public Double consultarValorEnOferta(Long id) {
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id_producto", id);
        paramSource.addValue("hora_actual", fechaHoraActual.toLocalTime());
        paramSource.addValue("fecha_actual", fechaHoraActual.toLocalDate());
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlConsultarOferta, paramSource, Double.class);
    }
}
