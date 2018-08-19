package ar.gaf.mycashflow.web.rest;

import ar.gaf.mycashflow.dao.CategoriaRepository;
import ar.gaf.mycashflow.dao.CentroCostoRepository;
import ar.gaf.mycashflow.dao.GrupoRepository;
import ar.gaf.mycashflow.model.entities.Categoria;
import ar.gaf.mycashflow.model.entities.Customer;
import ar.gaf.mycashflow.dao.CustomerRepository;
import ar.gaf.mycashflow.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gforrade on 2/6/16.
 * Copyright (c) 2016, DATASTAR S.A.
 */
@RestController
public class RestHelloResource {

    @Autowired
    BusinessService businessService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private CentroCostoRepository centroCostoRepository;


    @RequestMapping("/values")
    public Customer getCustomer() {
        Customer customer = customerRepository.findOne(1L);
        System.out.println("customer "+customer);
        return customer;
    }

    @RequestMapping(value = "/customers/{lastname}"   , method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> findByLastName(@PathVariable("lastname") String lastName) {
        System.out.println("lastName "+lastName);
        List<Customer> customers =  businessService.findByLastName(lastName);
        if (customers !=null && customers.size()==0) {
            System.out.println("Customer null");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @RequestMapping(value = "/allCustomers", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> listAllUsers() {
        Iterable<Customer> customersIter = customerRepository.findAll();
        if(customersIter == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        } else {
            List<Customer> customers = new ArrayList<>();
            for (Customer customer : customersIter) {
                customers.add(customer);
            }
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/allCategorias", method = RequestMethod.GET)
    public ResponseEntity<List<Categoria>> allCategorias() {
        Iterable<Categoria> categoriaIterable = businessService.findAllCategorias();
        if(categoriaIterable == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        } else {
            List<Categoria> categorias  = new ArrayList<>();
            for (Categoria categoria : categoriaIterable) {
                categorias.add(categoria);
            }
            return new ResponseEntity<>(categorias, HttpStatus.OK);
        }
    }


    @RequestMapping(value="/addCategoria", method= RequestMethod.POST)
    public void saveCategoria( @RequestBody String nombre, @RequestBody String descripcion, @RequestBody Long tipoId, @RequestBody  Long grupoId, @RequestBody  Long centroCostoId) {
        Categoria categoria = new Categoria(nombre,descripcion);
        categoria.setTipo(Categoria.Tipo.EGRESO);
        categoria.setGrupo(grupoRepository.findOne(grupoId));
        categoria.setCentroCosto(centroCostoRepository.findOne(centroCostoId));
        System.out.println("categoria: "+categoria);
        categoriaRepository.save(categoria);
    }


}
