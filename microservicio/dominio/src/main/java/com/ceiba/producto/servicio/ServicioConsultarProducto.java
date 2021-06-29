package com.ceiba.producto.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.oferta.puerto.dao.DaoOferta;
import com.ceiba.producto.modelo.dto.DtoProducto;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.dao.DaoProducto;

import java.util.Objects;

public class ServicioConsultarProducto {

    private static final String EL_PRODUCTO_NO_EXISTE = "El producto consultado no existe";

    private final DaoProducto daoProducto;
    private final DaoOferta daoOferta;

    public ServicioConsultarProducto(DaoProducto daoProducto, DaoOferta daoOferta) {
        this.daoProducto = daoProducto;
        this.daoOferta = daoOferta;
    }

    public Producto ejecutar(Long id) {
        DtoProducto dtoProducto = obtenerProducto(id);
        Double valorProducto = obtenerValor(dtoProducto);
        return new Producto(id, dtoProducto.getNombre(), dtoProducto.getDescripcion(), valorProducto, dtoProducto.getIdComercio(), dtoProducto.getFechaCreacion());
    }

    private Double obtenerValor(DtoProducto dtoProducto) {
        Double valorProducto = this.daoOferta.consultarValorEnOferta(dtoProducto.getId());
        if (Objects.isNull(valorProducto)) {
            valorProducto = dtoProducto.getValor();
        }
        return valorProducto;
    }

    private DtoProducto obtenerProducto(Long idProducto) {
        DtoProducto dtoProducto = this.daoProducto.obtenerProducto(idProducto);
        if (Objects.isNull(dtoProducto)) {
            throw new ExcepcionValorInvalido(EL_PRODUCTO_NO_EXISTE);
        }
        return dtoProducto;
    }
}
