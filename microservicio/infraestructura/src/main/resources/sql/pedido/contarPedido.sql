select count(1)
from pedido
where estado_pedido = 'ENTREGADO'
and id_cliente = :id_cliente