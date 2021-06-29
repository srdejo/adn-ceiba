package com.ceiba.cliente.puerto.dao;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.fail;

public class DaoClienteTest {


    @Test
    public void listarClienteTest() {
        // arrange
        DaoCliente daoCliente = Mockito.mock(DaoCliente.class);

        // act - assert
        try {
            daoCliente.listar();
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
