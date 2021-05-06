package com.company;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Propietario extends Dni implements Comparable<Propietario>  {

    @Override
    public int compareTo(Propietario o) {
        return getNombre().compareTo(o.getNombre());
    }

    @Override
    public String toString() {
        return "Nombre del propietario/a: "+getNombre()+" Direccion: "+getDireccion();
    }

    private Dni dni;
    private boolean facturaDeCompra;
    private String solicitudTipo;
    private List<Propietario> dnis;

    public Propietario(String nombre) {
        super(nombre);
    }

    public Propietario(String nombre, int numDni, String direccion) {
        super(nombre, numDni, direccion);
    }

    public Propietario(Dni dni, boolean facturaDeCompra, String solicitudTipo) {
        super(solicitudTipo);
        this.dni = dni;
        this.facturaDeCompra = facturaDeCompra;
        this.solicitudTipo = solicitudTipo;
        this.dnis =new ArrayList<>();
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

    public Dni getDni() {
        return dni;
    }

    public void setDni(Dni dni) {
        this.dni = dni;
    }

    public Propietario crearPropietario( Dni dni, boolean facturaDeCompra, String solicitudTipo) {
        Propietario nuevoPropietario = new Propietario(dni,facturaDeCompra,solicitudTipo);
        return nuevoPropietario;
    }


}
