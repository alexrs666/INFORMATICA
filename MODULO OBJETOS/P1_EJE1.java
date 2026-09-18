/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas_java;

/**
 *
 * @author Usuario
 */
/*
    1- Escriba un programa que lea las alturas de los 15 jugadores de un equipo de básquet
       las almacene en un vector. Luego informe:
         - la altura promedio
         - la cantidad de jugadores con altura por encima del promedio
       NOTA: Dispone de un esqueleto para este programa en Ej01Jugadores.java
 */
import PaqueteLectura.GeneradorAleatorio;
public class P1_EJE1_JAVA {
    public static void main(String[]args){
        GeneradorAleatorio.iniciar();
        //ope
        int cantSupera = 0;
        double sumaTotal = 0;
        double prom = 0;
        int i;
        final int DF=15;
        double [] vectorJugadores = new double[DF];
        //
        for (i=0;i<DF;i++){
            double altura = 1.50 + GeneradorAleatorio.generarDouble(1);
            vectorJugadores[i]=altura;
            sumaTotal += vectorJugadores[i];
            System.out.println("jugador:"+i+" su altura es de :"+vectorJugadores[i]);
        }
        prom =(sumaTotal/DF);
        for (i=14;i>=0;i--){
            if(vectorJugadores[i]>prom)
                cantSupera = cantSupera ++;
        }
        System.out.println("esta es la cantidad de jugadores que supera el promedio:"+cantSupera);
    }
}
