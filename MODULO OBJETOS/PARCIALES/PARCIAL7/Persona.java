/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PARCIAL7;

/**
 *
 * @author Usuario
 */
public abstract class Persona {
    private int DNI;
    private String nombreCompleto;
    private int telefono;
    private String trayectoria;

    public Persona(int DNI, String nombreCompleto, int telefono, String trayectoria) {
        this.DNI = DNI;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.trayectoria = trayectoria;
    }

    public String toString() {
        return "Persona{" + "DNI=" + DNI + ", nombreCompleto=" + nombreCompleto + ", telefono=" + telefono + ", trayectoria=" + trayectoria + '}';
    }
    
}
