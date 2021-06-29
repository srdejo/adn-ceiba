package com.ceiba.comercio.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.comercio.modelo.entidad.Comercio;
import com.ceiba.comercio.puerto.repositorio.RepositorioComercio;
import com.ceiba.comercio.servicio.testdatabuilder.ComercioTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class ServicioActualizarComercioTest {

    @Test
    public void validarComercioExistenciaPreviaTest() {
        // arrange
        Comercio comercio = new ComercioTestDataBuilder().build();
        RepositorioComercio repositorioComercio = Mockito.mock(RepositorioComercio.class);
        Mockito.when(repositorioComercio.existe(Mockito.anyString())).thenReturn(true);
        ServicioActualizarComercio servicioActualizarComercio = new ServicioActualizarComercio(repositorioComercio);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarComercio.ejecutar(comercio), ExcepcionDuplicidad.class, "El comercio ya existe en el sistema");
    }


    @Test
    public void validarActualizarComercioTest() {
        // arrange
        Comercio comercio = new ComercioTestDataBuilder().build();
        RepositorioComercio repositorioComercio = Mockito.mock(RepositorioComercio.class);
        Mockito.when(repositorioComercio.existe(Mockito.anyString())).thenReturn(false);
        ServicioActualizarComercio servicioActualizarComercio = new ServicioActualizarComercio(repositorioComercio);
        // act - assert
        Assertions.assertDoesNotThrow(() -> servicioActualizarComercio.ejecutar(comercio));
    }
}
