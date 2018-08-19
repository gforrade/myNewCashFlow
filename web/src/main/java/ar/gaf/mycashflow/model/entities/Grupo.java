package ar.gaf.mycashflow.model.entities;

import lombok.ToString;

import javax.persistence.*;

/**
 * Created by gforrade on 2/6/16.
 * Copyright (c) 2016, GAF Software INC.
 */
@Entity
@Table(schema="MYCASHFLOW",name = "GRUPO")
@ToString
public class Grupo {

    @SequenceGenerator(schema="MYCASHFLOW", name = "GRUPO_SEQUENCE_GENERATOR", sequenceName = "GRUPO_SEQ", initialValue=1, allocationSize=1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GRUPO_SEQUENCE_GENERATOR")
    @Column(name = "ID_GRUPO")
    private Long id;
    private String nombre;
    private String descripcion;

    public Grupo() {
    }

    public Grupo(String nombre, String descripcion) {
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
