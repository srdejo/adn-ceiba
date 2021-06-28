package com.ceiba.detalle_pedido.adaptador.repositorio;

import com.ceiba.detalle_pedido.modelo.entidad.DetallePedido;
import com.ceiba.detalle_pedido.puerto.repositorio.RepositorioDetallePedido;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioDetallePedidoMysql implements RepositorioDetallePedido {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "detalle_pedido", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "detalle_pedido", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "detalle_pedido", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "detalle_pedido", value = "existe")
    private static String sqlExiste;

    public RepositorioDetallePedidoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(DetallePedido detalle_pedido) {
        return this.customNamedParameterJdbcTemplate.crear(detalle_pedido, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public void actualizar(DetallePedido detalle_pedido) {
        this.customNamedParameterJdbcTemplate.actualizar(detalle_pedido, sqlActualizar);
    }

}
