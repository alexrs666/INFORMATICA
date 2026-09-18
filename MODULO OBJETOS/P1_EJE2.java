/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas_java;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author Usuario
 */
/*
2- Escriba un programa que defina una matriz de enteros de tamaño 5x5. Inicialice la
   matriz con números aleatorios entre 0 y 30.
   Luego realice las siguientes operaciones en recorridos independientes:
        - Mostrar el contenido de la matriz en consola.
        - Calcular e informar la suma de los elementos de la fila 1
        - Generar un vector de 5 posiciones donde cada posición j contiene la suma de los
            elementos de la columna j de la matriz. Luego, imprima el vector.
        - Leer un valor entero e indicar si se encuentra o no en la matriz. En caso de
   encontrarse indique su ubicación (fila y columna) en caso contrario imprima “No 
   se encontró el elemento”.
   NOTA: Dispone de un esqueleto para este programa en Ej02Matrices.java
*/
public class P1_EJE2_JAVA {
    public static void main(String[] args){
        GeneradorAleatorio.iniciar();
        //
        int i;
        int j;
        int SumaFila=0;
        final int DF=5;
        int[][] vector = new int [DF][DF];
        int vectorGene [] = new int[DF];
        //generar matriz
        for(i=0;i<DF;i++){
            for(j=0;j<DF;j++){
                vector[i][j] = GeneradorAleatorio.generarInt(31);
            }
        }
        // mostrar contenido
        for(i=0;i<DF;i++){
            for(j=0;j<DF;j++){
                System.out.print("pos:"+i+" y "+j+" valor:"+vector[i][j]+"|");
            }
            System.out.println();
        }
        
        //calcular la suma de la primer fila
        for(j=0;j<DF;j++){
            SumaFila += vector[1][j];
        }
        System.out.println("la suma de la primer fila es:"+SumaFila);
        //suma pos j
        for(j=0;j<DF;j++){
            for(i=0;i<DF;i++){
                vectorGene[j]+= vector[i][j];
            }
        }
        for (j=0;j<DF;j++){
            System.out.println("en esta posicion:"+j+" hay :"+vectorGene[j]+" de suma");
        }
        //encontrar valor leido
        System.out.print("ingrese un valor para buscar:");
        int valor= Lector.leerInt();
        boolean encontre=false;
        i=0;
        while(!encontre && i<DF){
            j=0;
            while(!encontre && j<DF){
                if(vector[i][j]== valor){
                    System.out.println("en esta posicion se encuentra:"+i+" "+j);
                    encontre=true;
                }
                j++;
            }
            i++;
        }
        if(!encontre)
           System.out.println("No se encontró el elemento");
    }
}
