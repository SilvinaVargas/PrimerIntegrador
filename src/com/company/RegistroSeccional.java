package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistroSeccional {

    List<Automotor> automotores;
    private int numeroDeSeccional;
    private String ciudad;
    private String numeroTelefono;

    public RegistroSeccional() {
    }

    public RegistroSeccional(int numeroDeSeccional, String ciudad) {
        this.numeroDeSeccional = numeroDeSeccional;
        this.ciudad = ciudad;
    }

    public RegistroSeccional(int numeroDeSeccional, String ciudad, String numeroTelefono) {
        this.numeroDeSeccional = numeroDeSeccional;
        this.ciudad = ciudad;
        this.numeroTelefono = numeroTelefono;
    }

    public boolean validarNumeroTelefono(String numeroTelefono) throws TelefonoException {
        if (numeroTelefono.length()<12) {
            throw new TelefonoException("El numero introducido es demasiado corto, vuelva a ingresarlo");
        }
        return true;
    }

    public void agregarRegistro(){
        Scanner sc = new Scanner(System.in);
        System.out.print("-- Ingresar numero de Seccional --> ");
        numeroDeSeccional = sc.nextInt();
        sc.nextLine();
        System.out.print("-- Ingrese la ciudad a la que pertenece dicha seccional --> ");
        ciudad = sc.nextLine();
        System.out.print("Ingrese el numero de telefono, deberán anteponer al número local el prefijo (+54 9...)--> ");
        numeroTelefono = sc.nextLine();

        try {
            validarNumeroTelefono(numeroTelefono);
        } catch (TelefonoException e) {
            System.out.println(e.getMessage());;
        }

        List<RegistroSeccional> registroSeccionals = new ArrayList<>();
        registroSeccionals.add(new RegistroSeccional(numeroDeSeccional,ciudad,numeroTelefono));
    }
    public void agregarRegi(int numeroDeSeccional,String ciudad,String numeroTelefono){
           RegistroSeccional registroSeccional = new RegistroSeccional(numeroDeSeccional,ciudad,numeroTelefono);
        System.out.println(registroSeccional.toString());
    }

    public void listarAutomotores(){
        for (Automotor a: automotores){
            System.out.println(a.toString());
        }
    }

    public int getNumeroDeSeccional() {
        return numeroDeSeccional;
    }

    public void setNumeroDeSeccional(int numeroDeSeccional) {
        this.numeroDeSeccional = numeroDeSeccional;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public String toString() {
        return "RegistroSeccional{" +
                "numeroDeSeccional=" + numeroDeSeccional +
                ", ciudad='" + ciudad + '\'' +
                ", numeroTelefono='" + numeroTelefono + '\'' +
                '}';
    }
}
