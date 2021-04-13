package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DNRPA {

    List<RegistroSeccional> registros= new ArrayList<>();


    public DNRPA() {
        this.registros= new ArrayList<>();
    }

    RegistroSeccional registro = new RegistroSeccional();

    public void agregarRegistro(RegistroSeccional registro){
        registros.add(registro);
    }

    public void ingresarDatosRegistro(){
        Scanner sc = new Scanner(System.in);
        System.out.print("-- Ingresar numero de Seccional --> ");
        int numeroDeSeccional = sc.nextInt();
        sc.nextLine();
        System.out.print("-- Ingrese la ciudad a la que pertenece dicha seccional --> ");
        String ciudad = sc.nextLine();
        System.out.print("Ingrese el numero de telefono, deberán anteponer al número local el prefijo (+54 9...)--> ");
        String numeroTelefono = sc.nextLine();

        RegistroSeccional registroSeccional = new RegistroSeccional(numeroDeSeccional,ciudad,numeroTelefono);

        for(int i=0;i<registros.size();i++){
            System.out.println(i+"--> "+ registros.get(i).getNumeroDeSeccional());
        }

    }


}
