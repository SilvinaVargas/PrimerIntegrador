package com.company;

import java.util.*;
import java.util.concurrent.Callable;

public class Automotor {

    private Propietario propietario;
    private List<AutorizadoAConducir> autorizadosAConducir = new ArrayList<>();
    private TipoDeVehiculo tipoDeVehiculo;
    private Uso uso;
    private Patente patente;
    private Date fecha;

    public Automotor() {
    }

    public Automotor(Propietario propietario, Patente patente, Date fecha) {
        this.propietario = propietario;
        this.patente = patente;
        this.fecha = fecha;
    }

    public Automotor(Propietario propietario, TipoDeVehiculo tipoDeVehiculo, Uso uso, Patente patente, Date fecha) {
        this.propietario = propietario;
        this.tipoDeVehiculo = tipoDeVehiculo;
        this.uso = uso;
        this.patente = new Patente();
        this.fecha = fecha;
    }

    public void registrarAutomotor(){
        Scanner sc = new Scanner(System.in);
        Dni dni = new Dni();
        dni.ingresarDatosPropietariosYOtros();
        System.out.print("Tiene factura de compra? ");
        boolean factura = sc.nextBoolean();
        sc.nextLine();
        System.out.print("Ingrese solicitud tipo: ");
        String solicitud = sc.nextLine();
        Propietario propietario = new Propietario(dni,factura,solicitud);
        Date fecha = new Date();
        System.out.println("");
        Patente patente = new Patente();
        patente.asignarPatente();
        System.out.println("\nIngrese el tipo de vehiculo");
        System.out.println("0- Moto electrica\n1- Auto electrico\n2- Moto a combustion\n3- Auto a combustion\n4- Colectivo" +
                "\n5- Utilitario\n6- Camion");
        int opcionTipoVehiculo = Integer.parseInt(sc.nextLine());
        TipoDeVehiculo tipoDeVehiculo = TipoDeVehiculo.valueOf(TipoDeVehiculo.values()[opcionTipoVehiculo].name());
        switch (opcionTipoVehiculo){
            case 0:
                TipoDeVehiculo.MOTO_ELECTRICA.name();
                break;
            case 1:
                TipoDeVehiculo.AUTO_ELECTRICO.name();
                break;
            case 2:
                TipoDeVehiculo.MOTO_A_COMBUSTION.name();
                break;
            case 3:
                TipoDeVehiculo.AUTO_A_COMBUSTION.name();
                break;
            case 4:
                TipoDeVehiculo.COLECTIVO.name();
                break;
            case 5:
                TipoDeVehiculo.UTILITARIOS.name();
                break;
            case 6:
                TipoDeVehiculo.CAMION.name();
                break;
        }

        System.out.println("Ingrese uso del vehiculo\n0- Particular\n1- Profesional");
        int numeroUso = Integer.parseInt(sc.nextLine());
        Uso uso = Uso.valueOf(Uso.values()[numeroUso].name());
        switch(numeroUso){
            case 0:
                Uso.PARTICULAR.name();
                break;
            case 1:
                Uso.PROFESIONAL.name();
                break;
        }
        List<Automotor>automotors = new ArrayList<>();
        System.out.println("* 1- Si desea agregar otro automotor ingrese numero\n* 2- Si" +
                "desea listar todos los vehiculos Ingrese\n* 0- Si desea ir al menu principal ");
        int opcion = sc.nextInt();
        sc.nextLine();
        if (opcion == 0){
            Sistema sistema = new Sistema();
            sistema.desplegarMenu();
        }
        else if (opcion == 1) {
            agregarAuto();
        }else
        if(opcion == 2) {
        }
        System.out.println("4444444");
        System.out.println("Propietario"+propietario.datosPropietario()+"\nTipo de Vehiculo: "+tipoDeVehiculo+"\nPatente: "
        +patente.datosPatente()+"\nFecha: "+fecha);
    }

    private void agregarAuto() {
        registrarAutomotor();
        List<Automotor>automotors = new ArrayList<>();
        automotors.add(new Automotor());
    }

    public void cambioDePropietario() {
        Scanner sc = new Scanner(System.in);
        Date fecha = new Date();
        System.out.println("***** Ingrese los datos del propietario actual del vehiculo *****");
        Dni dni = new Dni();
        dni.ingresarDatosPropietariosYOtros();
        Propietario propietario = new Propietario(dni,true,"01");
        Patente patente = new Patente();
        patente.ingresarDatosPatente();
        System.out.println("*************************************************************");
        System.out.println("DATOS DEL VEHICULO INGRESADO PARA TRÁMITE DE CAMBIO DE DUEÑO: ");
        System.out.println("");
        System.out.println(propietario.datosPropietario()+" "+patente.datosPatente());
        System.out.println("");
        System.out.println("***** Ingrese datos del nuevo dueño *****");
        System.out.println("");
        dni.cambiarDatospropietario(propietario);
        System.out.println("DATOS NUEVOS INGRESADOS");
        System.out.println(propietario.datosPropietario()+patente.datosPatente()+"\nFecha de cambio: "+fecha);
        System.out.println("\nCambio registrado con éxito");
    }

    public void mostrarDatos(){
        System.out.println("patente: "+patente);
        System.out.println("fecha: "+fecha);
        System.out.println("uso: "+uso);
        System.out.println("tipo: "+tipoDeVehiculo);
        System.out.println("titulas: "+propietario.getNombre());
    }



    @Override
    public String toString() {
        return "Automotor{" +
                "propietario=" + propietario+
                ", autorizadosAConducir=" + autorizadosAConducir +
                ", tipoDeVehiculo=" + tipoDeVehiculo +
                ", uso=" + uso +
                ", patente=" + patente +
                ", fecha=" + fecha +
                '}';
    }

    public void agregarAutorizadosAConducir(AutorizadoAConducir autorizadoAConducir){
         autorizadosAConducir.add(autorizadoAConducir);
    }

    public void crearAutomotor( Propietario propietario,Patente patente,Date fecha){
    }

    public Propietario buscarTitularXPatente(Patente patente){  //pide los datos

        return propietario;
    }

    public void ingresarCamionTipo(){
        if(tipoDeVehiculo.equals(TipoDeVehiculo.CAMION)){
            System.out.println("ingresar camion");
        }
    }



}