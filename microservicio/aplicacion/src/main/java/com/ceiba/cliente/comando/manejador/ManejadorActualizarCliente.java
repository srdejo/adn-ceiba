package com.ceiba.cliente.comando.manejador;

import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.comando.fabrica.FabricaCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.ServicioActualizarCliente;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarCliente implements ManejadorComando<ComandoCliente> {

    private final FabricaCliente fabricaCliente;
    private final ServicioActualizarCliente servicioActualizarCliente;

    public ManejadorActualizarCliente(FabricaCliente fabricaCliente, ServicioActualizarCliente servicioActualizarCliente) {
        this.fabricaCliente = fabricaCliente;
        this.servicioActualizarCliente = servicioActualizarCliente;
    }

    public void ejecutar(ComandoCliente comandoCliente) {
        Cliente cliente = this.fabricaCliente.crear(comandoCliente);
        this.servicioActualizarCliente.ejecutar(cliente);
    }
}
