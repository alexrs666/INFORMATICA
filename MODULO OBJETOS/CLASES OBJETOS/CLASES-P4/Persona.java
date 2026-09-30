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
public class Persona {
    private String nombre;
    private int DNI;
    private int edad; 
   
    public Persona(String nombre, int DNI, int edad){
        setNombre(nombre);
        setDNI(DNI);
        setEdad(edad); 
    }
    
    public Persona(){
     
    }

    public int getDNI() {
        return DNI;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String toString(){
        return "Mi nombre es " + getNombre() + ", mi DNI es " + getDNI() + " y tengo " + getEdad() + " años.";
    }   
}
