/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practicas_java.Practica_4;

/**
 *
 * @author AlexRs
 */
public abstract class Empleado {
    private String nombre;
    private double sueldo;
    private int antiguedad;

    public Empleado(String nombre, double sueldo, int antiguedad) {
        setNombre(nombre);
        setSueldo(sueldo);
        setAntiguedad(antiguedad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    public double calcularSueldo(){
        return (double) this.sueldo + (this.sueldo * (0.10 * this.antiguedad));
    }
    public String toString() {
        return "Empleado{" + "nombre=" + getNombre() + ", sueldo=" + getSueldo() + ", anios=" + getAntiguedad() +"efectividad="+this.calcularEfectividad()+"calcular sueldo"+this.calcularSueldoAcobrar();
    }
    public abstract double calcularEfectividad();
    public abstract double calcularSueldoAcobrar();
}
