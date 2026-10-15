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
public class Empresa {
    private String nombre;
    private String rubro;
    private int cantProductos;
    private double monto;

    public Empresa(String nombre, String rubro, int cantProductos, double monto) {
        this.nombre = nombre;
        this.rubro = rubro;
        this.cantProductos = cantProductos;
        this.monto = monto;
    }

    public String getRubro() {
        return rubro;
    }

    
    public String toString() {
        return "Empresa{" + "nombre=" + nombre + ", rubro=" + rubro + ", cantProductos=" + cantProductos + ", monto=" + monto + '}';
    }
    
}
