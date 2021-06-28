package com.ceiba.comercio.adaptador.dao;

import com.ceiba.comercio.modelo.dto.DtoComercio;
import com.ceiba.comercio.puerto.dao.DaoComercio;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoComercioMysql implements DaoComercio {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "comercio", value = "listar")
    private static String sqlListar;

    public DaoComercioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoComercio> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoComercio());
    }
}
