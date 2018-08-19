package ar.gaf.mycashflow.dao;


import ar.gaf.mycashflow.model.entities.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
}

