package com.ceiba.pedido.comando;

import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.detalle_pedido.comando.ComandoDetallePedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPedido {

    private Long id;
    private ComandoCliente cliente;
    private List<ComandoDetallePedido> detallePedidos;
    private String estadoPedido;

}
