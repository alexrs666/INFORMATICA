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
public abstract class Estacion {
    private String nombre;
    private double longitud;
    private double latitud;
    private int A,N;
    private double [][] temperatura;
    //INCISO A
    public Estacion(String nombre, double longitud, double latitud,int A,int N) {
        setNombre(nombre);
        setLongitud(longitud);
        setLatitud(latitud);
        setA(A);
        setN(N);
        this.temperatura = new double[this.N][12];
        for(int i=0;i<this.N; i++){
            for (int j=0;j<12;j++){
                temperatura[i][j]=99;
            }
        }
    }
    //INCISO B
    public void registrarTemp(int año,int mes,double temperatura){
        año -= getA();
        this.temperatura[año][mes-1]=temperatura;
    }
    //INCISO C
    public double obtenerTemp(int año,int mes){
        año -= getA();
        return this.temperatura[año][mes-1];
    }
    //INCISO D
    public String devolverMayorTemp(){
        double max=-1.0;
        String maxTemp="";
        for(int i=0;i<getN();i++){
            for(int j=0;j<12;j++){
                if(temperatura[i][j]>max){
                    max=temperatura[i][j];
                    maxTemp = "este mes:"+(j+1)+" este año :"+(i+getA())+"se registro la mayor temperatura:"+max+" grados"; 
                }
            }
        }
        return maxTemp;
    }
    public int getA() {
        return A;
    }

    public void setA(int A) {
        this.A = A;
    }

    public int getN() {
        return N;
    }

    public void setN(int N) {
        this.N = N;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public String toString() {
        String aux;
        aux= "Estacion{" + "nombre=" +getNombre()+ ", latitud=" +getLatitud()+ ", longitud=" + getLongitud();
        return aux +"promedios:"+"\n"+this.reportePromedios();
    }
    public abstract String reportePromedios();
}
