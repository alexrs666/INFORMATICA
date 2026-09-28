package practicas_java;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
import cla.Autor;
import cla.Libro;
import cla.Estante;
/**
 *
 * @author AlexRs
*/
/*
        3-A- Defina una clase para representar estantes. Un estante almacena a lo sumo 20 libros.
             Implemente un constructor que permita iniciar el estante sin libros. Provea métodos para:
             (i) devolver la cantidad de libros que almacenados 
             (ii) devolver si el estante está lleno
             (iii) agregar un libro al estante 
             (iv) devolver el libro con un título particular que se recibe.
          B- Realice un programa que instancie un estante. Cargue varios libros. A partir del estante,
             busque e informe el autor del libro “Mujercitas”.
          C- Piense: ¿Qué modificaría en la clase definida para ahora permitir estantes que
             almacenen como máximo N libros? ¿Cómo instanciaría el estante?
*/
public class P3_EJE3_JAVA {
    public static void main(String[] args) {
        final int DF = 5;
        Estante[] biblioteca = new Estante[DF];
        for (int i = 0; i < DF; i++) {
            System.out.print("Ingrese la capacidad maxima para este estante:" + i + ": ");
            int capacidad = Lector.leerInt();
            
            biblioteca[i] = new Estante(capacidad);
        }
        
        System.out.println("Biblioteca creada con éxito");

        Autor unAutor = new Autor("Jorge Luis Borges", "Escritor argentino", "Argentina");
        Libro unLibro = new Libro("Ficciones", "Sur", 1944, unAutor, "978-9875666471", 25000);
        //
        Autor autor1 = new Autor("Louisa May Alcott", "Escritora estadounidense", "Estados Unidos");
        Libro libro1 = new Libro("Mujercitas", "Alianza", 1868, autor1, "978-8420674261", 15000);
        //
        biblioteca[2].agregarLibro(unLibro);
        biblioteca[3].agregarLibro(libro1);
        
        System.out.println("Cantidad de libros en el estante 2: " + biblioteca[2].cantLibros());
        System.out.println("Cantidad de libros en el estante 0: " + biblioteca[0].cantLibros());
        
        Libro libroBuscado = biblioteca[3].devolverLibro("Mujercitas");
        
        if (libroBuscado!= null) {
            System.out.println("encontre el libro");
            System.out.println("Datos del autor: " + libroBuscado.getPrimerAutor().toString());
        } else {
            System.out.println("El libro 'Mujercitas' no se encuentra en el estante.");
        }
    }
}