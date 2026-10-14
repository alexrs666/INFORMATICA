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
public class Evento{
    private String tematica;
    private String fecha;
    private double montoPremio;
    private Laboratorio lab1;
    private Laboratorio lab2;

    public Evento(String tematica, String fecha, double montoPremio, Laboratorio lab1, Laboratorio lab2) {
        this.tematica = tematica;
        this.fecha = fecha;
        this.montoPremio = montoPremio;
        this.lab1 = lab1;
        this.lab2 = lab2;
    }
    public String agregarLab(Programador programador){
        if(this.lab1.asientosLibre()>=this.lab2.asientosLibre())
            return this.lab1.agregarProgramador(programador);
        else
            return this.lab2.agregarProgramador(programador);
    }
    public void asignarAños(int DNI, int años){
        this.lab1.asignarAños(DNI, años);
        this.lab2.asignarAños(DNI, años);
    }
    public int canTotalLenguaje(String lenguaje){
        return this.lab1.cantLenguaje(lenguaje) + this.lab2.cantLenguaje(lenguaje);
    }
    public String toString(){
        String aux=" :"+tematica+"-"+fecha+"-$"+montoPremio+"\n";
        aux+=this.lab1.toString()+"\n";
        aux+=this.lab2.toString()+"\n";
        return aux;
    }
}
