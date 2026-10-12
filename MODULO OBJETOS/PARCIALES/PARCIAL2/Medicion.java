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
public class Medicion{
    private int numMedidor;
    private int dniCli;
    private int cantM3Consumidos;
    private boolean consumoSuperaAño;

    public Medicion(int numMedidor, int dniCli, int cantM3Consumidos,boolean supera) {
        this.numMedidor = numMedidor;
        this.dniCli = dniCli;
        this.cantM3Consumidos = cantM3Consumidos;
        this.consumoSuperaAño = supera;
    }
    
    public boolean getConsumoSuperaAño(){
        return consumoSuperaAño; 
    }
    public String toString() {
        return "Medicion{" + "numMedidor=" + numMedidor + ", dniCli=" + dniCli + ", cantM3Consumidos=" + cantM3Consumidos + ", ConsumoSuperaA\u00f1o=" + consumoSuperaAño + '}';
    }
    
}
