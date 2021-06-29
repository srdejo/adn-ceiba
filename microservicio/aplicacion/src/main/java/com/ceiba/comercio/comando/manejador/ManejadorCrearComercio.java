package com.ceiba.comercio.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comercio.comando.ComandoComercio;
import com.ceiba.comercio.comando.fabrica.FabricaComercio;
import com.ceiba.comercio.modelo.entidad.Comercio;
import com.ceiba.comercio.servicio.ServicioCrearComercio;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearComercio implements ManejadorComandoRespuesta<ComandoComercio, ComandoRespuesta<Long>> {

    private final FabricaComercio fabricaComercio;
    private final ServicioCrearComercio servicioCrearComercio;

    public ManejadorCrearComercio(FabricaComercio fabricaComercio, ServicioCrearComercio servicioCrearComercio) {
        this.fabricaComercio = fabricaComercio;
        this.servicioCrearComercio = servicioCrearComercio;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoComercio comandoComercio) {
        Comercio comercio = this.fabricaComercio.crear(comandoComercio);
        return new ComandoRespuesta<>(this.servicioCrearComercio.ejecutar(comercio));
    }
}
