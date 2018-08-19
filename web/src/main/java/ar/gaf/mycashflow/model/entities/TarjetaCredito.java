package ar.gaf.mycashflow.model.entities;

import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Created by gforrade on 2/6/16.
 * Copyright (c) 2016, GAF Software INC.
 */
@Entity
@Table(schema="MYCASHFLOW",name = "TARJETA_CREDITO")
@ToString(exclude = "fechasCierre")
public class TarjetaCredito {

    @SequenceGenerator(schema="MYCASHFLOW", name = "TARJETA_CREDITO_SEQUENCE_GENERATOR", sequenceName = "TARJETA_CREDITO_SEQ", initialValue=1, allocationSize=1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TARJETA_CREDITO_SEQUENCE_GENERATOR")
    @Column(name = "ID_TARJETA_CREDITO")
    private Long id;
    private String nombre;
    private String descripcion;
    private String bancoEmisor;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tarjetaCredito", cascade = CascadeType.ALL)
    private List<FechaTarjeta> fechasCierre;

    public TarjetaCredito() {
    }

    public TarjetaCredito(String nombre, String descripcion, String bancoEmisor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.bancoEmisor = bancoEmisor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NOMBRE", nullable=false,length=250)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "DESCRIPCION", nullable=false,length=250)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "BANCO_EMISOR", nullable=false,length=250)
    public String getBancoEmisor() {
        return bancoEmisor;
    }

    public void setBancoEmisor(String bancoEmisor) {
        this.bancoEmisor = bancoEmisor;
    }

    public List<FechaTarjeta> getFechasCierre() {
        return fechasCierre;
    }

    public void setFechasCierre(List<FechaTarjeta> fechasCierre) {
        this.fechasCierre = fechasCierre;
    }

    public int getCurrentDayCorte() {
        //retorna el dia de corte del mes en curso
        //se calculara en base a la info de fechas
        //Todo implementar esto
        return 23;
    }
}