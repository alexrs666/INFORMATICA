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
public class Sede {
    private String direccion;
    private Inscripcion [] inscripciones;
    private int DF,DL;
    public Sede(String direccion,int maxN) {
        this.direccion = direccion;
        this.DL = 0;
        this.DF = maxN;
        this.inscripciones = new Inscripcion[this.DF];
    }
    public void agregarInscripcion(Inscripcion inscripciones){
        this.inscripciones [this.DL++]= inscripciones;
    }
    public double recaudacionSede(){
        double total=0;
        for(int i=0;i<this.DL;i++){
            total+=this.inscripciones[i].getMonto();
        }
        return total;
    }
    public String toString() {
        String aux= " direccion=" + direccion + "\n";
        for(int i=0;i<this.DL;i++){
            aux+=this.inscripciones[i].toString()+"\n";
        }
        return aux;
    }
    
}
