package practicas_java;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author AlexRs
 */
/*
    2- Utilizando la clase Persona. Realice un programa que almacene en un vector a lo sumo
       15 personas. La información (nombre, DNI, edad) se debe generar aleatoriamente hasta
       obtener edad 0. Luego de almacenar la información:
            - Informe la cantidad de personas mayores de 65 años.
            - Muestre la representación de la persona con menor DNI.
*/
public class P2_EJE2_JAVA {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        //variables
        int i,DL=0;
        int unaEdad;
        final int DF=15;
        int cantPerSup=0;
        //
        cla.Persona vecPer [] = new cla.Persona[DF];
        
        unaEdad = GeneradorAleatorio.generarInt(100);
        while(unaEdad !=0 && DL<DF){
            //genero datos aleaotrios;
            vecPer[DL] = new cla.Persona(); 
            vecPer[DL].setNombre(GeneradorAleatorio.generarString(4));
            vecPer[DL].setDNI(GeneradorAleatorio.generarInt(99999999)+10000000);
            vecPer[DL].setEdad(unaEdad);
            //
            unaEdad = GeneradorAleatorio.generarInt(100);
            //incremento
            DL++;
        }
        //inciso A
        for (i=0;i<DL;i++){
            if(vecPer[i].getEdad()>65){
                cantPerSup++;
            }
        }
        System.out.println("esta es la cantidad de personas q supera los 65 años:"+cantPerSup);
        //inciso B
        int minDni=999999999;
        int PosDniMin=0;
        for (i=0;i<DL;i++){
            if(vecPer[i].getDNI()<minDni){
                minDni=vecPer[i].getDNI();
                PosDniMin=i;
            }
        }
        cla.Persona MinDniPer = vecPer[PosDniMin];
        System.out.println("la persona con el dni mas chico:"+MinDniPer.toString());   
    }
}