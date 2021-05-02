package com.company;

import java.util.Scanner;

public class MotoElectrica extends Automotor implements VehiculoElectrico{

    public MotoElectrica(Propietario propietario, TipoDeVehiculo tipoDeVehiculo, Uso uso) {
        super(propietario, tipoDeVehiculo, uso);
    }

    @Override
    public Integer indicarVoltaje() {
        int voltaje =0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Indique voltaje 48 - 60 - 72");
        voltaje = Integer.parseInt(sc.nextLine());
        if(voltaje <= 60){
            System.out.println("LA MOTO CUENTA CON:\nBaterías: Cant. 5\nTipo de motor: Bruchless\nCarga máx: 160kg");
        }else if(voltaje >= 72){
            System.out.println("La moto cuenta con:\nBaterías: Cant. 6\nTipo de motor: Bruchless\nCarga máx: 170kg");
        }
        return voltaje;
    }
}
