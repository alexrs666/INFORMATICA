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
public class Director extends Persona{
    private String fechaAcceso;

    public Director(int DNI, String nombreCompleto, int telefono, String trayectoria,String fechaAcceso) {
        super(DNI, nombreCompleto, telefono, trayectoria);
        this.fechaAcceso = fechaAcceso;
    }
    
    public String toString() {
        return "Director{" + ":"+super.toString()+ "fechaAcceso=" + fechaAcceso;
    }    
}
