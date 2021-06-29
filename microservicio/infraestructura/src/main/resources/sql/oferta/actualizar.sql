update oferta
set hora_inicial = :horaInicial,
	hora_final = :horaFinal,
	dia = :dia,
	valor = :valor,
	id_producto = :idProducto
where id = :id