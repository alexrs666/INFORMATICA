/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practicas_java.Practica_5.P5_EJE5_JAVA;

import java.lang.reflect.Array;

/**
 *
 * @author AlexRs
 */
public class Sistema {
    private String nombre;
    private int suscriptores;
    private Estreno [][] agenda;
    private int [] DL;
    private int DC;
    private final int DM=12;

    public Sistema(String nombre, int suscriptores,int CantCategorias) {
        this.nombre = nombre;
        this.suscriptores = suscriptores;
        this.DC = CantCategorias;
        this.agenda = new Estreno [this.DC][this.DM];
        this.DL = new int [this.DC];
        for(int i=0;i<this.DC;i++){
            this.DL[i]=0;
        }
    }
    public void agregarEstreno(int X,Estreno estreno){
        this.agenda[X-1][this.DL[X-1]++] = estreno;
    }
    public String listarEstreno(int X){
        String aux ="";
        int pos=X-1;
        for(int i=0;i<this.DL[pos];i++){
            aux+=this.agenda[pos][i].toString()+"\n";
        }
        
        return aux; 
    }
    public double gananciaTotal(){
        double total=0; 
        for(int i=0;i<this.DC;i++){
            for(int j=0;j<this.DL[i];j++){
                total+=this.agenda[i][j].getRecaudacion();
            }
        }
        return (total/2);
    }
    public String toString(){
        String  aux="plataforma:"+this.nombre+" cantidad de suscriptores:"+this.suscriptores+"\n";
        for(int i=0;i<this.DC;i++){
            for(int j=0;j<this.DL[i];j++){
                aux +=" categoria:"+(i+1)+"estreno en el mes:"+(j+1)+" :"+this.agenda[i][j].toString()+"\n";    
            }
        }
        return aux+= "Ganancias total en estrenos:"+this.gananciaTotal();
    }
}
