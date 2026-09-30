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
public class Entrenadores extends Empleado {
    private int campeonatosGanados;

    public Entrenadores(int campeonatosGanados, String nombre, double sueldo, int antiguedad) {
        super(nombre, sueldo, antiguedad);
        setCampeonatosGanados(campeonatosGanados);
    }
    public int getCampeonatosGanados() {
        return campeonatosGanados;
    }

    public void setCampeonatosGanados(int campeonatosGanados) {
        this.campeonatosGanados = campeonatosGanados;
    }
    
    public double calcularEfectividad(){
        return (double) (getCampeonatosGanados()/getAntiguedad());
    }
    public double calcularSueldoAcobrar(){
        double sueldoBasico=calcularSueldo();
        if(getCampeonatosGanados()>=1 && getCampeonatosGanados()<=4)
            return (sueldoBasico + 5000); 
        else
            if(getCampeonatosGanados()>=5 && getCampeonatosGanados()<=10)
                return (sueldoBasico + 30000);
        else
            if(getCampeonatosGanados()>10)
                return (sueldoBasico + 50000);
        else
            return sueldoBasico;
    }
    public String toString() {
        return "Entrenadores{" + "campeonatosGanados=" + campeonatosGanados + " info sobre los datos del empleado:"+super.toString();
    }
    
}
