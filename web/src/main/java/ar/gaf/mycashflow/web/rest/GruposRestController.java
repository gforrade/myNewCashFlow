package ar.gaf.mycashflow.web.rest;

import ar.gaf.mycashflow.model.entities.Categoria;
import ar.gaf.mycashflow.model.entities.Grupo;
import ar.gaf.mycashflow.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gforrade on 2/6/16.
 * Copyright (c) 2016, DATASTAR S.A.
 */
@RestController()
@RequestMapping(value="/grupos")
public class GruposRestController {

    @Autowired
    BusinessService businessService;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Grupo>> allGrupos() {
        Iterable<Grupo> grupoIterable= businessService.findAllGrupos();
        if(grupoIterable == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        } else {
            List<Grupo> grupos  = new ArrayList<>();
            for (Grupo grupo : grupoIterable) {
                System.out.println("Grupo-> " + grupo);
                grupos.add(grupo);
            }
            return new ResponseEntity<>(grupos, HttpStatus.OK);
        }
    }


    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Grupo> getGrupo(@PathVariable("id") Long id) {
        Grupo grupo = businessService.findGrupoById(id);
        if (grupo == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        } else {
            return new ResponseEntity<Grupo>(grupo,HttpStatus.OK);
        }
    }
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Void> createGrupo(@RequestBody Grupo grupo) {
        try {
            System.out.println("grupo a crear : "+grupo);
            businessService.saveGrupo(grupo);
            return new ResponseEntity<Void>(HttpStatus.CREATED);

        } catch (Exception ex) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//------------------- Delete a User --------------------------------------------------------

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Grupo> deleteUser(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);
        Grupo grupo = businessService.findGrupoById(id);
        if (grupo == null) {
            return new ResponseEntity<Grupo>(HttpStatus.NOT_FOUND);
        }
        businessService.deleteGrupoById(id);
        return new ResponseEntity<Grupo>(HttpStatus.NO_CONTENT);
    }

//------------------- Update a categoria --------------------------------------------------------

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Grupo> updateGrupo(@PathVariable("id") long id, @RequestBody Grupo grupo) {
        System.out.println("Updating Grupo " + id);

        Grupo currentGrupo  = businessService.findGrupoById(id);

        if (grupo==null) {
            System.out.println("Grupo with id " + id + " not found");
            return new ResponseEntity<Grupo>(HttpStatus.NOT_FOUND);
        }

        currentGrupo.setNombre(grupo.getNombre());
        currentGrupo.setDescripcion(grupo.getDescripcion());
        businessService.updateGrupo(currentGrupo);

        return new ResponseEntity<Grupo>(grupo, HttpStatus.OK);
    }

}

