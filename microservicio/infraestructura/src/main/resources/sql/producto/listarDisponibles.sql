select p.id, p.nombre, p.descripcion,  p.valor, p.foto, p.fecha_creacion,
p.id_comercio, o.valor as "valor_oferta"
from producto p
inner join horario_atencion h on h.id_comercio = p.id_comercio
left  join oferta o on p.id= o.id_producto
and o.hora_inicial < :hora_actual
and o.hora_final > :hora_actual
and o.dia = :dia
where h.hora_inicial < :hora_actual
and h.hora_final > :hora_actual
and h.dia_semana = :dia_semana