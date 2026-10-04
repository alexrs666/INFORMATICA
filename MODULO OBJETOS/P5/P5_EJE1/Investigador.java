/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practicas_java.Practica_5.P5_EJE1_JAVA;

/**
 *
 * @author AlexRs
 */
public class Investigador {
    private final int DF=5;
    private int DL;
    private Subsidio []subsidio;
    private String nomCompleto;
    private int categoria;
    private String especialidad;
    
    public Investigador(String nomCompleto, int categoria, String especialidad) {
        setNomCompleto(nomCompleto);
        setCategoria(categoria);
        setEspecialidad(especialidad);
        this.DL = 0;
        subsidio = new Subsidio[this.DF];
    }
    public void agregarSubsidio(Subsidio subsidio){
        if(!subsidioLleno())
            this.subsidio[this.DL++] = subsidio;
        else
           System.out.println("se a excesido la cantidad de subsidio a pedir");
    }
    public boolean subsidioLleno(){
        return DL == DF;
    }
    public double dineroOtorgado(){
        double total=0;
        for(int i=0;i<this.DL;i++){
            if(subsidio[i].getOtorgado())
               total+=subsidio[i].getMonto();
        }
        return total;
    }
    public void otorgarSubsidio(){
        for(int i=0;i<this.DL;i++){
            if(!subsidio[i].getOtorgado()){
                subsidio[i].setOtorgado(true);
            }
        }
    }
    public String getNomCompleto() {
        return nomCompleto;
    }

    public void setNomCompleto(String nomCompleto) {
        this.nomCompleto = nomCompleto;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public String toString() {
        return "Investigador{" + "nomCompleto=" + getNomCompleto() + ", categoria=" + getCategoria() + ", especialidad=" + getEspecialidad() + "total dinero de subsidios="+dineroOtorgado();
    }
}
