/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PARCIAL2;

/**
 *
 * @author Usuario
 */
public class Zona {
    private String denominacion;
    private Medicion[] mediciones;
    private int DF,DL;

    public Zona(String denominacion,int M) {
        this.denominacion = denominacion;
        this.DF = M;
        this.DL =0;
        this.mediciones = new Medicion[this.DF];
    }
    
    public void agregarMedicion(Medicion medicion){
        this.mediciones[this.DL++] = medicion;
    }
    public int cantTotalMediciones(){
        int total=0;
        for(int i=0;i<this.DL;i++){
            if(this.mediciones[i].getConsumoSuperaAño()== true)
                total ++;
        }
        return total;
    }
    public String toString(){
        String aux=" denominacion:"+denominacion+"\n";
        for(int i=0;i<this.DL;i++){
            aux+=this.mediciones[i].toString()+"\n";
        }
        return aux;
    }
}
