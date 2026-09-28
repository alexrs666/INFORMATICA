/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practicas_java;

/**
 *
 * @author AlexRs
 */
public class Hotel {
    private int DF;
    private int DL;
    private Habitacion[] habitacion;
    
    public Hotel(int N) {
        DF=N;
        DL=0;
        habitacion= new Habitacion[DF];
            for(int i=0;i<DF;i++){
                habitacion[i] = new Habitacion();
            }
    }
    public void agregarCliente(Persona cliente,int numX){
        habitacion[numX-1].setCliente(cliente);
        habitacion[numX-1].setOcupacion(true);
        DL++;
    }
    public void aumentarCosto(double montoExtra){
        for(int i=0;i<DF;i++){
            double montoActual = habitacion[i].getCosto();
            habitacion[i].setCosto(montoActual + montoExtra);
        }
    }
    public int cantHabitaciones(){
        return DL;
    }
    public boolean estaLleno(){
        return DL==DF;
    }
    public String toString() {
        String aux = "";
        for (int i = 0; i < DF; i++) {
            aux += "{Habitación " + (i + 1) + ": costo $" + habitacion[i].getCosto();
            if (habitacion[i].getOcupacion()) {
                   aux += ", ocupada, Cliente: " + habitacion[i].getCliente().toString() + "}\n";
            } else {
                   aux += ", libre}\n"; 
            }
        }
        return aux;
    }
}
