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
public class OrdenPractica extends Orden{
    private String nombre;
    private double costoAbonado;
    private int CodigoInstitucion;

    public OrdenPractica(String nombre, double costoAbonado, int CodigoInstitucion, int nroAfiliador, String diagnostico, String matricula, int categoria, String fechaEmision) {
        super(nroAfiliador, diagnostico, matricula, categoria, fechaEmision);
        this.nombre = nombre;
        this.costoAbonado = costoAbonado;
        this.CodigoInstitucion = CodigoInstitucion;
    }
    public double montoTotalAbonado(){
        return this.costoAbonado + super.montoTotalAbonado();
    }
}
