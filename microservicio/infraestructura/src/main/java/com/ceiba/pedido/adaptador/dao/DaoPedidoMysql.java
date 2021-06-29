package com.ceiba.pedido.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DaoPedidoMysql implements DaoPedido {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "pedido", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "pedido", value = "contarPedido")
    private static String sqlContarPedido;

    @SqlStatement(namespace = "pedido", value = "buscar")
    private static String sqlBuscar;

    public DaoPedidoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPedido> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoPedido());
    }

    @Override
    public Integer contarPedidosEntregados(Long idCliente) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id_cliente", idCliente);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlContarPedido, paramSource, Integer.class);
    }

    @Override
    public DtoPedido buscarPedido(Long idPedido) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", idPedido);
        List<DtoPedido> dtoPedidos = this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlBuscar, paramSource, new MapeoPedido());
        if (dtoPedidos.size() > 0) {
            return dtoPedidos.get(0);
        }
        return null;
    }
}
