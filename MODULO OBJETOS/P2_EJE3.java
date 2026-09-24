package practicas_java;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author AlexRs
 */
/*
    3- Se realizará un casting para un programa de TV. El casting durará a lo sumo 5 días y en
       cada día se entrevistarán a 8 personas en distinto turno.
       a) Simular el proceso de inscripción de personas al casting. A cada persona se le pide
          nombre, DNI y edad y se la debe asignar en un día y turno de la siguiente manera: las
          personas primero completan el primer día en turnos sucesivos, luego el segundo día y así
          siguiendo. La inscripción finaliza al llegar una persona con nombre “ZZZ” o al cubrirse los
          40 cupos de casting.
          Una vez finalizada la inscripción:
       b) Informar para cada día y turno asignado, el nombre de la persona a entrevistar.
          NOTA: utilizar la clase Persona. Pensar en la estructura de datos a utilizar. Para comparar
          Strings use el método equals.
*/
public class P2_EJE3_JAVA {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
    
    
        final int DF=5,DP=8;
        int DL=0;
        
        cla.Persona casting[][] = new cla.Persona[DF][DP];
        
        //inciso A
        String nombre = GeneradorAleatorio.generarString(3).toUpperCase();
        int i=0,j;
        while(!nombre.equals("ZZZ") &&  i<DF){
            j=0;
            while(!nombre.equals("ZZZ") &&  j<DP){
                casting[i][j++] = new cla.Persona(nombre,
                                 GeneradorAleatorio.generarInt(9999999)+10000000,
                                 GeneradorAleatorio.generarInt(100)
                );
                nombre = GeneradorAleatorio.generarString(3).toUpperCase();
                DL++;
            }
            i++;
        }
        //inciso B
        int cant=0;
        i=0;
        while(i<DF && cant<DL){
            j=0;
            while(j<DP && cant<DL){
                System.out.print("dia:"+(i+1)+" turno:"+(j+1)+" entrevistan a:"+casting[i][j++].getNombre()+"||");
                cant++;
            }
            System.out.println();
            i++;
        }
    }
}
