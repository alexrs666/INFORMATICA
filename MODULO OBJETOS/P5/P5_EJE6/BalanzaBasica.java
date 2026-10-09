/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJERCICIO6;

/**
 *
 * @author Usuario
 */
public class BalanzaBasica {
    private int DL;
    private final int DF=30;
    private int nroCompraAct;
    private Producto[] producto;

    public BalanzaBasica() {
        this.DL = 0;
        this.nroCompraAct = 1;
        this.producto = new Producto[this.DF];
    }
    public void reiniciarBalanza(){
        this.nroCompraAct++;
        for(int i=0;i<this.DL;i++){
            this.producto[i]=null;
        }
        this.DL=0;
    }
    public void registrarProducto(Producto producto){
        this.producto[this.DL++]=producto ;
    }
    public double montoTotal(){
        double montoTot=0;
        for(int i=0;i<this.DL;i++){
            montoTot+=(this.producto[i].precioFinal());
        }
        return montoTot;
    }
    public String finalizarCompra(){
        String aux="nro de compra:"+this.nroCompraAct+"\n";
        for(int i=0;i<this.DL;i++){
            aux+="resumen:"+this.producto[i].toString()+"\n";
        }
        return aux+=this.montoTotal();
    }
    
}
