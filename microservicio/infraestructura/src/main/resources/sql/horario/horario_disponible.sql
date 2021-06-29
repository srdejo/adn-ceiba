select count(1)
from horario_atencion
where id_comercio = (select id_comercio from producto where id = :id_producto )
and hora_inicial < :hora_actual
and hora_final > :hora_actual
and dia_semana = :dia_semana