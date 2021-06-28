package com.ceiba.cliente.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCliente {

    private Long id;
    private String celular;
    private String nombre;
    private String direccion;
}
