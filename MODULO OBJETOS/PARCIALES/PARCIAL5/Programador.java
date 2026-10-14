/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PARCIAL5;

/**
 *
 * @author Usuario
 */
public class Programador {
    private int DNI;
    private String nombreCompleto;
    private int añosExp;
    private String lenguaje;

    public Programador(int DNI, String nombreCompleto, String lenguaje) {
        this.DNI = DNI;
        this.nombreCompleto = nombreCompleto;
        this.añosExp = 0;
        this.lenguaje = lenguaje;
    }

    public String getLenguaje() {
        return lenguaje;
    }
    
    public int getDNI() {
        return DNI;
    }

    public void setAñosExp(int añosExp) {
        this.añosExp = añosExp;
    }
    
    public String toString() {
        return "Programador{" + "DNI=" + DNI + ", nombreCompleto=" + nombreCompleto + ", a\u00f1osExp=" + añosExp + ", lenguaje=" + lenguaje + '}';
    }
    
}
