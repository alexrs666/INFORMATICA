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
public class OrdenMedicamento extends Orden{
    private String codigoFarmacia;
    private Medicamento[] medicamentos;
    private final int DF=5;
    private int DL;

    public OrdenMedicamento(String codigoFarmacia,int nroAfiliado, String diagnostico, String matricula, int categoria, String fechaEmision) {
        super(nroAfiliado, diagnostico, matricula, categoria, fechaEmision);
        this.codigoFarmacia = codigoFarmacia;
        this.DL = 0;
        this.medicamentos = new Medicamento[this.DF];
    }
    public boolean estaLleno(){
        return this.DL == this.DF;
    }
    public void agregarMedicamento(Medicamento medi){
       if(!estaLleno())
          this.medicamentos[this.DL++]=medi;
    }
    public double montoTotalAbonado(){
        double total=super.montoTotalAbonado();
        for(int i=0;i<this.DL;i++){
            total+=this.medicamentos[i].getCostoAbonado();
        }
        return total;
    }
    
}
