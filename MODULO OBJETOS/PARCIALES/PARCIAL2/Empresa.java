/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PARCIAL2;

/**
 *
 * @author Usuario
 */
public class Empresa{
    private String nombre;
    private Zona[] zonas;
    private final int DF =7;
    private int DL;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.DL = 0;
        this.zonas = new Zona[this.DF];
        for(int i=0;i<this.DF;i++){
            this.zonas[i] = null;
        }
    }
    public void agregarZona(Zona zona){
        this.zonas[this.DL++] = zona;
    }
    public void agregarZona2(int Z,Medicion medicion){
        this.zonas[Z-1].agregarMedicion(medicion);
    }
    public int zonaMayorCantMediciones(){
        int max=-1;
        int MaxZona=0;
        for(int i=0;i<this.DL;i++){
            int maxZ=this.zonas[i].cantTotalMediciones();
            if(maxZ >max){
                max =maxZ;
                MaxZona = i;
            }
        }
        return MaxZona + 1;
    }
    public String toString(){
        String aux="empresa:"+this.nombre+" cantidad de zonas"+this.DL+"\n";
        for(int i=0;i<this.DL;i++){
            aux+="zona"+(i+1)+" :"+this.zonas[i].toString()+"\n";
        }
        return aux;
    }
}
