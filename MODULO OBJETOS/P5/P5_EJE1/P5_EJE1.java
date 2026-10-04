package practicas_java.Practica_5.P5_EJE1_JAVA;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author AlexRs
 */
/*
                1- La UNLP desea administrar sus proyectos, investigadores y subsidios. Un proyecto
                   tiene: nombre, código, nombre completo del director y los investigadores que participan
                   en el proyecto (50 como máximo). De cada investigador se tiene: nombre completo,
                   categoría (1 a 5) y especialidad. Además, cualquier investigador puede pedir hasta un
                   máximo de 5 subsidios. De cada subsidio se conoce: el monto pedido, el motivo y si fue
                   otorgado o no.
                   a) Implemente el modelo de clases teniendo en cuenta:
                       Un proyecto sólo debería poder construirse con el nombre, código, nombre del
                         director.
                       Un investigador sólo debería poder construirse con nombre, categoría y
                         especialidad.
                       Un subsidio sólo debería poder construirse con el monto pedido y el motivo.
                         Un subsidio siempre se crea en estado no-otorgado.
                  b) Implemente los métodos necesarios (en las clases donde corresponda) que permitan:
                     i. void agregarInvestigador(Investigador unInvestigador);
                     // agregar un investigador al proyecto.
                     ii. void agregarSubsidio(Subsidio unSubsidio);
                     // agregar un subsidio al investigador.
                     iii. double dineroTotalOtorgado();
                     //devolver el monto total otorgado en subsidios del proyecto (tener en cuenta
                       todos los subsidios otorgados de todos los investigadores)
                     iv. void otorgarTodos(String nombre_completo);
                     //otorgar todos los subsidios no-otorgados del investigador llamado
                       nombre_completo
                     v. String toString();
                     // devolver un string con: nombre del proyecto, código, nombre del director, el
                        total de dinero otorgado del proyecto y la siguiente información de cada
                        investigador: nombre, categoría, especialidad, y el total de dinero de sus
                        subsidios otorgados.
                  c) Escriba un programa que instancie un proyecto con tres investigadores. Agregue dos
                     subsidios a cada investigador y otorgue los subsidios de uno de ellos. Luego imprima
                     todos los datos del proyecto en pantalla.
*/
public class P5_EJE1_JAVA {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
        final int DF=3,DS=2;
        
        Investigador vecInv [] = new Investigador[DF];
        Proyecto p1 = new Proyecto("la ia","juan perez",123123);
        
        String [] nombres = {"Alex Rosa","juan perez junior","Alex Perez"};
        String [] especialidades = {"Senior","BDD","Product Owner"};
        for(int i=0;i<3;i++){
            vecInv[i] = new Investigador(nombres[i],GeneradorAleatorio.generarInt(5)+1,especialidades[i]);
            
            p1.agregarInvestigador(vecInv[i]);
            for(int j=0;j<DS;j++){
                double montoGen = GeneradorAleatorio.generarDouble(99999)+1;
                String motivoGen = GeneradorAleatorio.generarString(4);
                vecInv[i].agregarSubsidio(new Subsidio(montoGen,motivoGen));
            }
        }
        System.out.println("--DATOS DEL PROYECTO--");
        p1.otorgarTodos("Alex Rosa");
        
        System.out.println(p1.toString());
    }

}
