package com.ceiba.detalle_pedido.adaptador.dao;

import com.ceiba.detalle_pedido.modelo.dto.DtoDetallePedido;
import com.ceiba.detalle_pedido.puerto.dao.DaoDetallePedido;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoDetallePedidoMysql implements DaoDetallePedido {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "detalle_pedido", value = "listar")
    private static String sqlListar;

    public DaoDetallePedidoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoDetallePedido> listar(Long idPedido) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idPedido", idPedido);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, paramSource, new MapeoDetallePedido());
    }
}
