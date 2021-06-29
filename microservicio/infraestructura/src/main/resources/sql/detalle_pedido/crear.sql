insert into detalle_pedido (id_pedido, id_producto, cantidad, valor, nota, fecha_creacion)
values (:idPedido, :idProducto, :cantidad, :valorUnidad, :observacion, now())