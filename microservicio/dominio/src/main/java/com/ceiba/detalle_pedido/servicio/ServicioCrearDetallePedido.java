package com.ceiba.detalle_pedido.servicio;

import com.ceiba.detalle_pedido.modelo.entidad.DetallePedido;
import com.ceiba.detalle_pedido.puerto.repositorio.RepositorioDetallePedido;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.oferta.modelo.dto.DtoOferta;
import com.ceiba.oferta.puerto.dao.DaoOferta;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;

import java.util.List;
import java.util.Objects;


public class ServicioCrearDetallePedido {

    private static final String EL_HORARIO_NO_ES_VALIDO = "El comercio termino su horario de atencion";
    private static final String EL_PRODUCTO_NO_ES_VALIDO = "El producto añadadido no existe";

    private final RepositorioDetallePedido repositorioDetallePedido;
    private final RepositorioProducto repositorioProducto;
    private final RepositorioHorario repositorioHorario;
    private final DaoOferta daoOferta;

    public ServicioCrearDetallePedido(RepositorioDetallePedido repositorioDetallePedido, RepositorioProducto repositorioProducto,
                                      RepositorioHorario repositorioHorario, DaoOferta daoOferta) {
        this.repositorioDetallePedido = repositorioDetallePedido;
        this.repositorioProducto = repositorioProducto;
        this.repositorioHorario = repositorioHorario;
        this.daoOferta = daoOferta;
    }

    public Long ejecutar(DetallePedido detallePedido) {
        validarExistenciaProducto(detallePedido.getIdProducto());
        validarHorarioComercio(detallePedido.getIdProducto());
        detallePedido.asignarValorUnidad(obtenerValor(detallePedido.getIdProducto()));
        return this.repositorioDetallePedido.crear(detallePedido);
    }

    private void validarHorarioComercio(Long idProducto) {
        if (!this.repositorioHorario.estaAbierto(idProducto)) {
            throw new ExcepcionValorInvalido(EL_HORARIO_NO_ES_VALIDO);
        }
    }

    private void validarExistenciaProducto(Long idProducto) {
        if (!this.repositorioProducto.existe(idProducto)) {
            throw new ExcepcionValorInvalido(EL_PRODUCTO_NO_ES_VALIDO);
        }
    }

    private Double obtenerValor(Long idProducto) {
        Double valor = this.daoOferta.consultarValorEnOferta(idProducto);
        if(Objects.isNull(valor)){
            valor = this.repositorioProducto.obtenerValor(idProducto);
        }
        return valor;
    }

}
