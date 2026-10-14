package PARCIAL4;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author AlexRs
 */

public class PARCIAL4 {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        Contenedor c1=new Contenedor(123,"don satur",70,15);
        Contenedor c2=new Contenedor(124,"don",5,3);
        Contenedor c3=new Contenedor(125,"satur",3,5);
        Contenedor c4=new Contenedor(125,"satur",3,5);
        
        
        Terminal t1=new Terminal("don quijote","av.siempreViva",2,4);
        
        t1.registrarContenedor(c1, 1, 2);
        t1.registrarContenedor(c2, 1, 3);
        t1.registrarContenedor(c3, 1, 1);
        t1.registrarContenedor(c4, 2, 1);
        
        
        t1.retirarContenedor(1, 5);
        
        System.out.println("bloque mas libre:"+t1.nroBloqueMasLibre());
        System.out.println(t1.toString());
    }
}
