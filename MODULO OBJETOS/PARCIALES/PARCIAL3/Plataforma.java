/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PARCIAL3;

/**
 *
 * @author Usuario
 */
public class Plataforma {
    private String nombre;
    private Sede[] sedes;
    private final int DF=10;
    private int DL;
    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.DL=0;
        this.sedes = new Sede[this.DF];
    }
    public void agregarSede(Sede sedes){
        this.sedes[this.DL++]=sedes;
    }
    public void agregarInscripcion(int nroSede,Inscripcion inscripcion){
        this.sedes[nroSede-1].agregarInscripcion(inscripcion);
    }
    public int sedeMayorRecaudacion(){
        double max=-1;
        int pos=0;
        for(int i=0;i<this.DL;i++){
            double actual=this.sedes[i].recaudacionSede();
            if(actual>max){
                max=actual;
                pos=i;
            }
        }
        return pos+1;
    }
    public String toString(){
        String aux="plataforma:"+nombre+" cantidad sedes:"+this.DL+"\n";
        for(int i=0;i<this.DL;i++){
            aux+=" sede:"+(i+1)+this.sedes[i].toString()+"\n";
        }
        return aux;
    }
}
