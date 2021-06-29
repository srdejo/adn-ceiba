package com.ceiba.pedido.comando;

import com.ceiba.pedido.modelo.enums.EstadoPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPedido {

    private Long id;
    private Long clienteId;
    private LocalTime hora;
    private EstadoPedido estadoPedido;

}
