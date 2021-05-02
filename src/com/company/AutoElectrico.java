package com.company;

import java.util.Scanner;

public class AutoElectrico extends Automotor implements VehiculoElectrico{

    @Override
    public Integer indicarVoltaje() {
        Scanner sc = new Scanner(System.in);
        int voltaje =0;
        System.out.println("Indique voltaje");
        voltaje = Integer.parseInt(sc.nextLine());
        if(voltaje <= 60){
            System.out.println("Tiene 5 baterías");
        }else if(voltaje >= 72){
            System.out.println("Tiene 6 baterías");
        }
     return voltaje;
    }
}
