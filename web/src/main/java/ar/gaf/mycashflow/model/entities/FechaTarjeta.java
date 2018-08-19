package ar.gaf.mycashflow.model.entities;

import lombok.ToString;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by gforrade on 2/6/16.
 * Copyright (c) 2016, GAF Software INC.
 */
@Entity
@Table( schema = "MYCASHFLOW" , name = "FECHA_CIERRE_TARJETA")
@ToString
public class FechaTarjeta {
    @SequenceGenerator(schema="MYCASHFLOW" , name = "FECHA_CIERRE_TARJETA_SEQUENCE_GENERATOR", sequenceName = "CATEGORIA_SEQ", initialValue=1, allocationSize=1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FECHA_CIERRE_TARJETA_SEQUENCE_GENERATOR")
    @Column(name = "ID_FECHA_CIERRE")
    private Long id;

    @Column(name="FECHA_CIERRE")
    private Date fechaCierre;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "ID_TARJETA_CREDITO_FK", referencedColumnName = "ID_TARJETA_CREDITO")
    private TarjetaCredito tarjetaCredito;

    @Transient
    private int dia;
    @Transient
    private int mes;
    @Transient
    private int anio;

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public FechaTarjeta() {
    }

    public FechaTarjeta(Date fechaCierre, TarjetaCredito tarjetaCredito) {
        this.fechaCierre = fechaCierre;
        this.tarjetaCredito = tarjetaCredito;
        Calendar.getInstance().setTime(fechaCierre);
        dia = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        mes = Calendar.getInstance().get(Calendar.MONTH);
        anio = Calendar.getInstance().get(Calendar.YEAR);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TarjetaCredito getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(TarjetaCredito tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }
}
