package com.company;

import java.util.*;
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

    public Automotor(Propietario propietario, TipoDeVehiculo tipoDeVehiculo, Uso uso) {
        this.propietario = propietario;
        this.tipoDeVehiculo = tipoDeVehiculo;
        this.uso = uso;
    }

    public Automotor(Propietario propietario, TipoDeVehiculo tipoDeVehiculo, Uso uso, Patente patente, Date fecha) {
        this.propietario = propietario;
        this.tipoDeVehiculo = tipoDeVehiculo;
        this.uso = uso;
        this.patente = new Patente();
        this.fecha = fecha;
    }

    public List<Automotor> crearAutomotor(Propietario propietario, TipoDeVehiculo tipoDeVehiculo,Uso uso, Patente patente, Date fecha){
        List<Automotor>nuevosAutomotores = new ArrayList<>();
        nuevosAutomotores.add(new Automotor(propietario,tipoDeVehiculo,uso,patente,fecha));
        return nuevosAutomotores;                                                                 //USO
    }

    public void cambioDePropietario() {
        Scanner sc = new Scanner(System.in);
        Date fecha = new Date();
        System.out.println("***** INGRESE LOS DATOS DEL PROPIETARIO ACTUAL DEL VEHÍCULO *****");
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
        System.out.println("***** INGRESE LOS DATOS DEL NUEVO DUEÑO *****");
        System.out.println("");                                                        //USO
        dni.cambiarDatospropietario(propietario);
        System.out.println("");
        System.out.println("***** LOS NUEVOS DATOS INGRESADOS CORRESPONDEN A: ");
        System.out.println(propietario.datosPropietario()+patente.datosPatente()+"\nFecha de cambio: "+fecha);
        System.out.println("\n------- CAMBIO REGISTRADO CON ÉXITO ------");
    }

    public void ingresarVoltageMoto(){

        Propietario propietario = new Propietario("Soledad Rivas");
        MotoElectrica me = new MotoElectrica(propietario,TipoDeVehiculo.MOTO_ELECTRICA,Uso.PARTICULAR);
        Integer moto = me.indicarVoltaje();
        System.out.println("Propietaria/o: "+propietario.getNombre()+"\nTipo de Vehiculo: "+TipoDeVehiculo.MOTO_ELECTRICA+" "+"\nUso: "+Uso.PARTICULAR);
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

    public Propietario buscarTitularXPatente(Patente patente){  //pide los datos

        return propietario;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public List<AutorizadoAConducir> getAutorizadosAConducir() {
        return autorizadosAConducir;
    }

    public void setAutorizadosAConducir(List<AutorizadoAConducir> autorizadosAConducir) {
        this.autorizadosAConducir = autorizadosAConducir;
    }

    public TipoDeVehiculo getTipoDeVehiculo() {
        return tipoDeVehiculo;
    }

    public void setTipoDeVehiculo(TipoDeVehiculo tipoDeVehiculo) {
        this.tipoDeVehiculo = tipoDeVehiculo;
    }

    public Uso getUso() {
        return uso;
    }

    public void setUso(Uso uso) {
        this.uso = uso;
    }

    public Patente getPatente() {
        return patente;
    }

    public void setPatente(Patente patente) {
        this.patente = patente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}