/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PARCIAL4;

/**
 *
 * @author Usuario
 */
public class Terminal {
    private String nombre;
    private String direccion;
    private Contenedor [][] almacen;
    private int DB,DP;

    public Terminal(String nombre, String direccion,int X,int Y) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.DB = X;
        this.DP = Y;
        this.almacen = new Contenedor[this.DB][this.DP];
        for(int i=0;i<this.DB;i++){
            for(int j=0;j<this.DP;j++){
                this.almacen[i][j]=null;
            }
        }
    }
    public void registrarContenedor(Contenedor contenedor,int posX,int posY){
        this.almacen[posX-1][posY-1] = contenedor;
    }
    public String retirarContenedor(int bloqueX,int CanDias){
        String aux="";
        for(int j=0;j<this.DP; j++){
            if(this.almacen[bloqueX-1][j]!= null) {
                if(this.almacen[bloqueX-1][j].getCantDias()>CanDias){
                    aux += "Retirado: " + this.almacen[bloqueX-1][j].toString()+"\n";
                    this.almacen[bloqueX-1][j] = null; 
                }
            }
        }
        return aux;
    }
    public int nroBloqueMasLibre(){
        
        int posMin=0;
        int max=-1;
        for(int i=0;i<this.DB;i++){
            int contador=0;
            for(int j=0;j<this.DP;j++){
                if(this.almacen[i][j]==null)
                    contador++;
            }
            if(contador>max){
                max=contador;
                posMin=i;
            }
        }
        return posMin+1;
    }
    public String toString(){
        String aux="terminal:"+nombre+";"+direccion+"\n";
        for(int i=0;i<this.DB;i++){
            aux+="bloque:"+(i+1)+"\n";
            for(int j=0;j<this.DP;j++){
                if(this.almacen[i][j] == null)
                    aux+="posicion:"+(j+1)+" Sin contenedor"+"\n";
                else
                    aux+="posicion:"+(j+1)+this.almacen[i][j].toString()+"\n";
            }
        }
        return aux;
    }
    
}
