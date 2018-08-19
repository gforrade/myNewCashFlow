package ar.gaf.mycashflow.dao;

import ar.gaf.mycashflow.model.entities.CentroCosto;
import ar.gaf.mycashflow.model.entities.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CentroCostoRepository extends CrudRepository<CentroCosto, Long> {
    CentroCosto findByNombre(String name);
}

