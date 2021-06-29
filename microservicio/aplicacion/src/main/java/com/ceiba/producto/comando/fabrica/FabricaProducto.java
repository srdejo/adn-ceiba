package com.ceiba.producto.comando.fabrica;

import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.comando.ComandoProducto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FabricaProducto {

    public Producto crear(ComandoProducto comandoProducto) {
        return new Producto(
                comandoProducto.getId(),
                comandoProducto.getNombre(),
                comandoProducto.getDescripcion(),
                comandoProducto.getValor(),
                comandoProducto.getIdComercio(),
                LocalDateTime.now()
        );
    }

}
