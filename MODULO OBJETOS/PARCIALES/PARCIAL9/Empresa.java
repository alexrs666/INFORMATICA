/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PARCIAL9;

/**
 *
 * @author Usuario
 */
public class Empresa {
    private String nombre;
    private String direccion;
    private double costoPorMes;
    private Cliente[][] almacen;
    private int DS,DB;
    private int DL;

    public Empresa(String nombre, String direccion, double costoPorMes, int DS, int DB) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.costoPorMes = costoPorMes;
        this.DS = DS;
        this.DB = DB;
        this.DL= 0;
        this.almacen=new Cliente[this.DS][this.DB];
    }
    private boolean estaLleno(){
        return this.DL == this.DS *this.DB;
    }
    public void ingresarCliente(Cliente cli){
        if(!estaLleno()){
            this.almacen[this.DL/this.DB][this.DL%this.DB] = cli;
            this.DL++;
        }
    }
    public String listarClientes(String localidad,int sectorX){
        String aux="";
        
        for(int j=0;j<this.DL;j++){
            int f= j/this.DB;
            int c= j%this.DB;
            if(f == (sectorX-1)){
                if(this.almacen[sectorX-1][j].getLocalidad().equals(localidad)){
                   aux+=this.almacen[sectorX-1][j].toString()+"\n";
                }
            }
        }
        return aux;
    }
    public int nroSectorConMasClientes(){
        int [] contador=new int[this.DS];
        for(int i=0;i<this.DS;i++)contador[i]=0;
        for(int i=0;i<this.DL;i++){
            int f= i/this.DB;
            int c= i%this.DB;
                if(this.almacen[f][c].isSeguro())
                    contador[f]++;
        }
        int max=-1;
        int maxSector=0;
        for(int i=0;i<this.DS;i++){
            if(contador[i]>max){
                max=contador[i];
                maxSector=i;
            }
        }
        return maxSector+1;
    }
    public String toString(){
        String aux= "Empresa:"+nombre+" -"+direccion+";"+" Costo por mes:"+costoPorMes+"\n";
        for(int i=0;i<this.DS;i++){
            aux+="Sector:"+(i+1)+"\n";
            for(int j=0;j<this.DB;j++){
                if(this.almacen[i][j]!=null)
                    aux+="Baulera:"+(j+1)+this.almacen[i][j].toString()+"\n";
            }
        }
        return aux;
    }
    
}
