/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PARCIAL5;

/**
 *
 * @author Usuario
 */
public class Laboratorio {
    private String nombre;
    private Programador[] programadores;
    private int DL;
    private int DF;
    public Laboratorio(String nombre, int capacidadMax) {
        this.nombre = nombre;
        this.DF = capacidadMax;
        this.DL=0;
        this.programadores = new Programador[this.DF];
    }
    public int asientosLibre(){
        return this.DF - this.DL;
    }
    
    public String agregarProgramador(Programador p){
        this.programadores[this.DL++]=p;
        return nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    public int cantLenguaje(String lenguaje){
        int canL=0;
        for(int i=0;i<this.DL;i++){
            if(this.programadores[i].getLenguaje().equals(lenguaje))
                canL++;
        }
        return canL;
    }
    public void asignarAños(int DNI,int años){
        int i=0;
        boolean encontre=false;
        while(i<this.DL && !encontre){
            if(this.programadores[i].getDNI() == DNI){
                this.programadores[i].setAñosExp(años);
                encontre=true;
            }
            i++;
        }
    }
    public String toString(){
        String aux=" nombre:"+nombre+" cantidad programadores:"+this.DL+"\n";
        for(int i=0;i<this.DL;i++){
            aux+=" programador:"+(i+1)+" :"+this.programadores[i].toString()+"\n";
        }
        return aux;
    }
}
