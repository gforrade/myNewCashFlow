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
@Table( schema = "MYCASHFLOW" , name = "EGRESO")
@PrimaryKeyJoinColumn(name="ID")
@ToString
public class Egreso extends BaseCashflow{


    protected int dia;
    private int mes;
    private int anio;
    Date fechaCompra;

    public Egreso() {

    };

    public Egreso( Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Egreso( Categoria categoria, Double importe, String descripcion, Date fechaCompra) {
        super(categoria, importe, descripcion);
        this.fechaCompra = fechaCompra;
    }

    @Column(name="FECHA_COMPRA",nullable=false)
    @Temporal(TemporalType.DATE)
    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaCompra);
        anio = cal.get(Calendar.YEAR);
        //el mes arranca desde cero
        // The first month of the year in the Gregorian and Julian calendars is JANUARY which is 0
        dia = cal.get(Calendar.DAY_OF_MONTH);
        setMes( cal.get(Calendar.MONTH)+1);
    }


/*
    @Enumerated(EnumType.STRING)
    @Column(name = "MONEDA", nullable=true, length=10)
    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }
*/

    @Column(name="MES",nullable=false)
    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    @Column(name="ANIO",nullable=false)
    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Transient
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }


}
