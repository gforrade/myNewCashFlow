package ar.gaf.mycashflow.dao;


import ar.gaf.mycashflow.model.entities.Categoria;
import ar.gaf.mycashflow.model.entities.EgresoTarjetaCredito;
import org.springframework.data.repository.CrudRepository;

public interface EgresoTarjetaCreditoRepository extends CrudRepository<EgresoTarjetaCredito, Long> {
}

