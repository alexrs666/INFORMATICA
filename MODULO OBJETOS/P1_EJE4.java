package practicas_java;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author AlexRs
 */
/*
    4- Un edificio de oficinas está conformado por 8 pisos (1..8) y 4 oficinas por piso (1..4).
       Realice un programa que permita informar la cantidad de personas que concurrieron a
       cada oficina de cada piso. Para esto, simule la llegada de personas al edificio de la siguiente
       manera: a cada persona se le pide el nro. de piso y nro. de oficina a la cual quiere concurrir.
       La llegada de personas finaliza al indicar un nro. de piso 9. Al finalizar la llegada de
       personas, informe lo pedido. 
*/
public class P1_EJE4_JAVA {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
        final int DF=8;
        final int DC=4;
        int edificio[][] = new int[DF][DC];
        int i,j;
        for (i=0;i<DF;i++){
            for(j=0;j<DC;edificio[i][j++]=0);
        }
        System.out.println("ingrese numero de piso y oficina:");
        i = GeneradorAleatorio.generarInt(DF+1);
        j = GeneradorAleatorio.generarInt(DC);
        while(i != 8){
            
            edificio[i][j]++;
            i = GeneradorAleatorio.generarInt(DF+1);
            j = GeneradorAleatorio.generarInt(DC);
            
        }
        for (i = 0; i < DF; i++){
            System.out.println("Piso " + (i+1));
            for (j = 0;  j < DC;System.out.print("F:" + (i+1) + " C:" + (j+1) + " cant: " + edificio[i][j++] + "  |  "));
            System.out.println();
        }
    }
}
