package ar.gaf.mycashflow.dao;


import ar.gaf.mycashflow.model.entities.Grupo;
import org.springframework.data.repository.CrudRepository;

public interface GrupoRepository extends CrudRepository<Grupo, Long> {

    Grupo findByNombre(String name);

}

