select valor
from oferta
where id_producto = :id_producto
and hora_inicial < :hora_actual
and hora_final > :hora_actual
and dia = :fecha_actual