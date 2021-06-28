package com.ceiba.oferta.adaptador.repositorio;

import com.ceiba.oferta.modelo.entidad.Oferta;
import com.ceiba.oferta.puerto.repositorio.RepositorioOferta;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioOfertaMysql implements RepositorioOferta {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "oferta", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "oferta", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "oferta", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "oferta", value = "existe")
    private static String sqlExiste;

    public RepositorioOfertaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Oferta oferta) {
        return this.customNamedParameterJdbcTemplate.crear(oferta, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public void actualizar(Oferta oferta) {
        this.customNamedParameterJdbcTemplate.actualizar(oferta, sqlActualizar);
    }

}
