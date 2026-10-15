/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PARCIAL8;

/**
 *
 * @author Usuario
 */
public class Medicamento {
    private String nombre;
    private double costoAbonado;

    public Medicamento(String nombre, double costoAbonado) {
        this.nombre = nombre;
        this.costoAbonado = costoAbonado;
    }

    public double getCostoAbonado() {
        return costoAbonado;
    }
    
}
