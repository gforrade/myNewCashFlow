package ar.gaf.mycashflow.web.rest;

import ar.gaf.mycashflow.dao.CategoriaRepository;
import ar.gaf.mycashflow.dao.CentroCostoRepository;
import ar.gaf.mycashflow.dao.CustomerRepository;
import ar.gaf.mycashflow.dao.GrupoRepository;
import ar.gaf.mycashflow.model.entities.Categoria;
import ar.gaf.mycashflow.model.entities.Customer;
import ar.gaf.mycashflow.model.entities.Grupo;
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
@RestController()
@RequestMapping(value="/categorias")
public class CategoriaRestController {

    @Autowired
    BusinessService businessService;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Categoria>> allCategorias() {
        Iterable<Categoria> categoriaIterable = businessService.findAllCategorias();
        if(categoriaIterable == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        } else {
            List<Categoria> categorias  = new ArrayList<>();
            for (Categoria categoria : categoriaIterable) {
                System.out.println("categoria-> " + categoria);
                categorias.add(categoria);
            }
            return new ResponseEntity<>(categorias, HttpStatus.OK);
        }
    }


    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Categoria> getCategoria(@PathVariable("id") Long id) {
        Categoria categoria =  businessService.findCategoriaById(id);
        if (categoria == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);//You many decide to return HttpStatus.NOT_FOUND
        } else {
            return new ResponseEntity<Categoria>(categoria,HttpStatus.OK);
        }
    }
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Void> createCategoria(@RequestBody Categoria categoria) {
        try {
            businessService.saveCategoria(categoria);
            return new ResponseEntity<Void>(HttpStatus.CREATED);

        } catch (Exception ex) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//------------------- Delete a User --------------------------------------------------------

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Categoria> deleteUser(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);
        Categoria categoria = businessService.findCategoriaById(id);
        if (categoria == null) {
            return new ResponseEntity<Categoria>(HttpStatus.NOT_FOUND);
        }
        businessService.deleteCategoriaById(id);
        return new ResponseEntity<Categoria>(HttpStatus.NO_CONTENT);
    }

//------------------- Update a categoria --------------------------------------------------------

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Categoria> updateCategoria(@PathVariable("id") long id, @RequestBody Categoria categoria) {
        System.out.println("Updating Categoria " + id);

        Categoria currentCategoria = businessService.findCategoriaById(id);

        if (currentCategoria==null) {
            return new ResponseEntity<Categoria>(HttpStatus.NOT_FOUND);
        }

        businessService.updateCategoria(categoria);

        return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
    }

}

