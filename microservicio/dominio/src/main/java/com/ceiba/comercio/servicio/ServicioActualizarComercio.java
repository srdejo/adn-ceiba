package com.ceiba.comercio.servicio;

import com.ceiba.comercio.modelo.entidad.Comercio;
import com.ceiba.comercio.puerto.repositorio.RepositorioComercio;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarComercio {

    private static final String EL_COMERCIO_YA_EXISTE_EN_EL_SISTEMA = "El comercio ya existe en el sistema";

    private final RepositorioComercio repositorioCliente;

    public ServicioActualizarComercio(RepositorioComercio repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public void ejecutar(Comercio comercio) {
        validarExistenciaPrevia(comercio);
        this.repositorioCliente.actualizar(comercio);
    }

    private void validarExistenciaPrevia(Comercio comercio) {
        boolean existe = this.repositorioCliente.existe(comercio.getNombre());
        if (existe) {
            throw new ExcepcionDuplicidad(EL_COMERCIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
