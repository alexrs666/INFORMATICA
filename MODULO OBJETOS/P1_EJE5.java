package practicas_java;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author AlexRs
 */
/*
    5- El dueño de un restaurante entrevista a cinco clientes y les pide que califiquen (con
       puntaje de 1 a 10) los siguientes aspectos: (0) Atención al cliente (1) Calidad de la comida
       (2) Precio (3) Ambiente.
       Escriba un programa que lea desde teclado las calificaciones de los cinco clientes para
       cada uno de los aspectos y almacene la información en una estructura. Luego imprima la
       calificación promedio obtenida por cada aspecto.
*/
public class P1_EJE5_JAVA {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
        int i,j;
        final int DF=5;
        final int DC=4;
        double sumarCalificacion=0;
        int restaurante[][] = new int [DF][DC];
        
        for(i=0;i<DF;i++){
            for(j=0;j<DC;j++){
                //PROBA LEERLO
                int calificacion = 1 + GeneradorAleatorio.generarInt(10);
                restaurante[i][j]=calificacion;
            }
        }
        for(j=0;j<DC;j++){
            double prom=0;
            for(i=0;i<DF;i++){
                sumarCalificacion +=restaurante[i][j];
            }
            prom=(sumarCalificacion/DF);
            System.out.println("este aspecto:"+j+" tiene en promedio:"+prom);
            sumarCalificacion=0;
        }
    }
}