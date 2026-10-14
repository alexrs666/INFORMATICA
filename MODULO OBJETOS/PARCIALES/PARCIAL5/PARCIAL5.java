package PARCIAL5;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author AlexRs
 */
public class PARCIAL5 {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        String nombreEvento="HACKATON";
        Laboratorio lab1= new Laboratorio("Laboratorio Turing",3);
        Laboratorio lab2= new Laboratorio("Laboratorio Lovelase",4);
        Evento e1=new Evento("Inteligencia Artificial","15/11/2026",500000,lab1,lab2);
        
        Programador p1=new Programador(213,"Alex Rosa","Pascalito");
        Programador p2=new Programador(123,"Alex Perez","Pascalito");
        Programador p3=new Programador(321,"Alex Sosa","Pyton");
        
        e1.agregarLab(p1);
        e1.agregarLab(p2);
        e1.agregarLab(p3);
        
        e1.asignarAños(213, 10);
        System.out.println("cantidad de lenguajes elejidos principales:"+e1.canTotalLenguaje("Pascalito"));
        System.out.println(nombreEvento+e1.toString());
        
    }
}
