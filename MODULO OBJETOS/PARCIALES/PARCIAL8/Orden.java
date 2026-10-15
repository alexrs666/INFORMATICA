/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PARCIAL8;

/**
 *
 * @author Usuario
 */
public abstract class Orden {
    private int nroAfiliador;
    private String diagnostico;
    private String matricula;
    private int categoria;
    private String fechaEmision;

    public Orden(int nroAfiliador, String diagnostico, String matricula, int categoria, String fechaEmision) {
        this.nroAfiliador = nroAfiliador;
        this.diagnostico = diagnostico;
        this.matricula = matricula;
        this.categoria = categoria;
        this.fechaEmision = fechaEmision;
    }
    
    public double montoTotalAbonado(){
        double aux=0;
        if(this.categoria == 1)
            aux+=2000;
        else if(this.categoria ==2)
            aux+=3500;
        else
            aux+=5000;
        
        return aux;
    }
    public String toString() {
        return "Orden{" + "nroAfiliador=" + nroAfiliador + ", diagnostico=" + diagnostico + ", matricula=" + matricula + ", categoria=" + categoria + ", fechaEmision=" + fechaEmision + " monto Total:"+this.montoTotalAbonado();
    }
    public boolean seguimiento(){    
        return this.montoTotalAbonado()>100000;
    }
    
}
