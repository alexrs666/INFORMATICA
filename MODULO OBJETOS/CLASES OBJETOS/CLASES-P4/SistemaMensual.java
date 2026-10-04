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
public class SistemaMensual extends Estacion{

    public SistemaMensual(String nombre, double latitud, double longitud, int A, int N) {
        super(nombre, longitud, latitud, A, N);
    }
    public String reportePromedios(){
        String reporte="";
        String nomMeses[]= {"-enero","-febrero","-marzo","-abril","-mayo","-junio","-julio","-agosto","-septiembre","-octubre","-noviembre","-diciembre"};
        int DF= this.getA()+ this.getN();
        for (int j=1;j<=12;j++){
            double sumasTemp=0;
            for(int i = this.getA();i<DF;i++){
                sumasTemp+= this.obtenerTemp(i,j);
            }
            double prom=(sumasTemp/getN());
            reporte += "-" +nomMeses[j-1]+": "+prom + " oC;\n";
        }
        return reporte;
    }
}
