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
public class Proyecto {
    private String nomProyecto;
    private String nomComDirector;
    private int codigo;
    private Investigador[] investigador;
    private final int DF=50;
    private int DL;

    public Proyecto(String nomProyecto, String nomComDirector, int codigo) {
        setNomProyecto(nomProyecto);
        setNomComDirector(nomComDirector);
        setCodigo(codigo);
        this.DL = 0;
        investigador = new Investigador[this.DF];
    }
    
    public void agregarInvestigador(Investigador investigador){
        if(!investigadorLleno())
            this.investigador[this.DL++] = investigador;
        else
            System.out.println("se excedio la cantidad de investigadores");
    }
    public boolean investigadorLleno(){
        return DL == DF;
    }
    public double dineroTotalOtorgado(){
        double total=0;
        for(int i=0;i<this.DL;i++){
            total += investigador[i].dineroOtorgado();
        }
        return total;
    }
    
    public void otorgarTodos(String nombre_completo){
        int i=0;
        while(i<this.DL && !this.investigador[i].getNomCompleto().equals(nombre_completo)){
            i++;
        }
        if(i<this.DL){
            this.investigador[i].otorgarSubsidio();
            System.out.println("se le otorgo un subsidio a este investigador :" + nombre_completo);
        }else
            System.out.println("no se encontro a:"+nombre_completo);
    }
    
    public String toString(){
        String aux = "nombre proyecto:"+getNomProyecto() + " codigo:"+getCodigo()+"nombre del director:"+getNomComDirector()+"\n";
        for(int i=0;i<this.DL;i++){
            aux+= this.investigador[i].toString()+"\n";
        }
        return aux;
    }
    
    public String getNomProyecto() {
        return nomProyecto;
    }

    public void setNomProyecto(String nomProyecto) {
        this.nomProyecto = nomProyecto;
    }

    public String getNomComDirector() {
        return nomComDirector;
    }

    public void setNomComDirector(String nomComDirector) {
        this.nomComDirector = nomComDirector;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
