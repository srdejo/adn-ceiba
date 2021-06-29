select o.id, o.hora_inicial, o.hora_final, o.dia,
o.valor "valor_oferta", o.id_producto, o.fecha_creacion, p.nombre,
p.descripcion, p.valor, p.id_comercio, p.fecha_creacion "fecha_creacion_producto"
from oferta o
inner join producto p on o.id_producto = p.id