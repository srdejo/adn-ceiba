package com.ceiba.producto.puerto.dao;

import com.ceiba.producto.modelo.dto.DtoProducto;

import java.util.List;

public interface DaoProducto {

    List<DtoProducto> listar(Long idComercio);


    List<DtoProducto> listarDisponibles();

    DtoProducto obtenerProducto(Long id);
}
