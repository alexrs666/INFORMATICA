/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PARCIAL6;

/**
 *
 * @author Usuario
 */
public class Concurso {
    private int DC,DF;
    private Cancion[][]canciones;
    private int[]DL;

    public Concurso(int DC, int DF) {
        this.DC = DC;
        this.DF = DF;
        this.canciones = new Cancion[this.DC][this.DF];
        this.DL = new int[this.DC];
        for(int i=0;i<this.DC;i++){
           this.DL[i]=0;
        }
    }
    public void agregarNuevaCancion(int categoria,Cancion cancion){
        this.canciones[categoria-1][this.DL[categoria-1]++]=cancion;
    }
    public void BuscarActualizarCancion(int codigoIde,Estudiante estudiante,double puntaje){
        int i=0;
        boolean encontre=false;
        while(i<this.DC && !encontre){
            int j=0;
            while(j<this.DL[i] && !encontre){
                if(this.canciones[i][j].getIdentificador() == codigoIde){
                    this.canciones[i][j].actualizarCancion(estudiante, puntaje);
                    encontre=true;
                }
                j++;
            }
            i++;
        }
    }
    public Estudiante BuscarCancionConInterprete(int codigoIde){
        int i=0;
        boolean encontre=false;
        Estudiante e1=null;
        while(i<this.DC && !encontre){
            int j=0;
            while(j<this.DL[i] && !encontre){
                if(this.canciones[i][j].getIdentificador() == codigoIde){
                    e1 = this.canciones[i][j].getMejorInterprete();
                    encontre=true;
                }
                j++;
            }
            i++;
        }
        return e1;
    }
    public Cancion cancionConMayorPuntaje(int categoria){
        Cancion maxCancion=null;
        double max=-1;
        for(int j=0;j<this.DL[categoria-1];j++){
            double puntajeAct=this.canciones[categoria-1][j].getPuntajeOtorgado();
            if(puntajeAct>max){
               max=puntajeAct;
               maxCancion=this.canciones[categoria-1][j];
            }
        }
        return maxCancion;
    }
}
