update detalle_pedido
set id_pedido = :idPedido,
	id_producto = :idProducto,
	valor = :valorUnidad,
	nota = :observacion,
	fecha_creacion = :fechaCreacion
where id = :id