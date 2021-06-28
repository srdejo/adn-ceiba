package com.ceiba.pedido.comando;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.detalle_pedido.modelo.entidad.DetallePedido;
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
    private Long clienteId;
    private List<DetallePedido> detallePedidos;

}
