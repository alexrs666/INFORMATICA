package practicas_java;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author AlexRs
 */
/*
        4- Sobre un nuevo programa, modifique el ejercicio anterior para considerar que:
           a) Durante el proceso de inscripción se pida a cada persona sus datos (nombre, DNI, edad)
              y el día en que se quiere presentar al casting. La persona debe ser inscripta en ese día, en el
              siguiente turno disponible. En caso de no existir un turno en ese día, informe la situación.
           La inscripción finaliza al llegar una persona con nombre “ZZZ” o al cubrirse los 40 cupos
           de casting.
           Una vez finalizada la inscripción:
           b) Informar para cada día: la cantidad de inscriptos al casting ese día y el nombre de la
              persona a entrevistar en cada turno asignado.
*/
public class P2_EJE4_JAVA {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
    
        //
        final int DC=5,DF=8;
        int DL=0;
        int dni,edad;
        cla.Persona casting[][] = new cla.Persona[DC][DF];
        
        //inciso A
        System.out.print("se ingresa un nombre:");
        String nom = Lector.leerString().toUpperCase();
        int j;
        while(!nom.equals("ZZZ") &&  DL<(DC*DF)){
            j=0;
            System.out.print("ingrese el dia que quiere turno:");
            int dia = Lector.leerInt();
            
            System.out.print("ingrese un DNI:");
            dni = Lector.leerInt();
            
            System.out.print("ingrese una edad:");
            edad = Lector.leerInt();
            
            while(j<DF && casting[dia][j]!=null){
                j++;
            }
            if(j>=DF){
                System.out.println("los turno de este dia:"+(dia+1)+" estan llenos");
            }else{
                casting[dia][j] = new cla.Persona(nom,dni,edad);
                DL++;
            }
            System.out.print("se ingresa un nombre:");
            nom = Lector.leerString().toUpperCase();
        }
        //inciso B
        int cant;
        for (int i=0;i<DC;i++){
            j=0;
            cant=0;
            while(j<DF && casting[i][j] != null){
               System.out.println("este dia"+i+" se entrevisto a:"+casting[i][j].getNombre());
               cant++;
               j++;
            }
            System.out.println("este dia:"+i+" hubo:"+cant+" entrevistados");
            System.out.println();
        }
    }
}
