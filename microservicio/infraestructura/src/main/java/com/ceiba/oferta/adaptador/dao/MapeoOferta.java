package com.ceiba.oferta.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.oferta.modelo.dto.DtoOferta;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MapeoOferta implements RowMapper<DtoOferta>, MapperResult {

    @Override
    public DtoOferta mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Time horaInicial = resultSet.getTime("hora_inicial");
        Time horaFinal = resultSet.getTime("hora_final");
        LocalDate dia = extraerLocalDate(resultSet, "dia");
        Double valor = resultSet.getDouble("valor");
        Long idProducto = resultSet.getLong("id_producto");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha_creacion");

        return new DtoOferta(id, horaInicial, horaFinal, dia, valor, idProducto, fecha);
    }

}
