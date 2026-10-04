package practicas_java.Practica_5.P5_EJE3_JAVA;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author AlexRs
 */
/*
3- Un productor desea administrar los recitales que organiza: eventos ocasionales y giras.
 De todo recital se conoce el nombre de la banda y los temas que tocarán en el recital.
 Un evento ocasional es un recital que además tiene el motivo (a beneficio, show de TV
o show privado), el nombre del contratante del recital y el día del evento.
 Una gira es un recital que además tiene un nombre y las “fechas” donde se repetirá la
actuación. De cada “fecha” se conoce la ciudad y el día. Además la gira guarda el
número de la fecha en la que se tocará próximamente (actual).
a) Genere las clases necesarias. Implemente métodos getters/setters adecuados.
b) Implemente los constructores. El constructor de recitales recibe el nombre de la banda
y la cantidad máxima de temas que tendrá el recital. El constructor de eventos ocasionales
además recibe el motivo, el nombre del contratante y día del evento. El constructor de
giras además recibe el nombre de la gira y la cantidad máxima de fechas que tendrá.
c) Implemente los métodos necesarios en las clases que corresponda para:
 Dado un tema (String), agregarlo a los temas del recital.
 Dada una fecha, agregarla a las fechas de la gira.
 Calcular el costo del recital, teniendo en cuenta lo siguiente. Si es un evento
ocasional devuelve 0 si es a beneficio, 50000 si es un show de TV y 150000 si es
privado. Las giras deben devolver 30000 por cada fecha de la misma.
 Publicitar la actuación, teniendo en cuenta lo siguiente.
Todos los recitales deben imprimir “Somos …” seguido del nombre de la banda y a
continuación “ tocaremos…” seguido por el nombre de todos los temas.
Además:
Las giras imprimen “los esperamos en …” seguido del nombre de la ciudad de la
fecha “actual”, y establece la siguiente fecha de la gira como la nueva “actual”.
Los eventos ocasionales imprimen una leyenda:
- Si es un show de beneficencia imprime “Recuerden colaborar con…“
seguido del nombre del contratante.
- Si es un show de TV imprime “Saludos amigos televidentes”
- Si es un show privado imprime “Un feliz cumpleaños para…” seguido
del nombre del contratante.
d) Realice un programa que instancie un evento ocasional y una gira, cargando la
información necesaria. Luego, para ambos, imprima el costo y pruebe el mensaje para
publicitar la actuación.
*/
public class P5_EJE3_JAVA {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        Fecha f1= new Fecha("Bs.As","08/13");
        String motivo []= {"a beneficio","show de TV","show privado"};
        EventoOcasional e1 = new EventoOcasional(motivo[GeneradorAleatorio.generarInt(3)],"juan Perez",f1,"soda Stereo",1);
        Gira g1= new Gira("los montoneros",2,"Alex Perez",1);
        
        g1.agregarTema("rock");
        g1.agregarTema("cumbia");
        g1.agregarFechas(f1);
        e1.agregarTema("pop");
        System.out.println("este es el costo de la de la gira:"+g1.calcularCosto());
        
        System.out.println("este es el costo para el evento ocasional:"+e1.calcularCosto());
        
        g1.actuacion();
        e1.actuacion();
    }

}
