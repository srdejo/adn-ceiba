package com.ceiba.pedido.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPedidoMysql implements RepositorioPedido {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "pedido", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "pedido", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "pedido", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "pedido", value = "existe")
    private static String sqlExiste;


    public RepositorioPedidoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Pedido pedido) {
        return this.customNamedParameterJdbcTemplate.crear(pedido, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public void actualizar(Pedido pedido) {
        this.customNamedParameterJdbcTemplate.actualizar(pedido, sqlActualizar);
    }

}
