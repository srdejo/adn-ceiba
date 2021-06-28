package com.ceiba.comercio.comando.fabrica;

import com.ceiba.comercio.comando.ComandoComercio;
import com.ceiba.comercio.modelo.entidad.Comercio;
import org.springframework.stereotype.Component;

@Component
public class FabricaComercio {

    public Comercio crear(ComandoComercio comandoComercio) {
        return new Comercio(
                comandoComercio.getId(),
                comandoComercio.getNombre()
        );
    }

}
