update producto
set nombre = :nombre,
	descripcion = :descripcion,
	valor = :valor,
	id_comercio = :idComercio,
	fecha_creacion = :fechaCreacion
where id = :id