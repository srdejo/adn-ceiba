select count(1)
from pedido
where estado = "ENTREGADO"
and cliente_id = :cliente_id