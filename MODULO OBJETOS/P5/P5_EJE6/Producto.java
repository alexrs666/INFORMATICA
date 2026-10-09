/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJERCICIO6;

/**
 *
 * @author Usuario
 */
public class Producto {
    private String descripcion;
    private String rubro;
    private int peso;
    private double precio;
    
    public Producto(String descripcion, String rubro, int peso, double precio) {
        this.descripcion = descripcion;
        this.rubro = rubro;
        this.peso = peso;
        this.precio = precio;
    }

    public String getRubro() {
        return rubro;
    }

    
    public double precioFinal(){
        return this.peso * this.precio;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public String toString() {
        return "Producto{" + "descripcion=" + descripcion + " precio final del producto:"+precioFinal();
    }
    
}
