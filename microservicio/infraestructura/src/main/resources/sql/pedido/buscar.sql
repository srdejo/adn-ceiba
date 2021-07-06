select p.id,id_cliente,estado_pedido,hora,p.fecha_creacion,valor_domicilio,
c.celular, c.nombre, c.direccion
from pedido p
inner join cliente c on c.id = id_cliente
where p.id = :id