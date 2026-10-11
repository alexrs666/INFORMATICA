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
public class CursoAvanzado extends Curso {
    private String conocimientoPrevio;
    
    public CursoAvanzado(String nombre, double costrInscriptos, String fechaComienzo,String conocimientoPrevio, int M) {
        super(nombre, costrInscriptos, fechaComienzo, M);
        this.conocimientoPrevio = conocimientoPrevio;
    }
    public String alumnoMejorDesempeño(){
        double maxAlum = -1;
        String mejorAlumno ="";
        for(int i=0;i<this.getDL();i++){
            Alumno alum= this.obtenerAlumno(i);
            if(alum.calcularPromedio()>maxAlum){
                maxAlum = alum.getSumaTotalNotas();
                mejorAlumno = alum.toString();
            }
        }
        return mejorAlumno;
    }
}
