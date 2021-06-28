package com.ceiba.oferta.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.oferta.modelo.entidad.Oferta;
import com.ceiba.oferta.servicio.ServicioCrearOferta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.oferta.comando.ComandoOferta;
import com.ceiba.oferta.comando.fabrica.FabricaOferta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearOferta implements ManejadorComandoRespuesta<ComandoOferta, ComandoRespuesta<Long>> {

    private final FabricaOferta fabricaOferta;
    private final ServicioCrearOferta servicioCrearOferta;

    public ManejadorCrearOferta(FabricaOferta fabricaOferta, ServicioCrearOferta servicioCrearOferta) {
        this.fabricaOferta = fabricaOferta;
        this.servicioCrearOferta = servicioCrearOferta;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoOferta comandoOferta) {
        Oferta oferta = this.fabricaOferta.crear(comandoOferta);
        return new ComandoRespuesta<>(this.servicioCrearOferta.ejecutar(oferta));
    }
}
