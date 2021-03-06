package com.company;

import java.text.SimpleDateFormat;
import java.util.*;

public class Sistema {

    public void saludar() {
        System.out.println("*******************************************************************");
        System.out.println("*         BIENVENIDA/O AL SISTEMA DE REGISTRO AUTOMOTOR           *");
        System.out.println("*******************************************************************");

    }

    public void desplegarMenu() {
        int salirSistema = 0;
        Scanner sc = new Scanner(System.in);
        RegistroSeccional registroSeccional = new RegistroSeccional();
        List<RegistroSeccional> registros = new ArrayList<>();
        Automotor automotor = new Automotor();
        Dni dni = new Dni();
        Propietario propietario = new Propietario("x");
        List<Automotor> nuevosAutomotores = new ArrayList<>();
        Patente patente = new Patente();
        String primeros = patente.generarNumPatente();
        int segundos = patente.generarNumAleatorio();
        String terceros = patente.generarNumPatente();
        Date fecha = new Date();
        int volverMenu = 0;

        int opcionSalir = 0;
        int opcionMenu = 0;

            System.out.println("                   OPCIONES DE TRÁMITE                  ");
            System.out.println("*****   *****   *****   INGRESE    *****   ******  *****");
            System.out.println("( 1 ) Registrar una nueva seleccional");
            System.out.println("( 2 ) Registrar un Automotor");
            System.out.println("( 3 ) Cambiar Propietario");
            System.out.println("( 4 ) Dar de alta un Automotor");
            System.out.println("( 5 ) Ordenar Alfabéticamente los nombres de propietarios de camiones");
            System.out.println("( 6 ) Indicar voltaje de moto eléctrica");
            System.out.println("( 0 ) Salir del sistema");

            opcionMenu = Integer.parseInt(sc.nextLine());
            switch (opcionMenu) {
                case 0:
                    salirSistema();
                    break;
                case 1:
                    do {
                        System.out.print("-- Ingresar numero de Seccional --> ");
                        int numeroDeSeccional = Integer.parseInt(sc.nextLine());
                        System.out.print("-- Ingrese la ciudad a la que pertenece dicha seccional --> ");
                        String ciudad = sc.nextLine();
                        System.out.print("Ingrese el numero de telefono, deberán anteponer al número local el prefijo (+54 9...)--> ");
                        String numeroTelefono = sc.nextLine();
                        try {
                            registroSeccional.agregarRegistro(numeroDeSeccional, ciudad, numeroTelefono);
                        } catch (TelefonoException e) {
                            e.printStackTrace();
                        }
                        try {
                            registros.add(new RegistroSeccional(numeroDeSeccional, ciudad, numeroTelefono));
                        } catch (TelefonoException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Ingrese\n 1 - Registrar otra Seccional\n 2 - Listar registros");
                        opcionSalir = Integer.parseInt(sc.nextLine());

                    } while (opcionSalir == 1);
                    if (opcionSalir == 2) {
                        for (RegistroSeccional r : registros) {
                            System.out.println(r.toString());
                        }
                    }
                    do {
                        System.out.println("");
                        System.out.println("Presione:\n1 - Volver al menú principal\n0 - Salir del Sistema");
                        volverMenu = Integer.parseInt(sc.nextLine());
                        if (volverMenu == 1) {
                            desplegarMenu();
                        }else if(volverMenu == 0){
                            salirSistema();
                        }
                    } while (volverMenu != 1 && volverMenu !=0);
                    break;
                case 2:
                    int terminar = 0;
                    int interno_if = 0;
                    do {
                        System.out.println("***** LOS DATOS INGRESADOS DEBEN COINCIDIR CON LOS DATOS DEL DNI *****");
                        System.out.println("");
                        System.out.print("Ingrese nombre completo: ");
                        String nombre = sc.nextLine();
                        System.out.print("Ingrese num de Dni: ");
                        int numDni = Integer.parseInt(sc.nextLine());
                        System.out.print("Ingrese direccion: ");
                        String direccion = sc.nextLine();

                        Dni nuevoDni = dni.crearDni(nombre, numDni, direccion);
                        System.out.println(nuevoDni.datosDni());

                        System.out.print("Indique true o false - Tiene factura de compra?  ");
                        boolean factura = sc.nextBoolean();
                        sc.nextLine();
                        System.out.print("Ingrese solicitud tipo: ");
                        String solicitud = sc.nextLine();


                        Propietario nuevoPropietario = propietario.crearPropietario(nuevoDni, factura, solicitud);
                        System.out.println(nuevoPropietario.datosPropietario());

                        System.out.println("\nIngrese el tipo de vehiculo");
                        System.out.println("0- Moto electrica\n1- Auto electrico\n2- Moto a combustion\n3- Auto a combustion\n4- Colectivo" +
                                "\n5- Utilitario\n6- Camion");
                        int opcionTipoVehiculo = Integer.parseInt(sc.nextLine());
                        TipoDeVehiculo tipoDeVehiculo = TipoDeVehiculo.valueOf(TipoDeVehiculo.values()[opcionTipoVehiculo].name());
                        switch (opcionTipoVehiculo) {
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
                        switch (numeroUso) {
                            case 0:
                                Uso.PARTICULAR.name();
                                break;
                            case 1:
                                Uso.PROFESIONAL.name();
                                break;
                        }

                        System.out.println("Ingrese\n0 - registrar otro Automotor\n1 - para listar los vehículos ingresados ");
                        terminar = Integer.parseInt(sc.nextLine());
                        automotor.crearAutomotor(nuevoPropietario, tipoDeVehiculo, uso, patente, fecha);
                        nuevosAutomotores.add(new Automotor(nuevoPropietario, tipoDeVehiculo, uso, patente, fecha));
                    } while (terminar != 1);
                    if (terminar == 1) {
                        for (Automotor s : nuevosAutomotores) {
                            System.out.println(s.getPropietario().datosPropietario() + "\n" + s.getTipoDeVehiculo() + "\n" + s.getUso() + "\nPATENTE: " + primeros + " " + segundos + " " + terceros + "\n" + s.getFecha());
                        }
                    }
                    do {
                        System.out.println("");
                        System.out.println("Presione:\n1 - Volver al menú principal\n0 - Salir del Sistema");
                        volverMenu = Integer.parseInt(sc.nextLine());
                        if (volverMenu == 1) {
                            desplegarMenu();
                        }else if(volverMenu == 0){
                            salirSistema();
                        }
                    } while (volverMenu != 1 && volverMenu !=0);
                    break;
                case 3:
                    System.out.println("                  INGRESE                         ");
                    System.out.println("Dos primeros dígitos - (LETRAS entre A y Z)");
                    String primero=sc.nextLine().toUpperCase();
                    System.out.println("Tres NUMEROS de la patente");
                    int segundo = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Dos últimos dígitos - (LETRAS entre la A y Z)");
                    String tercero=sc.nextLine().toUpperCase();
                    Automotor auto = automotor.preguntarXPatente(primero ,segundo,tercero);
                    int dia = 0;
                    dia = (int) (Math.random()*30+1);
                    int mess = 0;
                    mess = (int) (Math.random()*10+2);
                    int anio = 0;
                    anio = (int) (Math.random()*20+2000);
                    System.out.println("Ultima fecha de cambio registrada: "+dia+"-"+mess+"-"+anio);
                    if(mess <=5 && anio>=2019){
                        System.out.println("");
                        System.out.println("Debido al poco tiempo de la última fecha de cambio, no podrá realizarse el trámite.\nVuelva dentro de unos mese");
                    }else{
                        System.out.println("");
                        System.out.println("Puede realizar el trámite de cambio de Propietario");
                    }
                    System.out.println("***** LOS DATOS INGRESADOS DEBEN COINCIDIR CON LOS DATOS DEL DNI *****");
                    System.out.println("");
                    System.out.print("Nombre completo: ");
                    String nombreNuevoP = sc.nextLine();
                    System.out.print("Numero de Dni: ");
                    int numDniNuevo = Integer.parseInt(sc.nextLine());                                            //USO
                    System.out.print("Direccion: ");
                    String nuevaDir = sc.nextLine();
                    Dni dniCambio = dni.crearDni(nombreNuevoP,numDniNuevo,nuevaDir);
                    System.out.println("");
                    System.out.println("        DATOS DEL NUEVO PROPIETARIO:      ");
                    System.out.println("");
                    System.out.println(dniCambio.datosDni()+"\nPatente: "+primero+" "+segundo+" "+tercero+"\nFecha de Cambio Registrada: "+fecha);
                    do {
                        System.out.println("");
                        System.out.println("Presione:\n1 - Volver al menú principal\n0 - Salir del Sistema");
                        volverMenu = Integer.parseInt(sc.nextLine());
                        if (volverMenu == 1) {
                            desplegarMenu();
                        }else if(volverMenu == 0){
                            salirSistema();
                        }
                    } while (volverMenu != 1 && volverMenu !=0);
                    break;
                case 4:
                    System.out.println("DESDE FEBRERO DEL AÑO 2017 LOS TITULOS DE LA PROPIEDAD SON DIGITALES ");
                    System.out.println("INGRESE LOS DATOS REQUERIDOS");
                    System.out.print("email de contacto: ");
                    String email = sc.nextLine();
                    System.out.print("Numero de CUIT/CUIL: ");
                    String numeroCuitl = sc.nextLine();
                    System.out.println("DATOS DEL TITULO DE LA PROPIEDAD DEL AUTOMOTOR");
                    System.out.print("Nombre completo: ");
                    String nombre = sc.nextLine();
                    System.out.print("Numero de Dni: ");
                    int numDni = Integer.parseInt(sc.nextLine());
                    System.out.print("Direccion: ");
                    String direccion = sc.nextLine();
                    Dni nuevoDni = dni.crearDni(nombre, numDni, direccion);
                    System.out.print("Número de Chasis: ");
                    String numeroChasis = sc.nextLine().toUpperCase();
                    System.out.print("Número de motor: ");
                    String numeroMotor = sc.nextLine().toUpperCase();
                    System.out.print("Modelo de vehículo: ");
                    String modeloVehi = sc.nextLine().toUpperCase();
                    System.out.println("***** DATOS INGRESADOS *****");
                    System.out.println(nuevoDni.datosDni() + "\nCUIT/CUIL: " + numeroCuitl + "\nNUMERO DE CHASIS: " + numeroChasis +
                            "\nNUMERO DE MOTOR: " + numeroMotor + "\nMODELO: " + modeloVehi);
                    System.out.println("");
                    System.out.println("Una vez asignado el título  será enviado al correo electrónico: " + email);
                    System.out.println("");
                    do {
                        System.out.println("");
                        System.out.println("Presione:\n1 - Volver al menú principal\n0 - Salir del Sistema");
                        volverMenu = Integer.parseInt(sc.nextLine());
                        if (volverMenu == 1) {
                            desplegarMenu();
                        }else if(volverMenu == 0){
                            salirSistema();
                        }
                    } while (volverMenu != 1 && volverMenu !=0);
                    break;
                case 5:
                    automotor.ordenarNombrePropietario();
                    do {
                        System.out.println("Presione 0 para volver al menú principal");
                        volverMenu = Integer.parseInt(sc.nextLine());
                        if (volverMenu == 0) {
                            desplegarMenu();
                        }
                    } while (volverMenu != 0);
                    break;
                case 6:
                    automotor.ingresarVoltageMoto();
                    do {
                        System.out.println("");
                        System.out.println("Presione:\n1 - Volver al menú principal\n0 - Salir del Sistema");
                        volverMenu = Integer.parseInt(sc.nextLine());
                        if (volverMenu == 1) {
                            desplegarMenu();
                        }else if(volverMenu == 0){
                            salirSistema();
                        }
                    } while (volverMenu != 1 && volverMenu !=0);
                    break;
                default:
                    System.out.println("Numero incorrecto, vuelva a intentarlo ");
                    do {
                        System.out.println("");
                        System.out.println("Presione:\n1 - Volver al menú principal\n0 - Salir del Sistema");
                        volverMenu = Integer.parseInt(sc.nextLine());
                        if (volverMenu == 1) {
                            desplegarMenu();
                        }else if(volverMenu == 0){
                            salirSistema();
                        }
                    } while (volverMenu != 1 && volverMenu !=0);
                    break;
            }
    }

    public void salirSistema() {
        System.out.println("");
        System.out.println("*******************************************************************");
        System.out.println("*            USTED SALIÓ DEL SISTEMA DE REGISTROS                 *");
        System.out.println("*******************************************************************");
    }

}

