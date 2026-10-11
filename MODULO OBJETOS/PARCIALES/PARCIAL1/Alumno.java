/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PARCIAL1;

/**
 *
 * @author Usuario
 */
public class Alumno {
    private String nombre;
    private int cantTareas;
    private int sumaTotalNotas;

    public Alumno(String nombre) {
        this.nombre = nombre;
        this.cantTareas = 0;
        this.sumaTotalNotas = 0;
    }

    public int getSumaTotalNotas() {
        return sumaTotalNotas;
    }

    public int getCantTareas() {
        return cantTareas;
    }
    public String getNombre(){
        return nombre;
    }
    public void actualizarRendimiento(double nota){
        this.cantTareas++;
        this.sumaTotalNotas += nota;
    }
    public double calcularPromedio(){
        return this.sumaTotalNotas/this.cantTareas;   
    }
    
    public String toString(){
        return "nombre:"+getNombre()+" cant Tareas completadas:"+getCantTareas()+" suma total notas:"+getSumaTotalNotas();
    } 
}
