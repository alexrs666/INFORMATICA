package PARCIAL6;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author AlexRs
 */
public class PARCIAL6 {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        Concurso con1= new Concurso(3,5);
        Cancion c1= new Cancion("ya me canse","alex",1234);
        Cancion c2= new Cancion("ya me canse","alex",134);
        Cancion c3= new Cancion("ya me canse","alex",154);
        Cancion c4= new Cancion("ya me canse","alex",12432);
        Cancion c5= new Cancion("ya me canse","alex",12213);
        
        
        con1.agregarNuevaCancion(1, c1);
        con1.agregarNuevaCancion(1, c1);
        con1.agregarNuevaCancion(2, c1);
        con1.agregarNuevaCancion(2, c1);
        con1.agregarNuevaCancion(3, c1);
        
        int codIde = Lector.leerInt();
        while(codIde !=0){
            Estudiante e = new Estudiante(Lector.leerString(),Lector.leerString(),Lector.leerInt());
            
            con1.BuscarActualizarCancion(codIde, e,95);
            
            codIde = Lector.leerInt();
        }
        
        int codIdeCancion = Lector.leerInt();
        Estudiante e1=con1.BuscarCancionConInterprete(codIdeCancion);
        if (e1 != null)
            System.out.println("El ganador es: " + e1.toString());
        else 
            System.out.println("Nadie");
   
            
        System.out.println("\n--- MEJORES CANCIONES POR CATEGORIA ---");
        for (int i = 1; i <= 3; i++) {
            Cancion mejor = con1.cancionConMayorPuntaje(i);
            if (mejor != null)
                System.out.println("Categoria " + i + ": " + mejor.getNombre() + " de " + mejor.getCompositor());
            else 
                System.out.println("Categoria " + i + ": Sin interpretaciones");
        }
    }
}
