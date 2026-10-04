/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practicas_java.Practica_5.P5_EJE3_JAVA;

/**
 *
 * @author AlexRs
 */
public abstract class Recital {
    private String nombreBanda;
    private String temas[];
    private int DL;

    public Recital(String nombreBanda, int cantTem) {
        setNombreBanda(nombreBanda);
        this.DL = 0;
        this.temas = new String [cantTem];
    }
    public void agregarTema(String tema){
        if(this.DL<this.temas.length)
            this.temas[this.DL++] = tema;
    }
    
    public void actuacion(){
        for(int i=0; i<this.temas.length;i++)
            System.out.println("somos:"+getNombreBanda()+" y a continuacion tocaremos:"+this.temas[i]);
    }
    
    public String getNombreBanda() {
        return nombreBanda;
    }

    public void setNombreBanda(String nombreBanda) {
        this.nombreBanda = nombreBanda;
    }
}
