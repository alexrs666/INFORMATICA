/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practicas_java.Practica_4;

/**
 *
 * @author AlexRs
 */
public class Trabajadores extends Persona {
    private String oficio;

    public Trabajadores(String nombre, int DNI, int edad,String oficio) {
        super(nombre, DNI, edad);
        setOficio(oficio);
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public String toString() {
        return super.toString() + " Soy " + getOficio();
    }
    
}
