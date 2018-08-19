package ar.gaf.mycashflow.dao;

import ar.gaf.mycashflow.model.entities.CentroCosto;
import ar.gaf.mycashflow.model.entities.TarjetaCredito;
import org.springframework.data.repository.CrudRepository;

public interface TarjetaCreditoRepository extends CrudRepository<TarjetaCredito, Long> {
}

