package com.ceiba.producto.servicio;

import com.ceiba.horario.puerto.dao.DaoHorario;
import com.ceiba.oferta.puerto.dao.DaoOferta;
import com.ceiba.producto.modelo.dto.DtoProducto;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.dao.DaoProducto;

import java.util.Objects;

public class ServicioConsultarProducto {

    private final DaoProducto daoProducto;
    private final DaoOferta daoOferta;
    private final DaoHorario daoHorario;

    public ServicioConsultarProducto(DaoProducto daoProducto, DaoHorario daoHorario, DaoOferta daoOferta) {
        this.daoProducto = daoProducto;
        this.daoOferta = daoOferta;
        this.daoHorario = daoHorario;
    }

    public Producto ejecutar(Long id) {
        DtoProducto dtoProducto = this.daoProducto.obtenerProducto(id);
        Double valorProducto = obtenerValor(dtoProducto);
        return new Producto(id, dtoProducto.getNombre(), dtoProducto.getDescripcion(), valorProducto, dtoProducto.getIdComercio());
    }

    private Double obtenerValor(DtoProducto dtoProducto) {
        Double valorProducto = this.daoOferta.consultarValorEnOferta(dtoProducto.getId());
        if (Objects.isNull(valorProducto)) {
            valorProducto = dtoProducto.getValor();
        }
        return valorProducto;
    }

}
