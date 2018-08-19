package ar.gaf.mycashflow.model.entities;

import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by gforrade on 2/9/16.
 * Copyright (c) 2016, GAF Software INC.
 */
@Entity
@Table( schema="MYCASHFLOW" , name = "BASE_CASHFLOW")
@Inheritance(strategy= InheritanceType.JOINED)
@ToString
public class BaseCashflow {



    @SequenceGenerator(schema="MYCASHFLOW", name = "BASE_CASHFLOW_SEQUENCE_GENERATOR", sequenceName = "BASE_CASHFLOW_COSTO_SEQ", initialValue=1, allocationSize=1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BASE_CASHFLOW_SEQUENCE_GENERATOR")
    @Column(name = "ID")
    private Long id;


    @ManyToOne(optional = true)
    @JoinColumn(name = "ID_CATEGORIA_FK", referencedColumnName = "ID_CATEGORIA")
    private Categoria categoria;

    @Column(name="IMPORTE",nullable=false)
    private Double importe;

    @Column(name="DESCRIPCION",nullable=true)
    private String descripcion;

    public BaseCashflow() {
        categoria = new Categoria();
    }

    public BaseCashflow( Categoria categoria, Double importe, String descripcion) {
        this.categoria = categoria;
        this.importe = importe;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
