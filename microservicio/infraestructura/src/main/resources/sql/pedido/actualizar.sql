update pedido
set id_cliente = :idCliente,
	estado_pedido = :estadoPedido,
	hora = :hora,
	valor_domicilio = :valorDomicilio
where id = :id