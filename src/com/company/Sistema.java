package com.company;

import java.util.*;

public class Sistema {

    public void saludar(){
        System.out.println("*********************************************");
        System.out.println("BIENVENIDA/O AL SISTEMA DE REGISTRO AUTOMOTOR");
    }

    public void desplegarMenu(){
        Dni dni = new Dni();
        Patente patente = new Patente();
        List<Propietario>propietarios = new ArrayList<>();
        Propietario propietario = new Propietario("");
        RegistroSeccional registroSeccional = new RegistroSeccional();
        Automotor automotor = new Automotor();
        int opcionInterfaz = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecciona el trámite según numero que corresponda  ");
        System.out.println("* 1- Registrar\n* 2- Cambio de propietario\n* 3- \n* 4- Dar de alta\n* 5- Consultar\n");
        opcionInterfaz= sc.nextInt();
        switch (opcionInterfaz){
            case 1:
                    System.out.println("* 1- Registrar Automotor");
                automotor.registrarAutomotor();
            case 2:
                System.out.println("* 2- Registrar fecha de cambio de propietario");
                automotor.cambioDePropietario();
                break;
            case 3:
                int op =0;
                propietario.ingresarPropietariodeCamiones();
                       /* Dni dni2 = new Dni();
                        dni2.ingresarDatosPropietariosYOtros();
                        System.out.print("Posee factura de compra? ");
                        boolean facturaDeCompra = sc.nextBoolean();
                        sc.nextLine();
                        System.out.print("Ingrese solicitud tipo: ");
                        String solicitudTipo = sc.nextLine();
                        propietarios.add(new Propietario(dni2, facturaDeCompra, solicitudTipo));
                        Collections.sort(propietarios);
                        for (Propietario p : propietarios) {
                            System.out.println(p.datosPropietario());
                        }*/
                        //propietario.listarPropietario(dni2, facturaDeCompra, solicitudTipo)
                break;

            case 4:
                /*System.out.println("Ingrese nombre");
                String nombre = sc.next();
                Dni dni1 = new Dni(nombre);
                patente.ingresarDatosPatente();
                Date fecha = new Date();
                System.out.print("Posee factura de compra? ");
                facturaDeCompra = sc.nextBoolean();
                sc.nextLine();
                System.out.print("Ingrese solicitud tipo: ");
                solicitudTipo = sc.nextLine();
                Propietario propietario1 = new Propietario(dni1,facturaDeCompra,solicitudTipo);
                automotor.crearAutomotor(propietario1,patente,fecha);
                System.out.println(patente.datosPatente()+"titular: "+dni1.toString());

                automotor.buscarTitularXPatente(patente);
                propietario1.getNombre();
                break;
            case 5:
                System.out.println("Indique con el número indicado qué desea consultar ");
                break;*/
        }
    }
}
