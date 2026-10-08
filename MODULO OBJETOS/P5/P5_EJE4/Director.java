/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practicas_java.Practica_5.P5_EJE4_JAVA;

/**
 *
 * @author AlexRs
 */
public class Director extends Persona{
    private int antiguedad;

    public Director(int antiguedad, String nombre, int DNI, int edad) {
        super(nombre, DNI, edad);
        this.antiguedad = antiguedad;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public String toString() {
        return "Director{" +super.toString()+ "antiguedad=" + getAntiguedad() + '}';
    }
    
}
