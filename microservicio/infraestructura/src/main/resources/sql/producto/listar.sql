select p.id, p.nombre, p.descripcion, p.valor, p.foto, p.fecha_creacion, p.id_comercio
from producto p
inner join horario_atencion h on h.id_comercio = p.id_comercio
where h.hora_inicial < :hora_actual
and h.hora_final > :hora_actual
and h.dia_semana = :dia_semana
