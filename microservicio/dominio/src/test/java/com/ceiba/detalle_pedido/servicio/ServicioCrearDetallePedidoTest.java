package com.ceiba.detalle_pedido.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.detalle_pedido.modelo.entidad.DetallePedido;
import com.ceiba.detalle_pedido.puerto.repositorio.RepositorioDetallePedido;
import com.ceiba.detalle_pedido.servicio.testdatabuilder.DetallePedidoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.oferta.puerto.dao.DaoOferta;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.util.Objects;
import java.util.Random;

public class ServicioCrearDetallePedidoTest {

    @Test
    public void validarHorarioComercioCerradoTest() {
        // arrange
        Random random = new Random();
        RepositorioDetallePedido repositorioDetallePedido = Mockito.mock(RepositorioDetallePedido.class);
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        RepositorioHorario repositorioHorario = Mockito.mock(RepositorioHorario.class);
        DaoOferta daoOferta = Mockito.mock(DaoOferta.class);
        ServicioCrearDetallePedido servicioCrearDetallePedido = new ServicioCrearDetallePedido(
                repositorioDetallePedido, repositorioProducto, repositorioHorario, daoOferta);

        DetallePedido detallePedido = new DetallePedidoTestDataBuilder().conIdProducto(random.nextLong()).conIdPedido(random.nextLong()).build();

        Mockito.when(repositorioProducto.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioHorario.estaAbierto(Mockito.anyLong())).thenReturn(false);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearDetallePedido.ejecutar(detallePedido), ExcepcionValorInvalido.class
                , "El comercio termino su horario de atencion");
    }

    @Test
    public void validarHorarioComercioAbiertoTest() {
        // arrange
        Random random = new Random();
        RepositorioDetallePedido repositorioDetallePedido = Mockito.mock(RepositorioDetallePedido.class);
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        RepositorioHorario repositorioHorario = Mockito.mock(RepositorioHorario.class);
        DaoOferta daoOferta = Mockito.mock(DaoOferta.class);

        ServicioCrearDetallePedido servicioCrearDetallePedido = new ServicioCrearDetallePedido(
                repositorioDetallePedido, repositorioProducto, repositorioHorario, daoOferta);
        DetallePedido detallePedido = new DetallePedidoTestDataBuilder().conIdProducto(random.nextLong()).conIdPedido(random.nextLong()).build();
        detallePedido.asignarValorUnidad(random.nextDouble());

        Mockito.when(repositorioProducto.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioHorario.estaAbierto(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoOferta.consultarValorEnOferta(Mockito.anyLong())).thenReturn(random.nextDouble());
        // act - assert
        try {
            servicioCrearDetallePedido.ejecutar(detallePedido);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Ocurrio una excepcion" + e.getMessage());
        }

    }

    @Test
    public void validarNoExistenciaProducto() {
        // arrange
        Random random = new Random();
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        RepositorioHorario repositorioHorario = Mockito.mock(RepositorioHorario.class);
        RepositorioDetallePedido repositorioDetallePedido = Mockito.mock(RepositorioDetallePedido.class);
        ServicioActualizarDetallePedido servicioActualizarDetallePedido = new ServicioActualizarDetallePedido(repositorioDetallePedido, repositorioProducto, repositorioHorario);

        DetallePedido detallePedido = new DetallePedidoTestDataBuilder().conIdProducto(random.nextLong()).conIdPedido(random.nextLong()).build();
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarDetallePedido.ejecutar(detallePedido), ExcepcionValorInvalido.class
                , "El producto añadadido no existe");
    }

    @Test
    public void validarExistenciaProducto() {
        // arrange
        Random random = new Random();
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        RepositorioHorario repositorioHorario = Mockito.mock(RepositorioHorario.class);
        RepositorioDetallePedido repositorioDetallePedido = Mockito.mock(RepositorioDetallePedido.class);
        ServicioActualizarDetallePedido servicioActualizarDetallePedido = new ServicioActualizarDetallePedido(repositorioDetallePedido, repositorioProducto, repositorioHorario);

        Mockito.when(repositorioProducto.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioHorario.estaAbierto(Mockito.anyLong())).thenReturn(true);
        DetallePedido detallePedido = new DetallePedidoTestDataBuilder().conIdProducto(random.nextLong()).conIdPedido(random.nextLong()).build();
        // act - assert
        Assertions.assertDoesNotThrow(() -> servicioActualizarDetallePedido.ejecutar(detallePedido));
    }
}
