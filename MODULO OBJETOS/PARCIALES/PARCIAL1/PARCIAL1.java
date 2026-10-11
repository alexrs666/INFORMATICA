package PARCIAL1;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author AlexRs
 */
/*
    Una plataferma de cursos online necesita representar sus cursos y sus alumnos inscriptos. De un curso se conoce:
nombre, costo de inscripción, fetha de comienzo, y la información de sus alumnos (a lo sumo M). De un alumno se
guarda: nombre, cantidad de tareas completadas y suma total de notas de tareas completadas. Además, hay dos tipos
de cursos: Básice y Avanzado, que difieren en la manera de obtener el alumno con mejor desempeño, esto se detalla
más adelante. Ademis, del curso Avanzado se registra la descripción (String) de conocimientos previos que el alumno
debe poseer.

1- Genere las clases. Provea constructores para crear objetos del modelo a partir de los datos necesarios; en particular,
los cursos deben permitir un máximo M de alumnos (inician sin alumnos cargados); tos alumnos inician con su cantidad
de tareas y suma total de notas a 0.
2- Implemente los métodos necesarios, en las clases que corresponda, para:
a) Inscribir un alumno al curso, agregándolo al mismo, y retornar el número que indica su orden de inscripción. Asuma
que hay lugar. Ejemplo: el primer inscripto tendrá número de orden 1, el siguiente 2, y asi siguiendo.
b] Dado un valor A, obtener al A-ésimo alumno inscrito en el curso. Asuma que A está en un rango válido de
posiciones.
c) Dado el nombre de un alumno y una nota X, actualice el rendimiento del alumno con dicho nombre.
Actualizar el rendimiento del alumno implica: aumentar en 1 la cantidad de tereas completadas y sumar al total la
nota X.
d) Retornar un String que represente el curso, concatenando: el nombre , costo de inscripción, la fecha de comienzo y
todos los datos del alumno con mejor desempeño del curse, según corresponda:

- En el curso Básico, el alumno con mejor desempeño es aquel que tiene mayor cantidad de tareas completadas.
En el curso Avanzado, el alumno con mejor desempefio es aquel que tiene mayor promedio. El promedio del
alumno se calcula como suma_total_notas_tareas_completadas / cant_tareas_completadas.

3- Realice un programa que instancie un curso Básico y un curso Avanzado. Inscriba algunos alumnos a cada uno.
Actualice el rendimiento de algunos alumnos de cada curso. Compruebe el correcto funcionamiento del método 2.d.
*/
public class PARCIAL1 {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
    }
}
