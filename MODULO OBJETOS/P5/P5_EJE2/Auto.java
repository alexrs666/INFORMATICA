/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practicas_java.Practica_5.P5_EJE2_JAVA;

/**
 *
 * @author AlexRs
 */
public class Auto {
    private String nombre;
    private String patente;

    public Auto(String nombre, String patente) {
        setNombre(nombre);
        setPatente(patente);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String toString() {
        return "Auto{" + "nombre=" + getNombre() + ", patente=" + getPatente() + '}';
    }
    
}
