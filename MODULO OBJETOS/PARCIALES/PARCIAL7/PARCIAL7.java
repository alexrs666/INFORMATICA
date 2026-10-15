/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PARCIAL7;

/**
 *
 * @author Usuario
 */
public class PARCIAL7 {
    public static void main(String[]args){
        Director d = new Director(123,"facu",123,"4 trofeos","14/07/2022");
    
         Planificador plani= new Planificador("Polo",d,3,3);
    
        Profesor p1= new Profesor(111,"Cerrundolo Francisco",432,"5 trofeos ATP",1);
        Profesor p2= new Profesor(111,"Cerrundolo Francisco",432,"5 trofeos ATP",1);
        Profesor p3= new Profesor(111,"Cerrundolo Francisco",432,"5 trofeos ATP",1);
        Profesor p4= new Profesor(111,"Cerrundolo Francisco",432,"5 trofeos ATP",1);
        Profesor p5= new Profesor(111,"Cerrundolo Francisco",432,"5 trofeos ATP",1);
    
        plani.asignarProfesor(p1,1,1);
        plani.asignarProfesor(p2,1,2);
        plani.asignarProfesor(p3,1,3);
        plani.asignarProfesor(p4,2,1);
        plani.asignarProfesor(p5,2,2);
        
        System.out.println(plani.representacion(p5, d));
        System.out.println(plani.toString());
        
    }
}
