/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practicas_java.Practica_5.P5_EJE3_JAVA;

/**
 *
 * @author AlexRs
 */
public class Gira extends Recital{
    private String nombre;
    private Fecha [] fecha;
    private int fechaAct;
    private int DL,DF;

    public Gira(String nomBanda,int cantTem,String nombre,int cantMax) {
        super(nomBanda,cantTem);
        setNombre(nombre);
        this.DL = 0;
        this.fechaAct = 0;
        this.DF = cantMax;
        this.fecha = new Fecha[this.DF];
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregarFechas(Fecha fechaGira){
        if(this.DL<this.DF)
            this.fecha[this.DL++]=fechaGira;
    }
    
    public void actuacion(){
        
        System.out.println("los esperamos en:"+this.fecha[this.fechaAct].getCiudad());
        super.actuacion();
        this.fechaAct++;
        if(this.fechaAct>=this.DL)
            this.fechaAct = 0;
    }
    public double calcularCosto(){
        return 30000 * this.DL;
    }
}
