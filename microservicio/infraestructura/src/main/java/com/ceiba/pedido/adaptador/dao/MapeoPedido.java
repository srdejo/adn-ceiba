package com.ceiba.pedido.adaptador.dao;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.modelo.enums.EstadoPedido;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MapeoPedido implements RowMapper<DtoPedido>, MapperResult {

    @Override
    public DtoPedido mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long idCliente = resultSet.getLong("id_cliente");
        EstadoPedido estadoPedido = EstadoPedido.valueOf(resultSet.getString("estado_pedido"));
        LocalTime hora = extraerLocalTime(resultSet, "hora");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha_creacion");
        Double valorDomicilio = resultSet.getDouble("valor_domicilio");
        String celular = resultSet.getString("celular");
        String nonbre = resultSet.getString("nombre");
        String direccion = resultSet.getString("direccion");

        return new DtoPedido(id, hora, estadoPedido, valorDomicilio, null, fecha
                , new DtoCliente(idCliente, celular, nonbre, direccion));
    }

}
