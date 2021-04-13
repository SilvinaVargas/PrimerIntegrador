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

    private String generarPrimerosNumeros(){
        String letras = new String("ABC");
        Random random = new Random();
        byte letra1 = (byte)random.nextInt(2);
        byte letra2 = (byte)random.nextInt(2);
        System.out.print(letras.charAt(letra1));
        System.out.print(letras.charAt(letra2));
        //letras.charAt(letra1);
        //letras.charAt(letra2);
        return primeros;
    }

    private int generarSegundosNumeros(){
        Random random = new Random();
        int uno = random.nextInt(9);
        int dos = random.nextInt(9);
        int tres = random.nextInt(9);
        System.out.print(" "+uno);
        System.out.print(dos);
        System.out.print(tres+" ");
        return segundos;
    }

    private String generarTercerosNumeros(){
        String letras = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        Random random = new Random();
        byte letra1 = (byte)random.nextInt(letras.length()-1);
        byte letra2 = (byte)random.nextInt(letras.length()-1);
        System.out.print(letras.charAt(letra1));
        System.out.print(letras.charAt(letra2));
        return terceros;
    }

    public void asignarPatente(){
        System.out.print("Numero de patente: ");

        Patente patente = new Patente(generarPrimerosNumeros(),generarSegundosNumeros(),generarTercerosNumeros());
    }


    public String datosPatente(){

        return " Numero patente: "+generarPrimerosNumeros()+" "+getSegundos()+" "+getTerceros();
    }


    public void ingresarDatosPatente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca los datos de la patente: ");
        System.out.println("Ingrese los primeros digitos - (letras entre A y C)");
        primeros=sc.nextLine();
        System.out.println("Ingrese los numeros de la patente");
        segundos = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese los ultimos digitos de la - (lettras entre la A y Z)");
        terceros=sc.nextLine();
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


    @Override
    public String toString() {
        return "Patente{" +
                "primeros='" + this.primeros + '\'' +
                ", segundos=" + this.segundos +
                ", terceros='" + this.terceros + '\'' +
                '}';
    }

}
