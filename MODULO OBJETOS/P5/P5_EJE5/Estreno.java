/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practicas_java.Practica_5.P5_EJE5_JAVA;

/**
 *
 * @author AlexRs
 */
public class Estreno {
    private String titulo;
    private String contenido;
    private double recaudacion;
    private int visualizacion;

    public Estreno(String titulo, String contenido, double recaudacion, int visualizacion) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.recaudacion = recaudacion;
        this.visualizacion = visualizacion;
    }

    public double getRecaudacion() {
        return recaudacion;
    }

    public String toString() {
        return "Estreno{" + "titulo=" + titulo + ", contenido=" + contenido + ", recaudacion=" + recaudacion + ", visualizacion=" + visualizacion + '}';
    }
}