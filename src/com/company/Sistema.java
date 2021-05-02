package com.company;

import java.text.SimpleDateFormat;
import java.util.*;

public class Sistema {

    public void saludar() {
        System.out.println("*******************************************************************");
        System.out.println("         BIENVENIDA/O AL SISTEMA DE REGISTRO AUTOMOTOR");
        System.out.println("*******************************************************************");

    }

    public void desplegarMenu() {
        Scanner sc = new Scanner(System.in);
        RegistroSeccional registroSeccional = new RegistroSeccional();
        List<RegistroSeccional> registros = new ArrayList<>();
        Automotor automotor = new Automotor();
        Dni dni = new Dni();
        Propietario propietario = new Propietario("x");
        List<Automotor>nuevosAutomotores = new ArrayList<>();
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
        System.out.println("( 5 ) Ordenar Alfabéticamente los nombres de propietarios");
        System.out.println("( 6 ) Indicar voltaje de moto eléctrica");

        opcionMenu=Integer.parseInt(sc.nextLine());
        switch(opcionMenu) {
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
                System.out.println("Ingrese\n 0 - registrar otra Seccional\n 1 - listar registros");
                opcionSalir = Integer.parseInt(sc.nextLine());

            } while (opcionSalir != 1);
            if (opcionSalir == 1) {
                for (RegistroSeccional r : registros) {
                    System.out.println(r.toString());
                }
            }
                do {
                    System.out.println("Presione 0 para volver al menú principal");
                    volverMenu = Integer.parseInt(sc.nextLine());
                    if (volverMenu == 0) {
                        desplegarMenu();
                    }
                }while(volverMenu !=0);
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
                }while (terminar != 1);
                if(terminar == 1 ) {
                    for (Automotor s : nuevosAutomotores) {
                        System.out.println(s.getPropietario().datosPropietario()+"\n"+s.getTipoDeVehiculo()+"\n"+s.getUso()+"\nPATENTE: "+primeros+" "+segundos+" "+terceros+"\n"+s.getFecha());

                        if(TipoDeVehiculo.CAMION==TipoDeVehiculo.CAMION){
                            ;
                        }
                    }
                }
                do {
                    System.out.println("Presione 0 para volver al menú principal");
                    volverMenu = Integer.parseInt(sc.nextLine());
                    if (volverMenu == 0) {
                        desplegarMenu();
                    }
                }while(volverMenu !=0);
                break;
            case 3:
                int cambioVehicular = 0;
                System.out.println("LA FECHA INGRESADA DEBE CORRESPONDER A LA ÚLTIMA FECHA DE CAMBIO VEHICULAR REGISTRADA");
                System.out.println("Ingrese el día  - NUMEROS ENTRE 01 - 31 SEGÚN CORRESPONDA");
                int dias = Integer.parseInt(sc.nextLine());
                System.out.println("Ingrese el mes - NUMEROS ENTRE 01 - 12 SEGÚN CORRESPONDA ");
                int mes = Integer.parseInt(sc.nextLine());
                System.out.println("Ingrese el año ");
                int anho = Integer.parseInt(sc.nextLine());
                if(mes<5 && anho>=2020){
                    System.out.println("No se puede realizar el cambio vehicular debido a que no ha pasado más de año");
                }else{
                    automotor.cambioDePropietario();
                }
                do {
                    System.out.println("Presione 0 para volver al menú principal");
                    volverMenu = Integer.parseInt(sc.nextLine());
                    if (volverMenu == 0) {
                        desplegarMenu();
                    }
                }while(volverMenu !=0);
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
                System.out.println("Presione 0 para volver al menú principal");
                volverMenu = Integer.parseInt(sc.nextLine());
                    if (volverMenu == 0) {
                        desplegarMenu();
                    }
                }while(volverMenu !=0);
                break;
            case 5:
                propietario.ordenarNombres();
                do {
                    System.out.println("Presione 0 para volver al menú principal");
                    volverMenu = Integer.parseInt(sc.nextLine());
                    if (volverMenu == 0) {
                        desplegarMenu();
                    }
                }while(volverMenu !=0);
                break;
            case 6:
                automotor.ingresarVoltageMoto();
                do {
                    System.out.println("Presione 0 para volver al menú principal");
                    volverMenu = Integer.parseInt(sc.nextLine());
                    if (volverMenu == 0) {
                        desplegarMenu();
                    }
                }while(volverMenu !=0);
                break;
            default:
                System.out.println("Numero incorrecto, vuelva a intentarlo ");
                do {
                    System.out.println("Presione 0 para volver al menú principal");
                    volverMenu = Integer.parseInt(sc.nextLine());
                    if (volverMenu == 0) {
                        desplegarMenu();
                    }
                }while(volverMenu !=0);
                break;
        }
    }
}

