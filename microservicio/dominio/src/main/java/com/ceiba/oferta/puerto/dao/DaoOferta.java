package com.ceiba.oferta.puerto.dao;

import com.ceiba.oferta.modelo.dto.DtoOferta;

import java.util.List;

public interface DaoOferta {

    List<DtoOferta> listar();

    Double consultarValorEnOferta(Long id);
}
