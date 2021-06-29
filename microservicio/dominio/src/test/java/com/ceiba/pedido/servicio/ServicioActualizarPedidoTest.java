package com.ceiba.pedido.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.pedido.servicio.testdatabuilder.PedidoTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Random;

public class ServicioActualizarPedidoTest {

    @Test
    public void validarPedidoConDomicilio() {
        // arrange
        Double valorDomicilio = 2000.00;
        Random random = new Random();
        Pedido pedido = new PedidoTestDataBuilder().conClienteId(random.nextLong()).build();
        DaoPedido daoPedido = Mockito.mock(DaoPedido.class);
        RepositorioPedido repositorioPedido = Mockito.mock(RepositorioPedido.class);
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);

        Mockito.when(daoPedido.contarPedidosEntregados(pedido.getIdCliente()))
                .thenReturn(8);
        Mockito.when(repositorioCliente.existe(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarPedido servicioActualizarPedido = new ServicioActualizarPedido(repositorioPedido, repositorioCliente, daoPedido);
        // act
        servicioActualizarPedido.ejecutar(pedido);
        // assert
        Assert.assertEquals(pedido.getValorDomicilio(), valorDomicilio);
    }


    @Test
    public void validarPedidoDomicilioGratisTest() {
        Double valorDomicilio = 0.0;
        Random random = new Random();
        Pedido pedido = new PedidoTestDataBuilder().conClienteId(random.nextLong()).build();
        DaoPedido daoPedido = Mockito.mock(DaoPedido.class);
        RepositorioPedido repositorioPedido = Mockito.mock(RepositorioPedido.class);
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);

        Mockito.when(daoPedido.contarPedidosEntregados(pedido.getIdCliente()))
                .thenReturn(20);
        Mockito.when(repositorioCliente.existe(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarPedido servicioActualizarPedido = new ServicioActualizarPedido(repositorioPedido, repositorioCliente, daoPedido);
        // act
        servicioActualizarPedido.ejecutar(pedido);
        // assert
        Assert.assertEquals(pedido.getValorDomicilio(), valorDomicilio);

    }

    @Test
    public void validarClienteExisteTest() {
        // arrange
        Random random = new Random();
        Pedido pedido = new PedidoTestDataBuilder().conClienteId(random.nextLong()).build();
        DaoPedido daoPedido = Mockito.mock(DaoPedido.class);
        RepositorioPedido repositorioPedido = Mockito.mock(RepositorioPedido.class);
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);

        Mockito.when(repositorioCliente.existe(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarPedido servicioActualizarPedido = new ServicioActualizarPedido(repositorioPedido, repositorioCliente, daoPedido);

        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarPedido.ejecutar(pedido), ExcepcionSinDatos.class, "No sé encontró el cliente para asignar el pedido");
    }
}
