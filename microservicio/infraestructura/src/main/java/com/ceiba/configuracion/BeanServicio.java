package com.ceiba.configuracion;

import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.ServicioActualizarCliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import com.ceiba.cliente.servicio.ServicioEliminarCliente;
import com.ceiba.comercio.puerto.repositorio.RepositorioComercio;
import com.ceiba.comercio.servicio.ServicioActualizarComercio;
import com.ceiba.comercio.servicio.ServicioCrearComercio;
import com.ceiba.detalle_pedido.puerto.repositorio.RepositorioDetallePedido;
import com.ceiba.detalle_pedido.servicio.ServicioActualizarDetallePedido;
import com.ceiba.detalle_pedido.servicio.ServicioCrearDetallePedido;
import com.ceiba.detalle_pedido.servicio.ServicioEliminarDetallePedido;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.horario.servicio.ServicioActualizarHorario;
import com.ceiba.horario.servicio.ServicioCrearHorario;
import com.ceiba.horario.servicio.ServicioEliminarHorario;
import com.ceiba.oferta.puerto.dao.DaoOferta;
import com.ceiba.oferta.puerto.repositorio.RepositorioOferta;
import com.ceiba.oferta.servicio.ServicioActualizarOferta;
import com.ceiba.oferta.servicio.ServicioCrearOferta;
import com.ceiba.oferta.servicio.ServicioEliminarOferta;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.pedido.servicio.ServicioActualizarPedido;
import com.ceiba.pedido.servicio.ServicioCrearPedido;
import com.ceiba.pedido.servicio.ServicioEliminarPedido;
import com.ceiba.producto.puerto.dao.DaoProducto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.producto.servicio.ServicioActualizarProducto;
import com.ceiba.producto.servicio.ServicioConsultarProducto;
import com.ceiba.producto.servicio.ServicioCrearProducto;
import com.ceiba.producto.servicio.ServicioEliminarProducto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearCliente servicioCrearCliente(RepositorioCliente repositorioCliente) {
        return new ServicioCrearCliente(repositorioCliente);
    }

    @Bean
    public ServicioEliminarCliente servicioEliminarCliente(RepositorioCliente repositorioCliente) {
        return new ServicioEliminarCliente(repositorioCliente);
    }

    @Bean
    public ServicioActualizarCliente servicioActualizarCliente(RepositorioCliente repositorioCliente) {
        return new ServicioActualizarCliente(repositorioCliente);
    }

    @Bean
    public ServicioCrearComercio servicioCrearComercio(RepositorioComercio repositorioComercio) {
        return new ServicioCrearComercio(repositorioComercio);
    }

    @Bean
    public ServicioActualizarComercio servicioActualizarComercio(RepositorioComercio repositorioComercio) {
        return new ServicioActualizarComercio(repositorioComercio);
    }

    @Bean
    public ServicioCrearDetallePedido servicioCrearDetallePedido(RepositorioDetallePedido repositorioDetallePedido
            , RepositorioProducto repositorioProducto
            , RepositorioHorario repositorioHorario) {
        return new ServicioCrearDetallePedido(repositorioDetallePedido, repositorioProducto, repositorioHorario);
    }

    @Bean
    public ServicioEliminarDetallePedido servicioEliminarDetallePedido(RepositorioDetallePedido repositorioDetallePedido) {
        return new ServicioEliminarDetallePedido(repositorioDetallePedido);
    }

    @Bean
    public ServicioActualizarDetallePedido servicioActualizarDetallePedido(RepositorioDetallePedido repositorioDetallePedido
            , RepositorioProducto repositorioProducto
            , RepositorioHorario repositorioHorario) {
        return new ServicioActualizarDetallePedido(repositorioDetallePedido, repositorioProducto, repositorioHorario);
    }

    @Bean
    public ServicioCrearHorario servicioCrearHorario(RepositorioHorario repositorioHorario) {
        return new ServicioCrearHorario(repositorioHorario);
    }

    @Bean
    public ServicioEliminarHorario servicioEliminarHorario(RepositorioHorario repositorioHorario) {
        return new ServicioEliminarHorario(repositorioHorario);
    }

    @Bean
    public ServicioActualizarHorario servicioActualizarHorario(RepositorioHorario repositorioHorario) {
        return new ServicioActualizarHorario(repositorioHorario);
    }

    @Bean
    public ServicioCrearOferta servicioCrearOferta(RepositorioOferta repositorioOferta) {
        return new ServicioCrearOferta(repositorioOferta);
    }

    @Bean
    public ServicioEliminarOferta servicioEliminarOferta(RepositorioOferta repositorioOferta) {
        return new ServicioEliminarOferta(repositorioOferta);
    }

    @Bean
    public ServicioActualizarOferta servicioActualizarOferta(RepositorioOferta repositorioOferta) {
        return new ServicioActualizarOferta(repositorioOferta);
    }

    @Bean
    public ServicioCrearPedido servicioCrearPedido(RepositorioPedido repositorioPedido,
                                                   RepositorioCliente repositorioCliente,
                                                   DaoPedido daoPedido) {
        return new ServicioCrearPedido(repositorioPedido, repositorioCliente, daoPedido);
    }

    @Bean
    public ServicioEliminarPedido servicioEliminarPedido(RepositorioPedido repositorioPedido) {
        return new ServicioEliminarPedido(repositorioPedido);
    }

    @Bean
    public ServicioActualizarPedido servicioActualizarPedido(RepositorioPedido repositorioPedido,
                                                             RepositorioCliente repositorioCliente,
                                                             DaoPedido daoPedido) {
        return new ServicioActualizarPedido(repositorioPedido, repositorioCliente, daoPedido);
    }

    @Bean
    public ServicioCrearProducto servicioCrearProducto(RepositorioProducto repositorioProducto) {
        return new ServicioCrearProducto(repositorioProducto);
    }

    @Bean
    public ServicioEliminarProducto servicioEliminarProducto(RepositorioProducto repositorioProducto) {
        return new ServicioEliminarProducto(repositorioProducto);
    }

    @Bean
    public ServicioActualizarProducto servicioActualizarProducto(RepositorioProducto repositorioProducto) {
        return new ServicioActualizarProducto(repositorioProducto);
    }

    @Bean
    public ServicioConsultarProducto servicioConsultarProducto(DaoProducto daoProducto, DaoOferta daoOferta) {
        return new ServicioConsultarProducto(daoProducto, daoOferta);
    }

}
