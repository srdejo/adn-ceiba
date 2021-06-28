package com.ceiba.producto.servicio;

import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;


public class ServicioCrearProducto {

    private final RepositorioProducto repositorioProducto;

    public ServicioCrearProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public Long ejecutar(Producto producto) {
        return this.repositorioProducto.crear(producto);
    }


}
