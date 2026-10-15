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
public class Profesor extends Persona {
    private int nivelITN;

    public Profesor(int DNI, String nombreCompleto, int telefono, String trayectoria,int nivelITN) {
        super(DNI, nombreCompleto, telefono, trayectoria);
        this.nivelITN = nivelITN;
    }

    public int getNivelITN() {
        return nivelITN;
    }

    public String toString() {
        return "Profesor{" + ":"+super.toString()+"nivelITN=" + nivelITN;
    }
    
}
