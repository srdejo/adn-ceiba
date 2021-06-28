package com.ceiba.producto.servicio;

import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;

public class ServicioActualizarProducto {

    private final RepositorioProducto repositorioProducto;

    public ServicioActualizarProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public void ejecutar(Producto producto) {
        this.repositorioProducto.actualizar(producto);
    }

}
