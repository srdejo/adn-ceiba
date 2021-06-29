package com.ceiba.pedido.modelo.entidad;

import com.ceiba.pedido.modelo.enums.EstadoPedido;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Pedido {
    private static final String SE_DEBE_SELECCIONAR_CLIENTE = "Se debe seleccionar un cliente";

    private Long id;
    private Long idCliente;
    private LocalTime hora;
    private EstadoPedido estadoPedido;
    private Double valorDomicilio;
    private LocalDateTime fechaCreacion;

    public Pedido(Long id, Long idCliente, LocalTime hora, EstadoPedido estadoPedido, LocalDateTime fechaCreacion) {
        validarObligatorio(idCliente, SE_DEBE_SELECCIONAR_CLIENTE);
        this.id = id;
        this.idCliente = idCliente;
        this.fechaCreacion = fechaCreacion;
        this.valorDomicilio = 0.0;
    }

    public void setValorDomicilio(Double valorDomicilio) {
        this.valorDomicilio = valorDomicilio;
    }
}
