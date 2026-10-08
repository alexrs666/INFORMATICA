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
public class CoroSemiCircular extends Coro{
    private int DF,DL;
    private Corista[] corista;

    public CoroSemiCircular(String nombre, Director director,int cantCorista) {
        super(nombre, director);
        this.DL = 0;
        this.DF = cantCorista;
        this.corista = new Corista[this.DF];
    }
    
    public void agregarCorista(Corista corista){
        this.corista[DL++]=corista;
    }
    public boolean estaLleno(){
        return this.DL == this.DF;
    }
    public boolean estaBienFormado(){
        boolean cumple=false;
        if(estaLleno()){
            cumple=true;
            int posAnt = this.corista[0].getTono();
            int i=1;
            while(i<this.DF && cumple){
                int posAct = this.corista[i].getTono();
                cumple=(posAnt>posAct);
                posAnt=posAct;
                i++;
            }
        }
        return cumple;
    }
    public String toString(){
        String aux="datos del director:"+super.toString();
        for(int i=0;i<this.DL;i++){
            aux+= this.corista[i].toString()+"\n";
        }
        return aux;
    }
    
}
