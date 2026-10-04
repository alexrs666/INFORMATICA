/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practicas_java.Practica_4;

/**
 *
 * @author AlexRs
 */
public class SistemaAnual extends Estacion {

    public SistemaAnual(String nombre, double latitud, double longitud, int A, int N) {
        super(nombre, longitud, latitud, A, N);
    }
    public String reportePromedios(){
        String reporte="";
        int DF= this.getA()+ this.getN();
        
        for (int i= this.getA();i < DF;i++){
            double sumasTemp=0;
            for(int j=1;j<=12;j++){
                sumasTemp+= this.obtenerTemp(i,j);
            }
            double prom=(sumasTemp/12);
            reporte += "-Año " + i +": "+ prom + " oC;\n";
        }
        return reporte;
    }
}
