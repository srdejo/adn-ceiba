select id,id_pedido,id_producto,cantidad,valor,nota,fecha_creacion
from detalle_pedido
where id_pedido = :idPedido