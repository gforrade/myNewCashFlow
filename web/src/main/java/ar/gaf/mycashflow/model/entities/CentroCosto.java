package ar.gaf.mycashflow.model.entities;

import lombok.ToString;

import javax.persistence.*;

/**
 * Created by gforrade on 2/6/16.
 * Copyright (c) 2016, GAF Software INC.
 */
@Entity
@Table(schema="MYCASHFLOW",name = "CENTRO_COSTO")
@ToString
public class CentroCosto {

    @SequenceGenerator(schema="MYCASHFLOW", name = "CENTRO_COSTO_SEQUENCE_GENERATOR", sequenceName = "CENTRO_COSTO_SEQ", initialValue=1, allocationSize=1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CENTRO_COSTO_SEQUENCE_GENERATOR")
    @Column(name = "ID_CENTRO_COSTO")
    private Long id;
    private String nombre;
    private String descripcion;

    public CentroCosto() {
    }

    public CentroCosto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
