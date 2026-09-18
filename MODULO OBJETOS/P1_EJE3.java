package practicas_java;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/*
 *
 * @author AlexRs
 */
/*
    3- Un teatro realizó durante los 7 días de la semana 4 funciones diarias.
       Escriba un programa que cargue en una estructura la cantidad de espectadores que
       concurrieron a cada día/función.
        Una vez cargada, realice recorridos independientes para:
            - Dado un día (int) leído de teclado, informar la cantidad de espectadores que
              concurrieron a cada función en ese día.
            - Dada una función (int) leída de teclado, informar la cantidad de espectadores que
              concurrieron en cada día a esa función.
            - Informar en qué día y función hubo más espectadores.
*/
public class P1_EJE3_JAVA {

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
        int i,j;
        final int DF=7;
        final int DL=4;
        int max=-1;
        int sumaDias=0,sumaFuncion=0;
        int MaxDia=0,MaxFuncion=0;
        int [][] teatro = new int [DF][DL];
        
        for (i=0;i<DF;i++){
            for(j=0;j<DL;j++){
                int espectadores = GeneradorAleatorio.generarInt(121);
                teatro[i][j] = espectadores;
            }
        }
        System.out.print("ingrese un dia entre(0 y 6)");
        int dia = Lector.leerInt();
        for(j=0;j<DL;j++){
            System.out.println("funcion"+j+ "hubo:"+teatro[dia][j]+" espectadores");
        }
        System.out.print("ingrese una funcion entre(0 y 3)");
        int funcion = Lector.leerInt();
        for(i=0;i<DF;i++){
            System.out.println("dia"+i+ "hubo:"+teatro[i][funcion]+" espectadores");
        }
        
        for (i=0;i<DF;i++){
            for(j=0;j<DL;j++){
                if(teatro[i][j]>max){
                    max=teatro[i][j];
                    MaxDia=i;
                    MaxFuncion=j;
                }
            }
        }
        System.out.println("este es el dia con mas espectadores:"+ MaxDia+" este es la funcion con mas espectadores:"+ MaxFuncion);
    }
}