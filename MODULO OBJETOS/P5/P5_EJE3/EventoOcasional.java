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
public class EventoOcasional extends Recital{
    private String motivo;
    private String nomContratante;
    private Fecha dia;

    public EventoOcasional(String motivo, String nomContratante, Fecha dia, String nombreBanda, int cantTem) {
        super(nombreBanda, cantTem);
        setMotivo(motivo);
        setNomContratante(nomContratante);
        setDia(dia);
    }
    
    public double calcularCosto(){
        double montoTot=0;
        String eventos [] = {"a beneficio","show de TV","show privado"};
        if(getMotivo().equals(eventos[1]))
            montoTot +=50000;
        else if(getMotivo().equals(eventos[2]))
            montoTot += 150000;
      
        return montoTot;
    }
    public void actuacion(){
        String eventos [] = {"a beneficio","show de TV","show privado"};
        if(getMotivo().equals(eventos[0]))
            System.out.println("Recuerden colaborar con:"+getNomContratante());
        else if(getMotivo().equals(eventos[1]))
            System.out.println("Saludos amigos televidentes");
        else
            System.out.println("Un feliz cumpleaños para:"+getNomContratante());
        
        super.actuacion();
    }
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getNomContratante() {
        return nomContratante;
    }

    public void setNomContratante(String nomContratante) {
        this.nomContratante = nomContratante;
    }

    public Fecha getDia() {
        return dia;
    }

    public void setDia(Fecha dia) {
        this.dia = dia;
    }
}
