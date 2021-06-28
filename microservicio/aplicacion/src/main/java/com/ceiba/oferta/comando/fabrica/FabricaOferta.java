package com.ceiba.oferta.comando.fabrica;

import com.ceiba.oferta.modelo.entidad.Oferta;
import com.ceiba.oferta.comando.ComandoOferta;
import org.springframework.stereotype.Component;

@Component
public class FabricaOferta {

    public Oferta crear(ComandoOferta comandoOferta) {
        return new Oferta(
                comandoOferta.getId(),
                comandoOferta.getHoraInicial(),
                comandoOferta.getHoraFinal(),
                comandoOferta.getDia(),
                comandoOferta.getValor(),
                comandoOferta.getIdProducto()
        );
    }

}
