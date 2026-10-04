/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practicas_java.Practica_5.P5_EJE2_JAVA;

/**
 *
 * @author AlexRs
 */
public class Estacionamiento {
    private String nombre;
    private String direccion;
    private String horaApertura,horaCierre;
    private Auto piso[][];
    private int N,M;
    
    public Estacionamiento(String nombre,String direccion){
        setNombre(nombre);
        setDireccion(direccion);
        this.horaApertura = "8:00";
        this.horaCierre = "21:00";
        this.N = 5;
        this.M = 10;
        piso = new Auto[this.N][this.M];
        for (int i = 0; i < this.N; i++){
            for(int j = 0; j < this.M; j++){
                piso[i][j] = null;
            }
        }
    }
    public Estacionamiento(String nombre,String direccion,String horaApertura,String horaCierre,int N,int M){
        setNombre(nombre);
        setDireccion(direccion);
        setHoraApertura(horaApertura);
        setHoraCierre(horaCierre);
        this.N = N;
        this.M = M;
        piso = new Auto[this.N][this.M];
        for (int i = 0; i < this.N; i++){
            for(int j = 0; j < this.M; j++){
                piso[i][j] = null;
            }
        }
    }
    public void registrarAuto(int X,int Y,Auto auto){
        this.piso[X-1][Y-1] = auto;
    }        
    public String obtenerEstacio(String patente){
        for(int i=0;i<this.N;i++){
            for(int j=0;j<this.M;j++){
                if(this.piso[i][j]!=null && this.piso[i][j].getPatente().equals(patente))
                    return "en este piso:"+(i+1)+"en esta plaza:"+(j+1)+"se encuentra el auto";
            }
        }
        
        return "Auto inexistente";
    }
    
    public String toString(){
        String aux="\n";
        for(int i=0;i<this.N;i++){
            for(int j=0;j<this.M;j++){
                if(piso[i][j]!=null)
                    aux+= "piso"+(i+1)+" plaza:"+(j+1)+piso[i][j].toString()+"\n";
                else
                    aux+="libre\n";
            }
        }
        return aux;
    }
    
    public int obtenerCantidad(int Y){
        int cantA=0;
        for(int i=0;i<this.N;i++){
            if(this.piso[i][Y-1]!=null)
                cantA++;
        }
        return cantA;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(String horaApertura) {
        this.horaApertura = horaApertura;
    }

    public String getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(String horaCierre) {
        this.horaCierre = horaCierre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
