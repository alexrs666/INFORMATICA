/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PARCIAL9;

/**
 *
 * @author Usuario
 */
public class Cliente {
    private int DNI;
    private String nombre;
    private int telefono;
    private String localidad;
    private boolean seguro;

    public Cliente(int DNI, String nombre, int telefono, String localidad, boolean seguro) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.telefono = telefono;
        this.localidad = localidad;
        this.seguro = seguro;
    }

    public boolean isSeguro() {
        return seguro;
    }

    public String getLocalidad() {
        return localidad;
    }
    
    public String toString() {
        String estadoSeguro;
        if (this.seguro)
            estadoSeguro = "asegurado";
        else 
            estadoSeguro = "sin seguro";
        return " Cliente{" + "DNI=" + DNI + ", nombre=" + nombre + ", telefono=" + telefono + ", localidad=" + localidad + ", seguro=" + estadoSeguro + '}';
    }
    
}
