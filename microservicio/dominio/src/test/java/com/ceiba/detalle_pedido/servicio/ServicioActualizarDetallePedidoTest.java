package com.ceiba.detalle_pedido.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.comercio.modelo.entidad.Comercio;
import com.ceiba.comercio.puerto.repositorio.RepositorioComercio;
import com.ceiba.comercio.servicio.testdatabuilder.ComercioTestDataBuilder;
import com.ceiba.detalle_pedido.modelo.entidad.DetallePedido;
import com.ceiba.detalle_pedido.puerto.repositorio.RepositorioDetallePedido;
import com.ceiba.detalle_pedido.servicio.testdatabuilder.DetallePedidoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.horario.servicio.testdatabuilder.HorarioTestDataBuilder;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.pedido.servicio.testdatabuilder.PedidoTestDataBuilder;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Random;

public class ServicioActualizarDetallePedidoTest {

    @Test
    public void validarHorarioComercioCerradoTest() {
        // arrange
        Random random = new Random();
        RepositorioDetallePedido repositorioDetallePedido = Mockito.mock(RepositorioDetallePedido.class);
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        RepositorioHorario repositorioHorario = Mockito.mock(RepositorioHorario.class);
        ServicioActualizarDetallePedido servicioActualizarDetallePedido = new ServicioActualizarDetallePedido(repositorioDetallePedido, repositorioProducto, repositorioHorario);

        DetallePedido detallePedido = new DetallePedidoTestDataBuilder().conIdProducto(random.nextLong()).conIdPedido(random.nextLong()).build();

        Mockito.when(repositorioProducto.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioHorario.estaAbierto(Mockito.anyLong())).thenReturn(false);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarDetallePedido.ejecutar(detallePedido), ExcepcionValorInvalido.class
                , "El comercio termino su horario de atencion");
    }

    @Test
    public void validarHorarioComercioAbiertoTest() {
        // arrange
        Random random = new Random();
        RepositorioDetallePedido repositorioDetallePedido = Mockito.mock(RepositorioDetallePedido.class);
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        RepositorioHorario repositorioHorario = Mockito.mock(RepositorioHorario.class);
        ServicioActualizarDetallePedido servicioActualizarDetallePedido = new ServicioActualizarDetallePedido(repositorioDetallePedido, repositorioProducto, repositorioHorario);

        DetallePedido detallePedido = new DetallePedidoTestDataBuilder().conIdProducto(random.nextLong()).conIdPedido(random.nextLong()).build();

        Mockito.when(repositorioProducto.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioHorario.estaAbierto(Mockito.anyLong())).thenReturn(true);
        // act - assert

        try {
            servicioActualizarDetallePedido.ejecutar(detallePedido);
        } catch(Exception e) {
            Assert.fail("Ocurrio una excepcion");
        }

    }

    @Test
    public void  validarExistenciaProducto(){
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
}
