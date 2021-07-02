package com.ceiba.cliente.adaptador.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioClienteMysql implements RepositorioCliente {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "cliente", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "cliente", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "cliente", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "cliente", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "cliente", value = "existeId")
    private static String sqlExisteId;

    @SqlStatement(namespace = "cliente", value = "obtener")
    private static String sqlObtener;

    public RepositorioClienteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Cliente cliente) {
        return this.customNamedParameterJdbcTemplate.crear(cliente, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, mapearId(id));
    }

    @Override
    public boolean existe(String celular) {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, mapearCelular(celular), Boolean.class);
    }

    @Override
    public Long obtenerId(String celular) {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtener, mapearCelular(celular), Long.class);
    }

    @Override
    public boolean existe(Long id) {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteId, mapearId(id), Boolean.class);
    }

    @Override
    public void actualizar(Cliente cliente) {
        this.customNamedParameterJdbcTemplate.actualizar(cliente, sqlActualizar);
    }

    private MapSqlParameterSource mapearCelular(String celular) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("celular", celular);
        return paramSource;
    }

    private MapSqlParameterSource mapearId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return paramSource;
    }

}
