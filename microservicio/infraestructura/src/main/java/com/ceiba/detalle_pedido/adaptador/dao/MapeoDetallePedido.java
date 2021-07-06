package com.ceiba.detalle_pedido.adaptador.dao;


import com.ceiba.detalle_pedido.modelo.dto.DtoDetallePedido;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.producto.modelo.dto.DtoProducto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoDetallePedido implements RowMapper<DtoDetallePedido>, MapperResult {

    @Override
    public DtoDetallePedido mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long idPedido = resultSet.getLong("id_pedido");
        Long idProducto = resultSet.getLong("id_producto");
        Integer cantidad = resultSet.getInt("cantidad");
        Double valor = resultSet.getDouble("valor");
        String nota = resultSet.getString("nota");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha_creacion");
        String nombre = resultSet.getString("nombre");
        String descripcion = resultSet.getString("descripcion");
        Double valorProducto = resultSet.getDouble("valor_producto");
        
        return new DtoDetallePedido(id, idPedido,
                new DtoProducto(idProducto, nombre, descripcion, valorProducto, valor, null, null)
                , cantidad, valor, nota, fecha);
    }

}
