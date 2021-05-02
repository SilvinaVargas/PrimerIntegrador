package com.company;

import java.util.ArrayList;
import java.util.List;

public class DNRPA {

    List<List<RegistroSeccional>> registros= new ArrayList<>();


    public DNRPA() {
        this.registros= new ArrayList<>();
    }

    public void agregarRegistro(int numeroDeSeccional, String ciudad, String numeroTelefono) throws TelefonoException {
        /*Scanner sc = new Scanner(System.in);
        System.out.print("-- Ingresar numero de Seccional --> ");
        numeroDeSeccional = sc.nextInt();
        sc.nextLine();
        System.out.print("-- Ingrese la ciudad a la que pertenece dicha seccional --> ");
        ciudad = sc.nextLine();
        System.out.print("Ingrese el numero de telefono, deberán anteponer al número local el prefijo (+54 9...)--> ");
        numeroTelefono = sc.nextLine();*/

        try {
            validarNumeroTelefono(numeroTelefono);
        } catch (TelefonoException e) {
            System.out.println(e.getMessage());
            ;
        }
    }

    private boolean validarNumeroTelefono(String numeroTelefono) throws TelefonoException {
        if (numeroTelefono.length()<12) {
            throw new TelefonoException("El numero introducido es demasiado corto, vuelva a ingresarlo");
        }
        return true;
    }

    public void listarRegistros(List<RegistroSeccional>registross){
        registros.add(registross);

        for (RegistroSeccional r:registross) {
            System.out.println(r.toString());
        }
    }

}
