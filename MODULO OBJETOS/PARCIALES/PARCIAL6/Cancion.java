/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PARCIAL6;

/**
 *
 * @author Usuario
 */
public class Cancion {
    private String nombre;
    private String compositor;
    private int identificador;
    private Estudiante mejorInterprete;
    private double puntajeOtorgado;

    public Cancion(String nombre, String compositor, int identificador) {
        this.nombre = nombre;
        this.compositor = compositor;
        this.identificador = identificador;
        this.mejorInterprete = null;
        this.puntajeOtorgado = 0;
    }

    public void setPuntajeOtorgado(double puntajeOtorgado) {
        this.puntajeOtorgado = puntajeOtorgado;
    }

    public double getPuntajeOtorgado() {
        return puntajeOtorgado;
    }

    public void setMejorInterprete(Estudiante mejorInterprete) {
        this.mejorInterprete = mejorInterprete;
    }

    public Estudiante getMejorInterprete() {
        return mejorInterprete;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCompositor() {
        return compositor;
    }
    
    public void actualizarCancion(Estudiante estudiante,double puntaje){
        Estudiante actual= this.mejorInterprete;
        if(puntaje>this.puntajeOtorgado){
            setMejorInterprete(estudiante);
            setPuntajeOtorgado(puntaje);
        }
    }
    public String toString() {
        return "Cancion{" + "nombre=" + nombre + ", compositor=" + compositor + ", identificador=" + identificador + ", mejorInterprete=" + mejorInterprete + ", puntajeOtorgado=" + puntajeOtorgado + '}';
    }
    
    
    
    
}
