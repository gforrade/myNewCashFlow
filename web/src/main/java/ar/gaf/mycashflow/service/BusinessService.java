package ar.gaf.mycashflow.service;

import ar.gaf.mycashflow.model.entities.*;

import java.util.List;

/**
 * Created by gforrade on 4/9/16.
 * Copyright (c) 2016, GAF Software INC.
 */
public interface BusinessService {

    List<Customer> findByLastName(String lastName);


    /* CRUD Categoria */

    Iterable<Categoria> findAllCategorias();

    Categoria findCategoriaById(Long id);

    void saveCategoria(Categoria categoria);

    void deleteCategoriaById(Long id);

    void updateCategoria(Categoria categoria);

    public void saveEgresoEfectivo(EgresoEfectivo egresoEfectivo) ;

    public void saveEgresoTarjetaCredito(EgresoTarjetaCredito egresoTarjetaCredito) ;

    public Iterable<Grupo> findAllGrupos();

    public Grupo findGrupoById(Long id);

    public void saveGrupo(Grupo grupo);

    public void updateGrupo(Grupo grupo);

    public void deleteGrupoById(Long id);

    public Iterable<CentroCosto> findAllCentrosCosto();


    public CentroCosto findCentroCostoById(Long id);

    public void saveCentroCosto(CentroCosto centroCosto);


    public void deleteCentroCostoById(Long id);


    public void updateCentroCosto(CentroCosto centroCosto);


}
