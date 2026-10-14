/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PARCIAL3;

/**
 *
 * @author Usuario
 */
public class Inscripcion {
    private String nombre;
    private int  codigo;
    private double monto;
    private int codigoCurso;

    public Inscripcion(String nombre, int codigo, double monto, int codigoCurso) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.monto = monto;
        this.codigoCurso = codigoCurso;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public double getMonto() {
        return monto;
    }
    
    public String toString() {
        return "Inscripcion{" + "nombre=" + nombre + ", codigo=" + codigo + ", monto=" + monto + ", codigoCurso=" + codigoCurso + '}';
    }
    
}
