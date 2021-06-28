package com.ceiba.pedido.modelo.entidad;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.detalle_pedido.modelo.entidad.DetallePedido;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Pedido {
    private static final String SE_DEBE_SELECCIONAR_CLIENTE = "Se debe seleccionar un cliente";
    private static final String SE_DEBE_INGRESAR_HORA = "Se debe ingresar la hora";
    private static final String SE_DEBE_INGRESAR_ESTADO = "Se debe ingresar el estado";
    private static final String SE_DEBE_INGRESAR_VALOR_DOMICILIO = "Se debe ingresar el valor del domicilio";
    private static final String SE_DEBE_INGRESAR_VALOR_DOMICILIO_VALIDO = "Se debe ingresar un valor del domicilio valido";

    private Long id;
    private Long clienteId;
    private List<DetallePedido> detallePedidos;
    private LocalDateTime fechaCreacion;
    private Double valorDomicilio;

    public Pedido(Long id, Long clienteId, List<DetallePedido> detallePedidos) {
        this.id = id;
        this.clienteId = clienteId;
        this.detallePedidos = detallePedidos;
        this.fechaCreacion = LocalDateTime.now();
    }

    public void setValorDomicilio(Double valorDomicilio) {
        this.valorDomicilio = valorDomicilio;
    }
}
