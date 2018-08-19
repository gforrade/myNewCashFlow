package ar.gaf.mycashflow.model.entities;

import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by gforrade on 2/6/16.
 * Copyright (c) 2016, GAF Software INC.
 */
@Entity
@Table( schema = "MYCASHFLOW" , name = "EGRESO_TARJETA_CREDITO")
@PrimaryKeyJoinColumn(name="ID")
@ToString
public class EgresoTarjetaCredito extends Egreso {

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_TARJETA_CREDITO_FK", referencedColumnName = "ID_TARJETA_CREDITO")
    private TarjetaCredito tarjetaCredito;

    @Column(name="CANTIDAD_CUOTAS",nullable=false)
    private int cantidadCuotas = 1;

    public EgresoTarjetaCredito(){
        tarjetaCredito = new TarjetaCredito();
    };

    public EgresoTarjetaCredito(TarjetaCredito tarjetaCredito, int cantidadCuotas) {
        this.tarjetaCredito = tarjetaCredito;
        this.cantidadCuotas = cantidadCuotas;
    }

    public EgresoTarjetaCredito( Date fechaCompra, TarjetaCredito tarjetaCredito, int cantidadCuotas) {
        super(fechaCompra);
        this.tarjetaCredito = tarjetaCredito;
        this.cantidadCuotas = cantidadCuotas;
    }

    public EgresoTarjetaCredito(Categoria categoria, Double importe, String descripcion, Date fechaCompra, TarjetaCredito tarjetaCredito, int cantidadCuotas) {
        super(categoria, importe, descripcion, fechaCompra);
        this.tarjetaCredito = tarjetaCredito;
        this.cantidadCuotas = cantidadCuotas;
    }

    public TarjetaCredito getTarjetaCredito() {
        return this.tarjetaCredito;
    }

    public void setTarjetaCredito(TarjetaCredito tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public int getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(int cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }



}
