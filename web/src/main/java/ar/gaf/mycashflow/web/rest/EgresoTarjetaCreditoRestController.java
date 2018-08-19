package ar.gaf.mycashflow.web.rest;

import ar.gaf.mycashflow.model.entities.Categoria;
import ar.gaf.mycashflow.model.entities.EgresoTarjetaCredito;
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
@RequestMapping(value="/egresoTarjetaCredito")
public class EgresoTarjetaCreditoRestController {

    @Autowired
    BusinessService businessService;



    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Void> createEgresoTarjeta(@RequestBody EgresoTarjetaCredito egresoTarjetaCredito) {
        try {
            System.out.println("egreso tarjeta credito a crear : "+egresoTarjetaCredito);
            businessService.saveEgresoTarjetaCredito(egresoTarjetaCredito);
            return new ResponseEntity<Void>(HttpStatus.CREATED);

        } catch (Exception ex) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}

