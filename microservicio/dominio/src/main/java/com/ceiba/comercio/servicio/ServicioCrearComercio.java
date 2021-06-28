package com.ceiba.comercio.servicio;

import com.ceiba.comercio.modelo.entidad.Comercio;
import com.ceiba.comercio.puerto.repositorio.RepositorioComercio;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;


public class ServicioCrearComercio {

    private static final String EL_COMERCIO_YA_EXISTE_EN_EL_SISTEMA = "El comercio ya existe en el sistema";

    private final RepositorioComercio repositorioComercio;

    public ServicioCrearComercio(RepositorioComercio repositorioComercio) {
        this.repositorioComercio = repositorioComercio;
    }

    public Long ejecutar(Comercio cliente) {
        validarExistenciaPrevia(cliente);
        return this.repositorioComercio.crear(cliente);
    }

    private void validarExistenciaPrevia(Comercio cliente) {
        boolean existe = this.repositorioComercio.existe(cliente.getNombre());
        if (existe) {
            throw new ExcepcionDuplicidad(EL_COMERCIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
