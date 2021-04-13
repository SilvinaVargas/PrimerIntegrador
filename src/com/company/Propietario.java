package com.company;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Propietario extends Dni implements Comparable<Propietario> {

    private Dni dni;
    private boolean facturaDeCompra;
    private String solicitudTipo;
    private List<Propietario>propietarios;

    public Propietario(String nombre) {
        super(nombre);
    }

    public Propietario(Dni dni, boolean facturaDeCompra, String solicitudTipo) {
        super(solicitudTipo);
        this.dni = dni;
        this.facturaDeCompra = facturaDeCompra;
        this.solicitudTipo = solicitudTipo;
        this.propietarios=new ArrayList<>();
    }

    public boolean isFacturaDeCompra() {
        return facturaDeCompra;
    }

    public boolean setFacturaDeCompra(boolean facturaDeCompra) {
        this.facturaDeCompra = facturaDeCompra;
        return facturaDeCompra;
    }

    public String getSolicitudTipo() {
        return solicitudTipo;
    }

    public String setSolicitudTipo(String solicitudTipo) {
        this.solicitudTipo = solicitudTipo;
        return solicitudTipo;
    }

    public String datosPropietario(){
       String nombre = dni.getNombre();
       int numDni = dni.getNumDni();
       String direccion = dni.getDireccion();
       String datos = "\nNombre: "+nombre+"\nNumero Dni: "+numDni+
               "\nDireccion: "+direccion+"\nTiene factura de compra: "+facturaDeCompra+
               "\nSolicitud tipo: "+solicitudTipo+"\n";
       return datos;
    }

    public void crearPropietario(){
        Scanner sc = new Scanner(System.in);
        Dni dni2 = new Dni();
        dni2.ingresarDatosPropietariosYOtros();
        System.out.print("Posee factura de compra? ");
        facturaDeCompra = sc.nextBoolean();
        sc.nextLine();
        System.out.print("Ingrese solicitud tipo: ");
        solicitudTipo = sc.nextLine();
        List<Propietario>propietarios = new ArrayList<>();
        propietarios.add(new Propietario(dni2,facturaDeCompra,solicitudTipo));
    }


    public Dni getDni() {
        return dni;
    }

    public void setDni(Dni dni) {
        this.dni = dni;
    }

    public void ordenarAlfabeticamente(List<Propietario>propietarios){
        Collections.sort(propietarios);
    }

    @Override
    public int compareTo(Propietario o) {
        return getNombre().compareTo(o.getNombre());
    }

    public void listarPropietario(Dni dni,boolean facturaDeCompra,String solicitudTipo){
        Scanner sc = new Scanner(System.in);
        Dni dni2 = new Dni();
        dni2.ingresarDatosPropietariosYOtros();
        System.out.print("Posee factura de compra? ");
        facturaDeCompra = sc.nextBoolean();
        sc.nextLine();
        System.out.print("Ingrese solicitud tipo: ");
        solicitudTipo = sc.nextLine();
        //Propietario propietario = new Propietario();
        propietarios.add(new Propietario(dni2,facturaDeCompra,solicitudTipo));
        Collections.sort(propietarios);
        for (Propietario p: propietarios){
            System.out.println(p.datosPropietario());
        }
    }

    public void ingresarPropietariodeCamiones(){
        Scanner sc = new Scanner(System.in);
        int exit = 0;
        do {
            String nombre;
            System.out.println("Ingrese nombre del propietario: ");
            nombre = sc.next();
            Dni dni2 = new Dni(nombre);
            System.out.print("Posee factura de compra? ");
            facturaDeCompra = sc.nextBoolean();
            sc.nextLine();
            System.out.print("Ingrese solicitud tipo: ");
            solicitudTipo = sc.nextLine();
            List<Propietario> propietarios = new ArrayList<>();
            propietarios.add(new Propietario(dni2, facturaDeCompra, solicitudTipo));
            System.out.println("si desea listar ingrese 1");
            exit = sc.nextInt();
            sc.nextLine();
        }while (exit !=1);
        Collections.sort(propietarios);
        for (Propietario p:propietarios) {
            System.out.println(p.datosPropietario());
        }
    }




}
