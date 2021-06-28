package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarCliente {

    private static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El cliente ya existe en el sistema";

    private final RepositorioCliente repositorioCliente;

    public ServicioActualizarCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public void ejecutar(Cliente cliente) {
        validarExistenciaPrevia(cliente);
        this.repositorioCliente.actualizar(cliente);
    }

    private void validarExistenciaPrevia(Cliente cliente) {
        boolean existe = this.repositorioCliente.existe(cliente.getCelular());
        if (existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
