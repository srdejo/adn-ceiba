package com.ceiba.oferta.consulta;

import com.ceiba.oferta.modelo.dto.DtoOferta;
import com.ceiba.oferta.puerto.dao.DaoOferta;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarOfertas {

    private final DaoOferta daoOferta;

    public ManejadorListarOfertas(DaoOferta daoOferta) {
        this.daoOferta = daoOferta;
    }

    public List<DtoOferta> ejecutar() {
        return this.daoOferta.listar();
    }
}
