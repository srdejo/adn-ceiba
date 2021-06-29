package com.ceiba.producto.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.oferta.modelo.entidad.Oferta;
import com.ceiba.oferta.puerto.dao.DaoOferta;
import com.ceiba.oferta.servicio.testdatabuilder.OfertaTestDataBuilder;
import com.ceiba.producto.modelo.dto.DtoProducto;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.dao.DaoProducto;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Random;

public class ServicioConsultarProductoTest {

    @Test
    public void obtenerProducto() {
        // arrange
        Random random = new Random();

        DaoProducto daoProducto = Mockito.mock(DaoProducto.class);
        DaoOferta daoOferta = Mockito.mock(DaoOferta.class);
        ServicioConsultarProducto servicioConsultarProducto = new ServicioConsultarProducto(daoProducto, daoOferta);

        // act
        // assert
        BasePrueba.assertThrows(() -> servicioConsultarProducto.ejecutar(random.nextLong()), ExcepcionValorInvalido.class, "El producto consultado no existe");
    }

    @Test
    public void validarProductoEnOfertaTest() {
        // arrange
        DaoProducto daoProducto = Mockito.mock(DaoProducto.class);
        DaoOferta daoOferta = Mockito.mock(DaoOferta.class);

        Producto producto = new ProductoTestDataBuilder().conId(1L).build();
        Oferta oferta = new OfertaTestDataBuilder().conIdProducto(producto.getId()).conValor(5000.00).build();

        Mockito.when(daoProducto.obtenerProducto(Mockito.anyLong())).thenReturn(new DtoProducto(producto.getId()
                , producto.getNombre()
                , producto.getDescripcion()
                , producto.getValor()
                , producto.getIdComercio()
                , producto.getFechaCreacion()
        ));

        Mockito.when(daoOferta.consultarValorEnOferta(Mockito.anyLong())).thenReturn(5000.00);
        ServicioConsultarProducto servicioConsultarProducto = new ServicioConsultarProducto(daoProducto, daoOferta);
        // act
        Producto productoFinal = servicioConsultarProducto.ejecutar(producto.getId());
        // assert
        Assert.assertEquals(productoFinal.getValor(), oferta.getValor());
    }


    @Test
    public void validarProductoSinOfertaTest() {
        // arrange
        DaoProducto daoProducto = Mockito.mock(DaoProducto.class);
        DaoOferta daoOferta = Mockito.mock(DaoOferta.class);

        Producto producto = new ProductoTestDataBuilder().conId(1L).build();

        Mockito.when(daoProducto.obtenerProducto(Mockito.anyLong())).thenReturn(new DtoProducto(producto.getId()
                , producto.getNombre()
                , producto.getDescripcion()
                , producto.getValor()
                , producto.getIdComercio()
                , producto.getFechaCreacion()
        ));

        Mockito.when(daoOferta.consultarValorEnOferta(Mockito.anyLong())).thenReturn(null);
        ServicioConsultarProducto servicioConsultarProducto = new ServicioConsultarProducto(daoProducto, daoOferta);
        // act
        Producto productoFinal = servicioConsultarProducto.ejecutar(producto.getId());
        // assert
        Assert.assertEquals(productoFinal.getValor(), producto.getValor());
    }
}
