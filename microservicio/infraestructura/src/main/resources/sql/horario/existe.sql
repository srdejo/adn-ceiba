select count(1)
from horario_atencion
where id_comercio = :id_comercio
and hora_inicial = :hora_inicial
and hora_final = :hora_final
and dia_semana = :dia_semana