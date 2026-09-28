package practicas_java;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author AlexRs
 */
public class P3_EJE1_JAVA {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        Triangulo obj=new  Triangulo(GeneradorAleatorio.generarDouble(100), GeneradorAleatorio.generarDouble(100), GeneradorAleatorio.generarDouble(100),
                            GeneradorAleatorio.generarString(3), GeneradorAleatorio.generarString(3));
        
        //imprimir 
        System.out.println("este es el perimetro del triangulo:"+obj.calcularPerimetro()+" este es el area del triangulo:"+obj.calcularArea());        
    }
}