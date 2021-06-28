package com.ceiba.detalle_pedido.adaptador.dao;

import com.ceiba.detalle_pedido.modelo.dto.DtoDetallePedido;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoDetallePedido implements RowMapper<DtoDetallePedido>, MapperResult {

    @Override
    public DtoDetallePedido mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String celular = resultSet.getString("celular");
        String nombre = resultSet.getString("nombre");
        String direccion = resultSet.getString("direccion");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha_creacion");

        return new DtoDetallePedido(id, celular, nombre, direccion, fecha);
    }

}
