package com.ceiba.producto.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.producto.modelo.dto.DtoProducto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoProducto implements RowMapper<DtoProducto>, MapperResult {

    @Override
    public DtoProducto mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String descripcion = resultSet.getString("descripcion");
        Double valor = resultSet.getDouble("valor");
        Long idComercio = resultSet.getLong("id_comercio");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha_creacion");

        return new DtoProducto(id, nombre, descripcion, valor, idComercio, fecha);
    }

}
