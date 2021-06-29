package com.ceiba.comercio.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.comercio.modelo.entidad.Comercio;
import com.ceiba.comercio.puerto.repositorio.RepositorioComercio;

import com.ceiba.comercio.servicio.testdatabuilder.ComercioTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearComercioTest {

    @Test
    public void validarComercioExistenciaPreviaTest() {
        // arrange
        Comercio comercio = new ComercioTestDataBuilder().build();
        RepositorioComercio repositorioComercio = Mockito.mock(RepositorioComercio.class);
        Mockito.when(repositorioComercio.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearComercio servicioCrearComercio = new ServicioCrearComercio(repositorioComercio);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearComercio.ejecutar(comercio), ExcepcionDuplicidad.class, "El comercio ya existe en el sistema");
    }
}
