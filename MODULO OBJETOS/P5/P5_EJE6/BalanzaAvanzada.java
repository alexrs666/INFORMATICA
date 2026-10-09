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
public class BalanzaAvanzada extends BalanzaBasica{
    private int cantF,cantV;
    
    public BalanzaAvanzada() {
        super();
        this.cantF = 0;
        this.cantV = 0;
    }
    public void reiniciarBalanza(){
        super.reiniciarBalanza();
        this.cantF=0;
        this.cantV=0;
    }
    public void registrarProducto(Producto producto){
        super.registrarProducto(producto);
        if(producto.getRubro().equals("verdura"))
           cantV++;
        else
           cantF++;
    }
    public String finalizarCompra(){
        String aux = super.finalizarCompra()+"\n";
        aux+="cantidad frutas:"+this.cantF+"\n";
        aux+="cantidad verduras:"+this.cantV+"\n";
        return aux;
    }
}
