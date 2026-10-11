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
public class CursoBasico extends Curso {

    public CursoBasico(String nombre, double costoInscriptos, String fechaComienzo, int M) {
        super(nombre, costoInscriptos, fechaComienzo, M);
    }
    
    public String alumnoMejorDesempeño(){
        String mejorAlum ="";
        int maxAlum = -1;
        for(int i=0;i<this.getDL();i++){
            Alumno alum= this.obtenerAlumno(i);
            if(alum.getCantTareas()>maxAlum){
                maxAlum = alum.getCantTareas();
                mejorAlum = alum.toString();
            }
        }
        return mejorAlum;
    }
    
}
