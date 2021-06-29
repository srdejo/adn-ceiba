package com.ceiba.oferta.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.oferta.modelo.dto.DtoOferta;
import com.ceiba.producto.modelo.entidad.Producto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MapeoOferta implements RowMapper<DtoOferta>, MapperResult {

    @Override
    public DtoOferta mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        LocalTime horaInicial = extraerLocalTime(resultSet, "hora_inicial");
        LocalTime horaFinal = extraerLocalTime(resultSet, "hora_final");
        LocalDate dia = extraerLocalDate(resultSet, "dia");
        Double valor = resultSet.getDouble("valor_oferta");
        Long idProducto = resultSet.getLong("id_producto");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha_creacion");
        String nombre = resultSet.getString("nombre");
        String descripcion = resultSet.getString("descripcion");
        Double valorProducto = resultSet.getDouble( "valor");
        Long idComercio = resultSet.getLong("id_comercio");
        LocalDateTime fechaCreacionProducto = extraerLocalDateTime(resultSet, "fecha_creacion_producto");

        return new DtoOferta(id, horaInicial, horaFinal, dia, valor, idProducto, fecha,
                new Producto(idProducto, nombre, descripcion, valorProducto, idComercio, fechaCreacionProducto));
    }

}
