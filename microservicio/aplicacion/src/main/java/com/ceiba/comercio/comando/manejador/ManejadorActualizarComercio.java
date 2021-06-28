package com.ceiba.comercio.comando.manejador;

import com.ceiba.comercio.modelo.entidad.Comercio;
import com.ceiba.comercio.servicio.ServicioActualizarComercio;
import com.ceiba.comercio.comando.ComandoComercio;
import com.ceiba.comercio.comando.fabrica.FabricaComercio;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarComercio implements ManejadorComando<ComandoComercio> {

    private final FabricaComercio fabricaComercio;
    private final ServicioActualizarComercio servicioActualizarComercio;

    public ManejadorActualizarComercio(FabricaComercio fabricaComercio, ServicioActualizarComercio servicioActualizarComercio) {
        this.fabricaComercio = fabricaComercio;
        this.servicioActualizarComercio = servicioActualizarComercio;
    }

    public void ejecutar(ComandoComercio comandoComercio) {
        Comercio comercio = this.fabricaComercio.crear(comandoComercio);
        this.servicioActualizarComercio.ejecutar(comercio);
    }
}
