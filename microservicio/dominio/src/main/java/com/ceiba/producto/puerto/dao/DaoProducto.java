package com.ceiba.producto.puerto.dao;

import com.ceiba.producto.modelo.dto.DtoProducto;

import java.util.List;

public interface DaoProducto {

    List<DtoProducto> listar();

    DtoProducto obtenerProducto(Long id);
}
