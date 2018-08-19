package ar.gaf.mycashflow.model.entities;

import java.util.Date;

/**
 * Created by gforrade on 2/9/16.
 * Copyright (c) 2016, GAF Software INC.
 */
public class Presupuesto extends BaseCashflow {

    private Date fechaDesde;
    private Date fechaHasta;
    private int cantidadMeses;


    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public int getCantidadMeses() {
        return cantidadMeses;
    }

    public void setCantidadMeses(int cantidadMeses) {
        this.cantidadMeses = cantidadMeses;
    }
}
