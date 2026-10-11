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
public abstract class Curso {
    private String nombre;
    private double costoInscriptos;
    private String fechaComienzo;
    private Alumno [] alumnos;
    private int DL,DF;
    
    public Curso(String nombre, double costoInscriptos, String fechaComienzo , int M) {
        this.nombre = nombre;
        this.costoInscriptos = costoInscriptos;
        this.fechaComienzo = fechaComienzo;
        this.DL =0;
        this.DF =M;
        this.alumnos = new Alumno[this.DF];
    }
    public int inscribirAlumno(Alumno alumno){
        this.alumnos[this.DL++] = alumno;
        return this.DL;
    }
    public Alumno obtenerAlumno(int pos){
        return this.alumnos[pos-1];
    }
    public void actualizarRendimiento(String nombre,int notaX){
        boolean encontre=false;
        int i=0;
        while(i<this.DL && !encontre){
            if(this.alumnos[i].getNombre().equals(nombre)){
                this.alumnos[i].actualizarRendimiento(notaX);
                encontre=true;
            }
            i++;
        }
    }
    public int getDL(){
        return this.DL;
    }
    public abstract String alumnoMejorDesempeño();
    public String toString(){
        String aux= "nombre curso:"+this.nombre + " costo inscripcion:"+this.costoInscriptos+" fecha comienzo:"+this.fechaComienzo+"\n";
        
        aux+="este es el alumno con mejor desempeño:"+this.alumnoMejorDesempeño();
        
        return aux;
    }
}
