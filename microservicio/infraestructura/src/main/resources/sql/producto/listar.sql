select p.id, p.nombre, p.descripcion,  p.valor, p.foto, p.fecha_creacion,
p.id_comercio
from producto p
where id_comercio = :idComercio