package ar.gaf.mycashflow.dao;

import java.util.List;

import ar.gaf.mycashflow.model.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
