package com.ceiba.detalle_pedido.servicio;

import com.ceiba.detalle_pedido.modelo.entidad.DetallePedido;
import com.ceiba.detalle_pedido.puerto.repositorio.RepositorioDetallePedido;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.servicio.ServicioConsultarProducto;


public class ServicioCrearDetallePedido {

    private static final String EL_HORARIO_NO_ES_VALIDO = "El comercio termino su horario de atencion";

    private final RepositorioDetallePedido repositorioDetallePedido;
    private final ServicioConsultarProducto servicioConsultarProducto;
    private final RepositorioHorario repositorioHorario;

    public ServicioCrearDetallePedido(RepositorioDetallePedido repositorioDetallePedido, ServicioConsultarProducto servicioConsultarProducto, RepositorioHorario repositorioHorario) {
        this.repositorioDetallePedido = repositorioDetallePedido;
        this.servicioConsultarProducto = servicioConsultarProducto;
        this.repositorioHorario = repositorioHorario;
    }

    public Long ejecutar(DetallePedido detallePedido) {
        Producto producto = this.servicioConsultarProducto.ejecutar(detallePedido.getIdProducto());
        if (this.repositorioHorario.estaAbierto(producto.getIdComercio())) {
            return this.repositorioDetallePedido.crear(detallePedido);
        }
        return null;
    }

}
