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
public class Corista extends Persona{
   private int tono;

    public Corista(int tono, String nombre, int DNI, int edad) {
        super(nombre, DNI, edad);
        this.tono = tono;
    }

    public int getTono() {
        return tono;
    } 
    public String toString() {
        return "Corista{"+super.toString() + " tono=" + getTono()+"}" ;
    }
    
    
}
