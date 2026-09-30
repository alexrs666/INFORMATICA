package practicas_java;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
import cla.Persona;
import cla.Hotel;
/**
 *
 * @author AlexRs
 */
/*
        4-A- Un hotel posee N habitaciones. De cada habitación conoce costo por noche, si está
             ocupada y, en caso de estarlo, guarda el cliente que la reservó (nombre, DNI y edad).
             (i) Genere las clases necesarias. Para cada una provea métodos getters/setters adecuados.
             (ii) Implemente los constructores necesarios para iniciar: los clientes a partir de nombre,
                  DNI, edad; el hotel para N habitaciones, cada una desocupada y con costo aleatorio e/
                  2000 y 8000.
             (iii) Implemente en las clases que corresponda todos los métodos necesarios para:
                   - Ingresar un cliente C en la habitación número X. Asuma que X es válido (es decir, está
                     en el rango 1..N) y que la habitación está libre.
                   - Aumentar el precio de todas las habitaciones en un monto recibido.
                   - Obtener la representación String del hotel, siguiendo el formato:
             {Habitación 1: costo, libre u ocupada, información del cliente si está ocupada}
              ...
             {Habitación N: costo, libre u ocupada, información del cliente si está ocupada}
          B- Realice un programa que instancie un hotel, ingrese clientes en distintas habitaciones,
             muestre el hotel, aumente el precio de las habitaciones y vuelva a mostrar el hotel.
          NOTAS: Reúse la clase Persona. Para cada método solicitado piense a qué clase debe
                 delegar la responsabilidad de la operación.
*/

public class P3_EJE4_JAVA {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        final int N = 2;
        Hotel h1 = new Hotel(N);
        
        Persona cliente;
        
        for(int i = 1; i <= N; i++) {
               cliente = new Persona(Lector.leerString(), Lector.leerInt(), Lector.leerInt());
               h1.agregarCliente(cliente, i); 
        }
        System.out.println(h1.toString());
        
        h1.aumentarCosto(GeneradorAleatorio.generarDouble(2000));
        
        System.out.println(h1.toString());
    }
}
