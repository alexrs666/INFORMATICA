/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practicas_java.Practica_5.P5_EJE4_JAVA;

/**
 *
 * @author AlexRs
 */
public class CoroPorHileras extends Coro{
    private int DH,DI,DL;
    private Corista[][] corista;

    public CoroPorHileras(String nombre, Director director,int cantHileras,int cantIntegrantes) {
        super(nombre, director);
        this.DL = 0;
        this.DH = cantHileras;
        this.DI = cantIntegrantes;
        this.corista = new Corista[this.DH][this.DI];
        
        /*for(int i=0;i<this.DH;i++){
            for(int j=0;j<this.DI;j++)
                this.corista[i][j]= null;
        }
        */
    }
    public void agregarCorista(Corista corista){
        if(!estaLleno()){
            this.corista[this.DL/this.DI][this.DL%this.DI]=corista;
            this.DL ++;
        }
    }
    public boolean estaLleno(){
        return this.DL == this.DH * this.DI;
    }
    public boolean estaBienFormado(){
        int i=0;
        boolean cumple = false;
        if(estaLleno()){
            cumple = true;
            while(i<this.DH && cumple){
                int posAnt= this.corista[i][0].getTono();
                int j=1;
                while(j<this.DI && cumple){
                    cumple=(this.corista[i][j].getTono() == posAnt);
                    j++;
                }
                i++;
            }
        }
        return cumple;
    }

    public String toString(){
        String aux="datos del coro:"+super.toString()+"\n";
        for(int i=0;i<this.DL;i++){
            aux+=" :"+this.corista[i/this.DI][i%this.DI].toString()+"\n";
        }
        return aux;
    }
    
}
