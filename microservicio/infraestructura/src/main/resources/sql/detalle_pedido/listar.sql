select dp.id,id_pedido,cantidad,dp.valor,nota,dp.fecha_creacion, id_producto, nombre, descripcion, p.valor as valor_producto
from detalle_pedido dp
inner join producto p on p.id = dp.id_producto
where id_pedido = :idPedido