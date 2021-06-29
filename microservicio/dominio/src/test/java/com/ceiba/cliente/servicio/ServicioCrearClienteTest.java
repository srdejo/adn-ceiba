package com.ceiba.cliente.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearClienteTest {

    @Test
    public void validarClienteExistenciaPreviaTest() {
        // arrange
        Cliente cliente = new ClienteTestDataBuilder().build();
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearCliente servicioCrearCliente = new ServicioCrearCliente(repositorioCliente);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCliente.ejecutar(cliente), ExcepcionDuplicidad.class, "El cliente ya existe en el sistema");
    }
}
