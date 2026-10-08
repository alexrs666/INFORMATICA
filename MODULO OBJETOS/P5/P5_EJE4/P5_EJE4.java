package practicas_java.Practica_5.P5_EJE4_JAVA;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author AlexRs
 */
/*
4- Una escuela de música arma coros para participar de ciertos eventos. Los coros poseen
un nombre y están formados por un director y una serie de coristas. Del director se
conoce el nombre, DNI, edad y la antigüedad (un número entero). De los coristas se conoce
el nombre, DNI, edad y el tono fundamental (un número entero). Asimismo, hay dos tipos
de coros: coro semicircular en el que los coristas se colocan en el escenario uno al lado
del otro y coro por hileras donde los coristas se organizan en filas de igual dimensión.
a. Implemente las clases necesarias teniendo en cuenta que los coros deberían crearse
con un director y sin ningún corista, pero sí sabiendo las dimensiones del coro.
b. Implemente métodos (en las clases donde corresponda) que permitan:
 agregar un corista al coro.
o En el coro semicircular los coristas se deben ir agregando de izquierda
a derecha
o En el coro por hileras los coristas se deben ir agregando de izquierda a
derecha, completando la hilera antes de pasar a la siguiente.
 determinar si un coro está lleno o no. Devuelve true si el coro tiene a todos sus
coristas asignados o false en caso contrario.
 determinar si un coro (se supone que está lleno) está bien formado. Un coro
está bien formado si:
o En el caso del coro semicircular, de izquierda a derecha los coristas
están ordenados de mayor a menor en cuanto a tono fundamental.
o En el caso del coro por hileras, todos los miembros de una misma hilera
tienen el mismo tono fundamental.
 devolver la representación de un coro formada por el nombre del coro, todos
los datos del director y todos los datos de todos los coristas.
c. Escriba un programa que instancie un coro de cada tipo. Lea o bien la cantidad de
coristas (en el caso del coro semicircular) o la cantidad de hileras e integrantes por
hilera (en el caso del coro por hileras). Luego cree la cantidad de coristas necesarios,
leyendo sus datos, y almacenándolos en el coro. Finalmente imprima toda la
información de los coros indicando si están bien formados o no.
*/
public class P5_EJ4_JAVA {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        Director d1 = new Director(5, "Armando",12234 ,22 );
        
        Corista c1 = new  Corista(40, "Corista 1",1201 ,11 );
        Corista c2 = new  Corista(30, "Corista 2",1201 ,20 );
        Corista c3 = new  Corista(20, "Corista 3", 1201,30 );
        
        CoroSemiCircular coro1 = new CoroSemiCircular("Number 1", d1, 3);
        CoroPorHileras coro2 = new CoroPorHileras("Number 2", d1, 1, 3);
        
        coro1.agregarCorista(c1);
        coro1.agregarCorista(c2);
        coro1.agregarCorista(c3);
        
        coro2.agregarCorista(c1);
        coro2.agregarCorista(c2);
        coro2.agregarCorista(c3);
        
        
        System.out.println(coro1.toString());
        
        System.out.println(coro2.toString());
    }

}
