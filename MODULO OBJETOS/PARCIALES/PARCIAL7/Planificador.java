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
public class Planificador {
    private String nombreClub;
    private Director directorClub;
    private Profesor[][] tabla;
    private int DC,DF;

    public Planificador(String nombreClub, Director directorClub, int tipoEntrenamiento, int turno) {
        this.nombreClub = nombreClub;
        this.directorClub = directorClub;
        this.DC = tipoEntrenamiento;
        this.DF = turno;
        this.tabla = new Profesor[this.DC][this.DF];
        for(int i=0;i<this.DC;i++){
            for(int j=0;j<this.DF;j++){
                this.tabla[i][j]=null;
            }
        }
    }
    public boolean asignarProfesor(Profesor profe,int tipoEntrenamiento,int turno){
        boolean asignar=false;
        if(this.tabla[tipoEntrenamiento-1][turno-1]==null){
            this.tabla[tipoEntrenamiento-1][turno-1] = profe;
            asignar=true;
        }
        return asignar;   
    }
    public Profesor calcularMejorProfe(){
        int min=9999;
        Profesor mejor=null;
        for(int i=0;i<this.DC;i++){
            for(int j=0;j<this.DF;j++){
                if(this.tabla[i][j]!=null){
                    int nivel = this.tabla[i][j].getNivelITN();
                    if(nivel<min){
                       min=nivel;
                       mejor=this.tabla[i][j];
                    }
                      
                }
            }
        }
        return mejor;
    }
    public String representacion(Profesor profe,Director dire){
        String aux="";
        aux+=dire.toString()+"\n";
        aux+=profe.toString()+"\n";
        return aux;
    }
    public String toString(){
        String aux="Club:"+nombreClub+"\n";
        aux+="Director:"+directorClub.toString()+"\n";
        for(int i=0;i<this.DC;i++){
            aux+="tipo entrenamiento #"+(i+1)+"\n";
            for(int j=0;j<this.DF;j++){
                if(this.tabla[i][j]!=null)
                    aux+="turno:"+(j+1)+this.tabla[i][j].toString()+"\n";
                else
                    aux+="turno:"+(j+1)+" Sin Profesor"+"\n";
            }
        }
        return aux+ this.calcularMejorProfe().toString();
    }
}
