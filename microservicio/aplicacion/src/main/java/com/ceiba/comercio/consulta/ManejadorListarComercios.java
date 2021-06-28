package com.ceiba.comercio.consulta;

import com.ceiba.comercio.modelo.dto.DtoComercio;
import com.ceiba.comercio.puerto.dao.DaoComercio;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarComercios {

    private final DaoComercio daoComercio;

    public ManejadorListarComercios(DaoComercio daoComercio) {
        this.daoComercio = daoComercio;
    }

    public List<DtoComercio> ejecutar() {
        return this.daoComercio.listar();
    }
}
