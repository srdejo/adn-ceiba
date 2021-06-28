update horario_atencion
set hora_inicial = :horaInicial,
	hora_final = :horaFinal,
	dia_semana = :diaSemana,
	id_comercio = :idComercio
where id = :id