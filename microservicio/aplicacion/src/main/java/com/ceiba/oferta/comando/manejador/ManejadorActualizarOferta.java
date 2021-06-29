package com.ceiba.oferta.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.oferta.comando.ComandoOferta;
import com.ceiba.oferta.comando.fabrica.FabricaOferta;
import com.ceiba.oferta.modelo.entidad.Oferta;
import com.ceiba.oferta.servicio.ServicioActualizarOferta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarOferta implements ManejadorComando<ComandoOferta> {

    private final FabricaOferta fabricaOferta;
    private final ServicioActualizarOferta servicioActualizarOferta;

    public ManejadorActualizarOferta(FabricaOferta fabricaOferta, ServicioActualizarOferta servicioActualizarOferta) {
        this.fabricaOferta = fabricaOferta;
        this.servicioActualizarOferta = servicioActualizarOferta;
    }

    public void ejecutar(ComandoOferta comandoOferta) {
        Oferta oferta = this.fabricaOferta.crear(comandoOferta);
        this.servicioActualizarOferta.ejecutar(oferta);
    }
}
