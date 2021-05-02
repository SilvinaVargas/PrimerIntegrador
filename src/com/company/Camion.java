package com.company;

import java.util.Date;

public class Camion extends Automotor implements VehiculoACombustion{

    public Camion(Propietario propietario, Patente patente, Date fecha) {
        super(propietario, patente, fecha);
    }


    @Override
    public void indicarTipoCombustible() {

    }
}
