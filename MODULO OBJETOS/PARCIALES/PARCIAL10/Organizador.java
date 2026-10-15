/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialito;

/**
 *
 * @author Estudiante
 */
public class Organizador {
    private String nombre;
    private String apeliido;
    private int telefono;

    public Organizador(String nombre, String apeliido, int telefono) {
        this.nombre = nombre;
        this.apeliido = apeliido;
        this.telefono = telefono;
    }

    public String toString() {
        return "Organizador{" + "nombre=" + nombre + ", apeliido=" + apeliido + ", telefono=" + telefono + '}';
    }
    
    
}
