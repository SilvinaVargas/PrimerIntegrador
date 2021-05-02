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

    public RegistroSeccional(int numeroDeSeccional, String ciudad, String numeroTelefono) throws TelefonoException {
        this.numeroDeSeccional = numeroDeSeccional;
        this.ciudad = ciudad;
        this.numeroTelefono = numeroTelefono;
        validarNumeroTelefono(numeroTelefono);
    }

    public RegistroSeccional(List<Automotor> automotores, int numeroDeSeccional, String ciudad, String numeroTelefono) {
        this.automotores = automotores;
        this.numeroDeSeccional = numeroDeSeccional;
        this.ciudad = ciudad;
        this.numeroTelefono = numeroTelefono;
    }

    public boolean validarNumeroTelefono(String numeroTelefono) throws TelefonoException {
        if (numeroTelefono.length()<9) {
            throw new TelefonoException("El numero introducido es demasiado corto, vuelva a ingresarlo");

        }
        return true;
    }

    public List<RegistroSeccional> agregarRegistro(int numeroDeSeccional, String ciudad, String numeroTelefono) throws TelefonoException {

        try {
            validarNumeroTelefono(numeroTelefono);
        } catch (TelefonoException e) {
            System.out.println(e.getMessage());;
        }
        List<RegistroSeccional>registros = new ArrayList<>();
        registros.add(new RegistroSeccional(numeroDeSeccional, ciudad, numeroTelefono));
        for (RegistroSeccional r:registros) {
            System.out.println(r.toString());
        }
        return registros;
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
                "numeroDeSeccional=" + getNumeroDeSeccional() +
                ", ciudad='" + getCiudad()+ '\'' +
                ", numeroTelefono='" + getNumeroTelefono() + '\'' +
                '}';
    }
}
