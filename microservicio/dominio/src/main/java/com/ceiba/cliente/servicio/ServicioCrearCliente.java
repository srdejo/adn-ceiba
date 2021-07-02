package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;


public class ServicioCrearCliente {

    private final RepositorioCliente repositorioCliente;

    public ServicioCrearCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public Long ejecutar(Cliente cliente) {
        if (this.repositorioCliente.existe(cliente.getCelular())) {
            Long id = repositorioCliente.obtenerId(cliente.getCelular());
            this.repositorioCliente.actualizar(new Cliente(id, cliente.getCelular(), cliente.getNombre(), cliente.getDireccion()));
            return id;
        } else {
            return this.repositorioCliente.crear(cliente);
        }
    }
}
