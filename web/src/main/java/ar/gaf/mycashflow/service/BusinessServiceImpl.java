package ar.gaf.mycashflow.service;

import ar.gaf.mycashflow.dao.*;
import ar.gaf.mycashflow.model.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by gforrade on 4/9/16.
 * Copyright (c) 2016, GAF Software INC.
 */
@Service
@Transactional
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private CentroCostoRepository centroCostoRepository;

    @Autowired
    private TarjetaCreditoRepository tarjetaCreditoRepository;

    @Autowired
    private EgresoTarjetaCreditoRepository egresoTarjetaCreditoRepository;

    @Autowired
    private EgresoEfectivoRepository egresoEfectivoRepository;


    public void saveEgresoEfectivo(EgresoEfectivo egresoEfectivo) {
        egresoEfectivo.setCategoria(categoriaRepository.findOne(egresoEfectivo.getCategoria().getId()));
        egresoEfectivoRepository.save(egresoEfectivo);
    }

    public void saveEgresoTarjetaCredito(EgresoTarjetaCredito egresoTarjetaCredito) {
        egresoTarjetaCredito.setTarjetaCredito(tarjetaCreditoRepository.findOne(egresoTarjetaCredito.getTarjetaCredito().getId()));
        if (egresoTarjetaCredito.getCategoria().getId() != null) {
            egresoTarjetaCredito.setCategoria(categoriaRepository.findOne(egresoTarjetaCredito.getCategoria().getId()));
        } else {
            egresoTarjetaCredito.setCategoria(null);
        }
        egresoTarjetaCreditoRepository.save(egresoTarjetaCredito);
    }


    public List<Customer> findByLastName(String lastName) {
        return  customerRepository.findByLastName(lastName);
    }


    //Categoria
    @Override
    public Iterable<Categoria> findAllCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria findCategoriaById(Long id) {
        return categoriaRepository.findOne(id);
    }

    @Override
    public void saveCategoria(Categoria categoria) {

        categoria.setCentroCosto(centroCostoRepository.findOne(categoria.getCentroCosto().getId()));
        categoria.setGrupo(grupoRepository.findOne(categoria.getGrupo().getId()));
        categoriaRepository.save(categoria);
    }

    @Override
    public void deleteCategoriaById(Long id) {
        categoriaRepository.delete(id);
    }

    @Override
    public void updateCategoria(Categoria categoria) {
        categoria.setCentroCosto(centroCostoRepository.findOne(categoria.getCentroCosto().getId()));
        categoria.setGrupo(grupoRepository.findOne(categoria.getGrupo().getId()));
        categoriaRepository.save(categoria);
    }


    //Grupo
    @Override
    public Iterable<Grupo> findAllGrupos() {
    return grupoRepository.findAll();
}

    @Override
    public Grupo findGrupoById(Long id) {
        return grupoRepository.findOne(id);
    }

    @Override
    public void saveGrupo(Grupo grupo) {
        grupoRepository.save(grupo);
    }

    @Override
    public void deleteGrupoById(Long id) {
        grupoRepository.delete(id);
    }

    @Override
    public void updateGrupo(Grupo grupo) {
        grupoRepository.save(grupo);
    }


    //CentroCosto
    @Override
    public Iterable<CentroCosto> findAllCentrosCosto() {
        return centroCostoRepository.findAll();
    }

    @Override
    public CentroCosto findCentroCostoById(Long id) {
        return centroCostoRepository.findOne(id);
    }

    @Override
    public void saveCentroCosto(CentroCosto centroCosto) {
        centroCostoRepository.save(centroCosto);
    }

    @Override
    public void deleteCentroCostoById(Long id) {
        centroCostoRepository.delete(id);
    }

    @Override
    public void updateCentroCosto(CentroCosto centroCosto) {
        centroCostoRepository.save(centroCosto);
    }


}
