package com.ceiba.pedido.modelo.entidad;

import com.ceiba.detalle_pedido.modelo.entidad.DetallePedido;
import com.ceiba.pedido.modelo.enums.EstadoPedido;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Pedido {
    private static final String SE_DEBE_SELECCIONAR_CLIENTE = "Se debe seleccionar un cliente";

    private Long id;
    private Long idCliente;
    private LocalTime hora;
    private String estadoPedido;
    private Double valorDomicilio;
    private LocalDateTime fechaCreacion;

    public Pedido(Long id, Long idCliente, LocalTime hora, String estadoPedido, Double valorDomicilio, LocalDateTime fechaCreacion) {
        validarObligatorio(idCliente, SE_DEBE_SELECCIONAR_CLIENTE);
        this.id = id;
        this.idCliente = idCliente;
        this.fechaCreacion = fechaCreacion;
        this.valorDomicilio = 0.0;
        this.hora = hora;
        this.estadoPedido = estadoPedido;
        this.valorDomicilio = valorDomicilio;
    }

    public void asignarValorDomicilio(Double valorDomicilio){
        this.valorDomicilio = valorDomicilio;
    }

    public void asignarEstadoPedido(EstadoPedido estadoPedido){
        this.estadoPedido = estadoPedido.toString();
    }
}
