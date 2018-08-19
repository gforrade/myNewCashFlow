package ar.gaf.mycashflow.web.rest;

import ar.gaf.mycashflow.model.entities.CentroCosto;
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
@RequestMapping(value="/centrosCostos")
public class CentroCostoController {

    @Autowired
    BusinessService businessService;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CentroCosto>> allCategorias() {
        Iterable<CentroCosto> centroCostosIterable= businessService.findAllCentrosCosto();
        if(centroCostosIterable == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        } else {
            List<CentroCosto> centroCostos  = new ArrayList<>();
            for (CentroCosto centroCosto: centroCostosIterable) {
                centroCostos.add(centroCosto);
            }
            return new ResponseEntity<>(centroCostos, HttpStatus.OK);
        }
    }


    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<CentroCosto> getCentroCosto(@PathVariable("id") Long id) {
        CentroCosto centroCosto = businessService.findCentroCostoById(id);
        if (centroCosto == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        } else {
            return new ResponseEntity<CentroCosto>(centroCosto,HttpStatus.OK);
        }
    }
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Void> createCentroCosto(@RequestBody CentroCosto centroCosto) {
        try {
            System.out.println("centrocosto a crear : "+centroCosto);
            businessService.saveCentroCosto(centroCosto);
            return new ResponseEntity<Void>(HttpStatus.CREATED);

        } catch (Exception ex) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//------------------- Delete a CentroCosto --------------------------------------------------------

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CentroCosto> deleteCentroCosto(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting CentroCosto with id " + id);
        CentroCosto centroCosto = businessService.findCentroCostoById(id);
        if (centroCosto== null) {
            return new ResponseEntity<CentroCosto>(HttpStatus.NOT_FOUND);
        }
        businessService.deleteCentroCostoById(id);
        return new ResponseEntity<CentroCosto>(HttpStatus.NO_CONTENT);
    }

//------------------- Update a categoria --------------------------------------------------------

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CentroCosto> updateCentroCosto(@PathVariable("id") long id, @RequestBody CentroCosto centroCosto) {
        System.out.println("Updating CentroCosto " + id);

        CentroCosto currentCentroCosto = businessService.findCentroCostoById(id);

        if (centroCosto==null) {
            System.out.println("CentroCosto with id " + id + " not found");
            return new ResponseEntity<CentroCosto>(HttpStatus.NOT_FOUND);
        }

        currentCentroCosto.setNombre(centroCosto.getNombre());
        currentCentroCosto.setDescripcion(centroCosto.getDescripcion());
        businessService.updateCentroCosto(currentCentroCosto);

        return new ResponseEntity<CentroCosto>(centroCosto, HttpStatus.OK);
    }

}

