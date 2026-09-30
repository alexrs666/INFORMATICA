package practicas_java.Practica_4;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author AlexRs
 */
/*
                3-A- Implemente las clases para el siguiente problema. Una garita de seguridad quiere
                     identificar los distintos tipos de personas que entran a un barrio cerrado. Al barrio pueden
                     entrar: personas, que se caracterizan por nombre, DNI y edad; y trabajadores, estos son
                     personas que se caracterizan además por la tarea realizada en el predio.
                     Implemente constructores, getters y setters para las clases. Además tanto las personas
                     como los trabajadores deben responder al mensaje toString siguiendo el formato:
                     --Personas “Mi nombre es Mauro, mi DNI es 11203737 y tengo 70 años”
                     --Trabajadores “Mi nombre es Mauro, mi DNI es 11203737 y tengo 70 años. Soy
                       jardinero.”
                  B- Realice un programa que instancie una persona y un trabajador y muestre la
                     representación de cada uno en consola.
                NOTA: Reutilice la clase Persona (carpeta tema2).
*/
public class P4_EJE3_JAVA {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        Persona p1= new Persona("mauro",11203737,70);
        Trabajadores t1 = new Trabajadores("mauro",11203737,70,"jardinero");
        
        System.out.println(p1.toString());
        System.out.println(t1.toString());
    }
}
