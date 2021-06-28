package com.ceiba.comercio.adaptador.dao;

import com.ceiba.comercio.modelo.dto.DtoComercio;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoComercio implements RowMapper<DtoComercio>, MapperResult {

    @Override
    public DtoComercio mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        return new DtoComercio(id, nombre);
    }

}
