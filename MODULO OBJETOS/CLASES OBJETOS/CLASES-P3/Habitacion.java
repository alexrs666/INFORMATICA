/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas_java;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author AlexRs
 */
public class Habitacion {
    private double costo;
    private boolean ocupacion;
    private Persona cliente;

    public Habitacion() {
        GeneradorAleatorio.iniciar();
        ocupacion=false;
        this.costo= 2000 + (GeneradorAleatorio.generarDouble(8000-2000));
        cliente= null;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(boolean ocupacion) {
        this.ocupacion = ocupacion;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }
    public String toString() {
        return "Habitaciones{" + "costo=" + costo + ", ocupacion=" + ocupacion + ", cliente=" + cliente + '}';
    } 
}
