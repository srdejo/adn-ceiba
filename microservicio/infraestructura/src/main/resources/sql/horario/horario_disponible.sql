select count(1)
from horario_atencion
where id_comercio = :id_comercio
and hora_inicial < :hora_actual
and hora_final > :hora_actual
and dia_semana = :dia_semana