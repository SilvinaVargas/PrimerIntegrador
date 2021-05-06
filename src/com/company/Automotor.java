package com.company;

import java.util.*;
public class Automotor implements Comparable<Propietario> {

    private Propietario propietario;
    private List<AutorizadoAConducir> autorizadosAConducir = new ArrayList<>();
    private TipoDeVehiculo tipoDeVehiculo;
    private Uso uso;
    private Patente patente;
    private Date fecha;

    public Automotor() {
    }

    public Automotor(Propietario propietario, Patente patente) {
        this.propietario = propietario;
        this.patente = patente;
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


    public void ingresarVoltageMoto(){
        Propietario propietario = new Propietario("Soledad Rivas");
        MotoElectrica me = new MotoElectrica(propietario,TipoDeVehiculo.MOTO_ELECTRICA,Uso.PARTICULAR);
        Integer moto = me.indicarVoltaje();
        System.out.println("Propietaria/o: "+propietario.getNombre()+"\nTipo de Vehiculo: "+TipoDeVehiculo.MOTO_ELECTRICA+" "+"\nUso: "+Uso.PARTICULAR);
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

    public Automotor preguntarXPatente(String primero, int segundo, String tercero) {
        String [] nombres = {"Andrea Lima","Karina Morelo","Griselda Fernandez","Florencia Chart","Lorena Flores"};
        String nombre = new String();
        for(int i=0;i<1;i++){
            nombre=nombres[(int)(Math.random()*5)];
        }

        String [] direcciones = {"San Martin 458","Moreno 478","Ruibal 789","La Rioja 78","Uriburu 896"};
        String direccion = new String();
        for(int i=0;i<1;i++){
            direccion=direcciones[(int)(Math.random()*5)];
        }

        Random numero = new Random();
        int numDni = 0;
        for(int i=0;i<9;i++){
            numDni=(numero.nextInt(38999999-18456365+1)+18456365);
        }

        Dni dni = new Dni(nombre,numDni,direccion);
        Propietario propietario = new Propietario(nombre);
        Patente patente = new Patente(primero,segundo,tercero);
        Automotor automotor = new Automotor(propietario,patente);
        System.out.println(patente.datosPatente()+"\nNombre del Propietario: "+propietario.getNombre()+"\nDni: "+dni.getNumDni()+"\nDireccion: "+dni.getDireccion());
        return  automotor;
    }


    public void ordenarNombrePropietario() {
        List<Propietario>propietarios = new ArrayList<>();
        propietarios.add(new Propietario("Ricardo Lopez",28012322,"San Martin 452"));
        propietarios.add(new Propietario("Lorena Juanse",12456325,"Moreno 487"));
        propietarios.add(new Propietario("Zulema Ferragut",35216452,"Lugones 1254"));
        propietarios.add(new Propietario("Brisa Saturnino",25489654,"Ruibal 78"));

        System.out.println("                      **** NOMBRE DE PROPIETARIOS REGITRADOS **** ");
        System.out.println(" ");
        for (Propietario p:propietarios) {
            System.out.println("NOMBRE: "+p.getNombre()+"\nNUMERO DNI:"+p.getNumDni()+"\nDIRECCION: "+p.getDireccion()+
                    "\nTIPO DE VEHICULO: "+TipoDeVehiculo.CAMION+"\nUSO: "+Uso.PROFESIONAL+"\n\n");

        }

        Collections.sort(propietarios);

        System.out.println(" ");
        System.out.println("        **** NOMBRE DE PROPIETARIOS REGITRADOS ORDENADOS ALFABETICAMENTE **** ");
        System.out.println(" ");
        for (Propietario p:propietarios) {
            System.out.println("NOMBRE: "+p.getNombre()+"\nNUMERO DNI:"+p.getNumDni()+"\nDIRECCION: "+p.getDireccion()+
                    "\nTIPO DE VEHICULO: "+TipoDeVehiculo.CAMION+"\nUSO: "+Uso.PROFESIONAL+"\n\n");

        }


    }

    @Override
    public int compareTo(Propietario o) {
        return o.getNombre().compareTo(o.getNombre());
    }
}