package com.company;

import java.util.Scanner;

public class Dni {

    private String nombre;
    private Integer numDni;
    private String direccion;

    public Dni() {
    }

    public Dni(String nombre) {
        this.nombre = nombre;
    }

    public Dni(String nombre, int numDni,String direccion  ) {
        this.nombre = nombre;
        this.numDni = numDni;
        this.direccion = direccion;
    }

    public Dni crearDni(String nombre, int numDni, String direccion){         //USO
        Dni nuevoDni = new Dni(nombre, numDni,direccion);
        return nuevoDni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumDni() {
        return numDni;
    }

    public void setNumDni(Integer numDni) {
        this.numDni = numDni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void ingresarDatosPropietariosYOtros(){
        Scanner sc = new Scanner(System.in);
        System.out.println("***** LOS DATOS INGRESADOS DEBEN COINCIDIR CON LOS DATOS DEL DNI *****");
        System.out.println("");
        System.out.print("Ingrese nombre completo: ");
        nombre = sc.nextLine();
        System.out.print("Ingrese num de Dni: ");
        numDni = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese direccion: ");          //USO
        direccion = sc.nextLine();
    }

    public void cambiarDatospropietario(Propietario propietario){
        Scanner sc = new Scanner(System.in);
        System.out.println("***** LOS DATOS INGRESADOS DEBEN COINCIDIR CON LOS DATOS DEL DNI *****");
        System.out.println("");
        System.out.println("Ingrese el nuevo nombre completo: ");
        setNombre(sc.nextLine());
        System.out.println("Ingrese num de Dni: ");
        setNumDni(sc.nextInt());
        sc.nextLine();                                            //USO
        System.out.println("Ingrese direccion: ");
        setDireccion(sc.nextLine());
    }


    public String datosDni(){
        String d = "Nombre y Apellido: "+nombre+"\nDNI: "+numDni+"\nDomicilio: "+direccion;
        return d;
    }

    @Override
    public String toString() {
        return "Dni{" +
                "nombre='" + nombre + '\'' +
                '}';
    }


}
