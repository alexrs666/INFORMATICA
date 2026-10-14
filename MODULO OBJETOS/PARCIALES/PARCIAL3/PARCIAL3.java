package PARCIAL3;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author AlexRs
 */
public class PARCIAL3 {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        Inscripcion insc1=new Inscripcion("alex",123213,100,13);
        Inscripcion insc2=new Inscripcion("alex",123213,101,13);
        Inscripcion insc3=new Inscripcion("alex",123213,100,13);
        Inscripcion insc4=new Inscripcion("alex",123213,100,13);
        
        Sede s1= new Sede("Bs As",3);
        Sede s2= new Sede("Bs As",3);
        Plataforma p1=new Plataforma("pepito");
        
        s1.agregarInscripcion(insc1);
        s1.agregarInscripcion(insc2);
        s2.agregarInscripcion(insc3);
        s2.agregarInscripcion(insc4);
        
        p1.agregarSede(s1);
        p1.agregarSede(s2);
        
        p1.agregarInscripcion(1, insc4);
        
        System.out.println("Sede Mayor recaudacion:"+p1.sedeMayorRecaudacion());
    
        System.out.println(p1.toString());
    }
}
