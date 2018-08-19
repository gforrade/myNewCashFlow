package ar.gaf.mycashflow.model.entities;

import lombok.ToString;

import javax.persistence.*;

/**
 * Created by gforrade on 2/6/16.
 * Copyright (c) 2016, GAF Software INC.
 */

@Entity
@Table(schema="MYCASHFLOW" , name = "CATEGORIA")
@ToString
public class Categoria {


    @SequenceGenerator(schema="MYCASHFLOW" , name = "CATEGORIA_SEQUENCE_GENERATOR", sequenceName = "CATEGORIA_SEQ", initialValue=1, allocationSize=1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORIA_SEQUENCE_GENERATOR")
    @Column(name = "ID_CATEGORIA")
    private Long id;
    @Column(name = "NOMBRE", nullable=false,length=250)
    private String nombre;
    @Column(name = "DESCRIPCION", nullable=false,length=250)
    private String descripcion;
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO", nullable=true, length=10)
    private Tipo tipo;
    @ManyToOne(cascade=CascadeType.MERGE)
    private Grupo grupo;

    @ManyToOne(optional = true)
    @JoinColumn(name = "ID_CENTRO_COSTO_FK", referencedColumnName = "ID_CENTRO_COSTO")
    private CentroCosto centroCosto;

    static public enum Tipo {
        EGRESO,
        INGRESO
    }

    public Categoria() {
    }

    public Categoria(String nombre, String descripcion, Tipo tipo, Grupo grupo, CentroCosto centroCosto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.grupo = grupo;
        this.centroCosto = centroCosto;
    }

    public Categoria(String nombre, String descripcion) {
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

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public CentroCosto getCentroCosto() {
        return centroCosto;
    }

    public void setCentroCosto(CentroCosto centroCosto) {
        this.centroCosto = centroCosto;
    }



}

