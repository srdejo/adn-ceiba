package com.ceiba.producto.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoProducto {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double valor;
    private Long idComercio;
}
