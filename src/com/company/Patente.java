package com.company;

import java.util.Random;
import java.util.Scanner;

public class Patente {

    private String primeros;
    private int segundos;
    private String terceros;

    public Patente(String primero, int segundo, String
            tercero) {
        this.primeros = primero;
        this.segundos = segundo;
        this.terceros = tercero;
    }


    public Patente() {

    }

    public int generarNumAleatorio(){
        int numAleatorio = 0;
        numAleatorio = (int) (Math.random()*999+99);
        return numAleatorio;
    }

    public String generarNumPatente(){
        String patente = "";
        for(int i=1;i<3;i++){
            int num = (int )((Math.random()*(('z'-'a')+1))+'a');
            char letra = (char)num;
            patente = patente + letra;
        }
        return patente.toUpperCase();
    }


    public void ingresarDatosPatente(){
        Scanner sc = new Scanner(System.in);
        Dni dni = new Dni();
        System.out.println("Introduzca los datos de la patente a nombre de: "+dni.getNombre());
        System.out.println("Ingrese los dos primeros dígitos - (LETRAS entre A y C)");
        primeros=sc.nextLine().toUpperCase();
        System.out.println("Ingrese los NUMEROS de la patente");                       //USO
        segundos = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese los dos últimos dígitos - (LETRAS entre la A y Z)");
        terceros=sc.nextLine().toUpperCase();
    }


    public String getPrimeros() {
        return primeros;
    }

    public void setPrimeros(String primeros) {
        this.primeros = primeros;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public String getTerceros() {
        return terceros;
    }

    public void setTerceros(String terceros) {
        this.terceros = terceros;
    }

    public String datosPatente(){
        return"Numero de Patente: "+getPrimeros()+" "+getSegundos()+" "+getTerceros();    //USO
    }

}
