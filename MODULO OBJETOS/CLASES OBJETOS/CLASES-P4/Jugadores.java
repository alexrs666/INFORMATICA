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
public class Jugadores extends Empleado {
    private int numPartidos;
    private int numGoles;

    public Jugadores(int numPartidos, int numGoles, String nombre, double sueldo, int antiguedad) {
        super(nombre, sueldo, antiguedad);
        setNumPartidos(numPartidos);
        setNumGoles(numGoles);
    }

    public int getNumPartidos() {
        return numPartidos;
    }

    public void setNumPartidos(int numPartidos) {
        this.numPartidos = numPartidos;
    }

    public int getNumGoles() {
        return numGoles;
    }

    public void setNumGoles(int numGoles) {
        this.numGoles = numGoles;
    }
    public double calcularEfectividad(){
        return (double)((getNumPartidos()*getNumGoles())/getAntiguedad());
    }
    public double calcularSueldoAcobrar(){
        double sueldoBasico=calcularSueldo();
        if(calcularEfectividad()>0.5)
            return sueldoBasico*2;
        else
            return sueldoBasico;
    }
    public String toString() {
        return "Jugadores{" + "numPartidos=" + numPartidos + ", numGoles=" + numGoles + " info sobre los datos del empleado:"+super.toString();
    }
}
