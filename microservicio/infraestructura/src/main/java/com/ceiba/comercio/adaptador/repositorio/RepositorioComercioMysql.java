package com.ceiba.comercio.adaptador.repositorio;

import com.ceiba.comercio.modelo.entidad.Comercio;
import com.ceiba.comercio.puerto.repositorio.RepositorioComercio;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioComercioMysql implements RepositorioComercio {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "comercio", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "comercio", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "comercio", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "comercio", value = "existe")
    private static String sqlExiste;

    public RepositorioComercioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Comercio comercio) {
        return this.customNamedParameterJdbcTemplate.crear(comercio, sqlCrear);
    }

    @Override
    public boolean existe(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Comercio comercio) {
        this.customNamedParameterJdbcTemplate.actualizar(comercio, sqlActualizar);
    }

}
